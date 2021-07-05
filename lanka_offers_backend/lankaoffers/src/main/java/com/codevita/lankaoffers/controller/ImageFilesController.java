package com.codevita.lankaoffers.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codevita.lankaoffers.entity.Images;
import com.codevita.lankaoffers.service.ImageStorageService;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.GenericResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(AppConstants.BASE_URL)
public class ImageFilesController {
	GenericResult validateResult;
	
	private static final Logger logger = LogManager.getLogger(ImageFilesController.class);
	
	@Autowired
	ImageStorageService imageStorageServices;
	
	//Post Method
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@PostMapping(AppConstants.UPLOAD_IMAGE)
	public Images uploadImage(@RequestParam("image") MultipartFile file) {
	    String picName = imageStorageServices.storeImage(file);

	    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	            .path("/api/v1")
	            .path("/downloadImage/")
	            .path(picName)
	            .toUriString();

	    return new Images(picName, file.getContentType(), fileDownloadUri,
	    		 file.getSize());
	}
		
	//Post Method
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@PostMapping(AppConstants.UPLOAD_MULTYPLE_IMAGES)
	public List<Images> uploadMultipleImages(@RequestParam("images") MultipartFile[] images) {
	    return Arrays.asList(images)
	            .stream()
	            .map(image -> uploadImage(image))
	            .collect(Collectors.toList());
	}

	//Get Method
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@GetMapping(AppConstants.DOWNLOAD_IMAGE)
	public ResponseEntity<Resource> downloadImage(@PathVariable String picName, HttpServletRequest request) {
	    // Load file as Resource
	    Resource resource = imageStorageServices.loadImageAsResource(picName);

	    // Try to determine file's content type
	    String contentType = null;
	    try {
	        contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	    } catch (IOException ex) {
	        logger.info("Could not determine file type.");
	    }

	    // Fallback to the default content type if type could not be determined
	    if(contentType == null) {
	        contentType = "application/octet-stream";
	    }

	    return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(contentType))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; picName=\"" + resource.getFilename() + "\"")
	            .body(resource);
	}
	
	@GetMapping(value = "/zip-download", produces="application/zip")
	public void zipDownload(@RequestParam List<String> name, HttpServletResponse response) throws IOException {
		ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
		for (String fileName : name) {
			FileSystemResource resource = new FileSystemResource(fileName);
			ZipEntry zipEntry = new ZipEntry(resource.getFilename());
			zipEntry.setSize(resource.contentLength());
			zipOut.putNextEntry(zipEntry);
			StreamUtils.copy(resource.getInputStream(), zipOut);
			zipOut.closeEntry();
		}
		zipOut.finish();
		zipOut.close();
		response.setStatus(HttpServletResponse.SC_OK);
		response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "zipFileName" + "\"");
	}

}
