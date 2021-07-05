package com.codevita.lankaoffers.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.codevita.lankaoffers.StorageProperties;
import com.codevita.lankaoffers.util.ImageNotFoundException;
import com.codevita.lankaoffers.util.StorageException;

@Service
public class ImageStorageService {
	
	private final Path imageStorageLocation;
	
	@Autowired
	public ImageStorageService(StorageProperties storageProperties) {
		this.imageStorageLocation = Paths.get(storageProperties.getUpLoadDir())
				.toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.imageStorageLocation);
		} catch (Exception ex) {
			throw new StorageException("Could not create the directory where the uploaded images will be stored.", ex);
		}
	}
	
	public String storeImage(MultipartFile file) {
        // Normalize image name
        String picName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the image's name contains invalid characters
            if(picName.contains("..")) {
                throw new StorageException("Sorry! Imagename contains invalid path sequence " + picName);
            }

            // Copy image to the target location (Replacing existing image with the same name)
            Path targetLocation = this.imageStorageLocation.resolve(picName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return picName;
        } catch (IOException ex) {
            throw new StorageException("Could not store image " + picName + ". Please try again!", ex);
        }
    }

    public Resource loadImageAsResource(String picName) {
        try {
            Path picPath = this.imageStorageLocation.resolve(picName).normalize();
            Resource resource = new UrlResource(picPath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new ImageNotFoundException("Image not found " + picName);
            }
        } catch (MalformedURLException ex) {
            throw new ImageNotFoundException("Image not found " + picName, ex);
        }
    }

}
