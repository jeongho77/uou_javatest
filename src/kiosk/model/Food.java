package kiosk.model;

import kiosk.model.enums.Categorys;


public class Food {
    private int number;
    private String imageUrl;
    private String name; //음식이름
    private int price; //가격
    private Categorys category; //한식,중식,양식

    public Food(int number ,String imageUrl, String name, int price, Categorys category) {
        this.number = number;
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public Categorys getCategory() {
        return category;
    }

}
