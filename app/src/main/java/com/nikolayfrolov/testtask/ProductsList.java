package com.nikolayfrolov.testtask;

// Параметры списка категории
public class ProductsList {
    private  int count = 0; // счетчик
    private int product_photo;
    private String product_title; // например, Ветчина и грибы
    private String product_ingredients; // ингридиенты продукта
    private String product_start_price;

    public ProductsList(int product_photo, String product_title, String product_ingredients, String product_start_price) {
        this.product_photo = product_photo;
        this.product_title = product_title;
        this.product_ingredients = product_ingredients;
        this.product_start_price = "от " + product_start_price + " р";

        count++;
    }

    public int getCount() {
        return count;
    }

    public int getProduct_photo() {
        return product_photo;
    }

    public void setProduct_photo(int product_photo) {
        this.product_photo = product_photo;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_ingredients() {
        return product_ingredients;
    }

    public void setProduct_ingredients(String product_ingredients) {
        this.product_ingredients = product_ingredients;
    }

    public String getProduct_start_price() {
        return product_start_price;
    }

    public void setProduct_start_price(String product_start_price) {
        this.product_start_price = product_start_price;
    }
}
