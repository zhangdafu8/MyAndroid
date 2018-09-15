package com.example.qiaoxian.restaurant;

public class Food {
    private String foodName;
    private int price;
    private int picture;
    private boolean spicy;
    private boolean seafood;
    private boolean sour;

    public Food() {
    }

    public Food(String foodName, int price, int picture, boolean spicy, boolean seafood, boolean sour) {
        this.foodName = foodName;
        this.price = price;
        this.picture = picture;
        this.spicy = spicy;
        this.seafood = seafood;
        this.sour = sour;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public int getPicture() {
        return picture;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public boolean isSeafood() {
        return seafood;
    }

    public boolean isSour() {
        return sour;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public void setSeafood(boolean seafood) {
        this.seafood = seafood;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", price=" + price +
                ", picture=" + picture +
                ", spicy=" + spicy +
                ", seafood=" + seafood +
                ", sour=" + sour +
                '}';
    }
}
