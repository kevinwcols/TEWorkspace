package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.util.UUID;

public class Tool implements CatalogItem {
    String id;
    String type;
    String manufacturer;
    int count;

    // Constructor
    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    //methods
    public String toString () {
        return "* " + type + System.lineSeparator()
                + " - Manufacturer Name: " + manufacturer + System.lineSeparator()
                + " - Count: " + count + System.lineSeparator()
                + " - Id: " + id;
    }

    @Override
    public boolean matchesName(String searchStr) {
        if ( getType().toLowerCase().contains(searchStr.toLowerCase()) ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if ( getManufacturer().toLowerCase().contains(searchStr.toLowerCase()) ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    public void registerItem() throws FileStorageException {
        id = UUID.randomUUID().toString();
        // write to the log file
        String fileName = "ToolLog.txt";
        FileStorageService.writeContentsToFile( toString (), fileName, true);
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
