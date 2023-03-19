package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.UUID;

public class Book implements CatalogItem{
    String id;
    String title;
    String author;
    LocalDate publishDate;

    // Constructor
    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    // methods
    public String toString () {
        return "* " + title + System.lineSeparator()
                + " - Written by: " + author + System.lineSeparator()
                + " - Published Date: " + publishDate + System.lineSeparator()
                + " - Id: " + id;
    }

    public void registerItem() throws FileStorageException {
        id = UUID.randomUUID().toString();
        // write to the log file
        String fileName = "BookLog.txt";
        FileStorageService.writeContentsToFile( toString (), fileName, true);
    }

    @Override
    public boolean matchesName(String searchStr) {
        if ( getTitle().toLowerCase().contains(searchStr.toLowerCase()) ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if ( getAuthor().toLowerCase().contains(searchStr.toLowerCase()) ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesYear(int searchYear) {
        if ( getPublishDate().getYear() == searchYear ) {
            return true;
        } else {
            return false;
        }
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

}
