package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной или равна 0!");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.getName() + ": " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
