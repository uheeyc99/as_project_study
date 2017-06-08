package com.eric.andrew.eric.a009sqlite03litepal01.Database;

import org.litepal.crud.DataSupport;

/**
 * Created by eric on 08/06/2017.
 * sqlite3 BookStore.db,.table,.schema
 */

public class Book extends DataSupport{

    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setName(String name) {
        this.name = name;
    }
}
