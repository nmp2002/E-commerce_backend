package com.ttisv.bean.system;

import java.util.List;

public class PageResponse<T> {
    private List<T> items;
    private long totalItems;
    private int totalPages;
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	public long getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
    
    // getters + setters
}