package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product milk1 = new Product("Моё", 100);
        Product melon1 = new Product("Арбуз", 250);
        Product candy1 = new Product("Шипучка", 15);
        Product petFood1 = new Product("kitekat", 350);
        Product chocolate1 = new Product("AlpenGold", 180);
        Product candy2 = new Product("Toffie", 20);
        ProductBasket basket = new ProductBasket();
        basket.addProductToBasket(milk1);
        basket.addProductToBasket(melon1);
        basket.addProductToBasket(candy1);
        basket.addProductToBasket(petFood1);
        basket.addProductToBasket(chocolate1);
        basket.addProductToBasket(candy2);
        System.out.println(" ");
        System.out.println(basket.checkProduct(candy2.getName()));
        System.out.println(basket.checkProduct(candy1.getName()));
        System.out.println(" ");
        basket.listBasket();
        basket.emptyBasket();
        basket.addProductToBasket(candy2);
        System.out.println(" ");
        basket.listBasket();
    }
}