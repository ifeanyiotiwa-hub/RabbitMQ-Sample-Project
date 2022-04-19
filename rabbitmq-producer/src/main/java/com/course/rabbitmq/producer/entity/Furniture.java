package com.course.rabbitmq.producer.entity;

public class Furniture {
    private String name;
    private String color;
    private String material;
    private int price;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Furniture: [" +
                       "name: " + name +
                       ", color: " + color +
                       ", material: " + material +
                       ", price: " + price +
                       ']';
    }
}
