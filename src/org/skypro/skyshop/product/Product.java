package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта должно быть указано!");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной!");
        }
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }
}
