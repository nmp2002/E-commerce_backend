package com.ttisv.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accessory")
public class Accessory extends Product {
    
    @Column(name = "brand")
    private String brand;
    
    @Column(name = "type")
    private String type; // LAPTOP_ACCESSORY or PHONE_ACCESSORY
    
    @Column(name = "compatibility")
    private String compatibility; // List of compatible devices
    
    @Column(name = "material")
    private String material;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "warranty_period")
    private String warrantyPeriod;
    
    @Column(name = "dimensions")
    private String dimensions;
    
    @Column(name = "weight")
    private String weight;

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(String compatibility) {
        this.compatibility = compatibility;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
} 