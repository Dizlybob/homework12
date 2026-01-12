package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
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

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String searchTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String searchNameContent() {
        return name;
    }
}
