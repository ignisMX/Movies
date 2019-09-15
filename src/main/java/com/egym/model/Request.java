/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egym.model;

/**
 *
 * @author ignis
 */
public class Request {
    
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private Movie[] data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int totla_pages) {
        this.total_pages = totla_pages;
    }

    public Movie[] getData() {
        return data;
    }

    public void setData(Movie[] data) {
        this.data = data;
    }
    
}
