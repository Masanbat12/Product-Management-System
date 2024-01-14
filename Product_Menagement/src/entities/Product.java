package src.entities;

public class Product {
    private int id;
    private String name;
    private String date;
    private float price;
    private byte[] picture;

    // Public no-arg constructor
    public Product() {
    }

    // Public Product arg constructor
    public Product(int pId, String pName, String pDate, float pPrice, byte[] pimg) {
        setId(pId);
        setName(pName);
        setDate(pDate);
        setPrice(pPrice);
        setPicture(pimg);
    }

    // Getters and setters for all properties

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price >= 0.0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("The Price cannot be negative.");
        }
    }
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
