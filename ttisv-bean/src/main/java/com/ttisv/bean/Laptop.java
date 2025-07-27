package com.ttisv.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop extends Product {
    
    @Column(name = "brand")
    private String brand;
    
    @Column(name = "processor")
    private String processor;
    
    @Column(name = "ram")
    private String ram;
    
    @Column(name = "storage")
    private String storage;
    
    @Column(name = "graphics_card")
    private String graphicsCard;
    
    @Column(name = "screen_size")
    private String screenSize;
    
    @Column(name = "operating_system")
    private String operatingSystem;
    
    @Column(name = "weight")
    private String weight;
    
    @Column(name = "color")
    private String color;

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
} 