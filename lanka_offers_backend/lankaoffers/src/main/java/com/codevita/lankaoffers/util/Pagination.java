package com.codevita.lankaoffers.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author ANOJAN KANESHATHAS
 *
 */
public class Pagination {
	private Integer totalRows;
	private Integer fromRow;
	private Integer toRow;
	private Integer totalPages;
	private Integer currentPage;
	private Integer nextPage;
	
	public final Integer limit = 10;
	public static final String PAGINATION_PARAMETER = "page";

	//CONSTRUCTORS =============================	
	public Pagination(Integer totalRows, Integer fromRow, Integer toRow, Integer totalPages, Integer currentPage,
			Integer nextPage) {
		super();
		this.totalRows = totalRows;
		this.fromRow = fromRow;
		this.toRow = toRow;
		this.totalPages = totalPages;
		this.currentPage = currentPage;
		this.nextPage = nextPage;
	}

	public Pagination() {
		super();
	}

	//METHODS =========================================
	public static Pagination formulatePaginationObject(HttpServletRequest request)
	{
		int currentPage = 1;
		Pagination p = new Pagination();
		
		try
		{
			if(request.getParameter(Pagination.PAGINATION_PARAMETER) != null)
				currentPage = Integer.parseInt(request.getParameter(Pagination.PAGINATION_PARAMETER).trim());
			
			if(currentPage <= 0)
				currentPage = 1;
		}
		catch(Exception ex)
		{
			currentPage = 1;
		}
		
		p.setCurrentPage(currentPage);
		p.setFromRow((currentPage - 1) * p.getLimit());
		return p;
	}
	
	public static void fillPaginationParams(Pagination pagination,Integer totalRows)
	{
		if(totalRows != null && totalRows >= 0)
		{
			pagination.setTotalRows(totalRows);
			pagination.setToRow(pagination.getFromRow() + pagination.getLimit());
			
			if(pagination.getToRow() > pagination.getTotalRows())
				pagination.setToRow(pagination.getTotalRows());
			
			if(pagination.getFromRow() > pagination.getTotalRows())
				pagination.setFromRow(pagination.getTotalRows());
			
			int totalPages = totalRows/pagination.getLimit();
			if(totalRows/pagination.getLimit() < (Double.parseDouble(totalRows + "")/pagination.getLimit()))
			{
				totalPages = totalRows/pagination.getLimit() + 1;
			}
			
			pagination.setTotalPages(totalPages);
			pagination.setNextPage(pagination.getCurrentPage() < pagination.getTotalPages() ? pagination.getCurrentPage()+1 : pagination.getCurrentPage() );
		}
	}
	
	public static String getPaginationSql(Pagination pagination)
	{
		return " LIMIT " + pagination.getLimit() + " OFFSET " + pagination.getFromRow() + " ";
	}
	
	//GETTERS AND SETTERS =============================	
	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getFromRow() {
		return fromRow;
	}

	public void setFromRow(Integer fromRow) {
		this.fromRow = fromRow;
	}

	public Integer getToRow() {
		return toRow;
	}

	public void setToRow(Integer toRow) {
		this.toRow = toRow;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getLimit() {
		return limit;
	}
}

