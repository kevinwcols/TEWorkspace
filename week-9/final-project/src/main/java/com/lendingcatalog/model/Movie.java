package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.UUID;

public class Movie implements CatalogItem {
    String id;
    String name;
    String director;
    LocalDate releaseDate;

    // Constructor
    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    //methods
    public String toString () {
        return "* " + name + System.lineSeparator()
                + " - Director: " + director + System.lineSeparator()
                + " - Release Date: " + releaseDate + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        if ( getName().toLowerCase().contains(searchStr.toLowerCase()) ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if ( getDirector().toLowerCase().contains(searchStr.toLowerCase()) ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesYear(int searchYear) {
        if ( getReleaseDate().getYear() == searchYear ) {
            return true;
        } else {
            return false;
        }
    }

    public void registerItem() throws FileStorageException {
        id = UUID.randomUUID().toString();
        // write to the log file
        String fileName = "MovieLog.txt";
        FileStorageService.writeContentsToFile( toString (), fileName, true);
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

}
