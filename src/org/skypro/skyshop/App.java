package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

public class App {
    public static void main(String[] args) {
        Product milk1 = new FixPriceProduct("Моё");
        Product melon1 = new SimpleProduct("Арбуз", 250);
        Product candy1 = new SimpleProduct("Шипучка", 15);
        Product petFood1 = new DiscountedProduct("kitekat", 350, (byte) 20);
        Product chocolate1 = new DiscountedProduct("AlpenGold", 210, (byte) 15);
        Product candy2 = new SimpleProduct("Toffie", 20);
        ProductBasket basket = new ProductBasket();
        basket.addProductToBasket(milk1);
        basket.addProductToBasket(melon1);
        basket.addProductToBasket(candy1);
        basket.addProductToBasket(petFood1);
        basket.addProductToBasket(chocolate1);
        basket.addProductToBasket(candy2);
        System.out.println(" ");
        System.out.println(basket.checkProductExist(candy2.getName()));
        System.out.println(basket.checkProductExist(candy1.getName()));
        System.out.println(" ");
        basket.listBasket();
        basket.emptyBasket();
        basket.addProductToBasket(candy2);
        System.out.println(" ");
        basket.listBasket();
    }
}