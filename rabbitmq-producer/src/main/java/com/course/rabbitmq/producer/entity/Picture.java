package com.course.rabbitmq.producer.entity;

public class Picture {
    private String name;
    private String type;
    private String source;
    private long size;
    
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public String getSource() {
        return source;
    }
    
    public long getSize() {
        return size;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    public void setSize(long size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return "Picture: [" +
                       "name: " + name +
                       ", type: " + type +
                       ", source: " + source +
                       ", size: " + size +
                       "]";
    }
}
