package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.website.Article;

public class App {
    public static void main(String[] args) {
        //Исключения в Java
        System.out.println("Exception");
        try {
            Product apple2 = new DiscountedProduct("Яблоко", 120, (byte) -1);
        } catch (IllegalArgumentException e) {
            System.out.println("В цену товара или процент скидки указаны недопустимое число");
        }
        System.out.println(" ");
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
        System.out.println(" ");


        System.out.println("ООП. Полиморфизм. Интерфейсы");

        SearchEngine searchEngine = new SearchEngine(8);

        Article article1 = new Article("Что-то о производителей продуктов", "Текст о производителей продуктов");
        Article article2 = new Article("Что-то о продуктах", "Текст о продуктах");

        searchEngine.add(milk1);
        searchEngine.add(candy1);
        searchEngine.add(melon1);
        searchEngine.add(petFood1);
        searchEngine.add(chocolate1);
        searchEngine.add(candy2);
        searchEngine.add(article1);
        searchEngine.add(article2);
        System.out.println(" ");
        Searchable[] searchables = searchEngine.search("а");
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                System.out.println(searchable.getStringRepresentation());
            }
        }
        System.out.println(" ");
        System.out.println(milk1.getStringRepresentation());
        System.out.println(" ");
        try {
            System.out.println(searchEngine.getSearchTerm("о").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не было найдено лучшего результата по Вашему запросу !");
        }
        System.out.println(" ");
        try {
            System.out.println(searchEngine.getSearchTerm("Матрас").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не было найдено лучшего результата по Вашему запросу !");
        }
    }
}