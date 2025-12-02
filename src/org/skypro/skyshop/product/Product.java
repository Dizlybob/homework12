package org.skypro.skyshop.product;

public abstract class Product {
    protected String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта должно быть указано!");
        }
        this.name = name;
    }

    public int getPrice() {
        return 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Продукт: " + name;
    }

    public boolean isSpecial() {
        return false;
    }
}
