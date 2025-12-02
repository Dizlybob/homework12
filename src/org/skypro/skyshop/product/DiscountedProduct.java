package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{

    private int price;
    private byte discountPercentage;
    private int priceWithDiscount;

    public DiscountedProduct(String name, int price, byte discountPercentage) {
        super(name);
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной!");
        }
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int getPrice() {
        priceWithDiscount = price - (price / 100 * discountPercentage);
        return priceWithDiscount;
    }

    @Override
    public String toString() {
        priceWithDiscount = price - (price / 100 * discountPercentage);
        return super.getName() + ": " + priceWithDiscount + "(" + discountPercentage + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
