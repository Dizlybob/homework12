package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ProductBasket {
    private final ArrayList<Product> basket = new ArrayList<>();

    public void addProductToBasket(Product product) {
        basket.add(product);
    }

    public int totalCost() {
        int totalCost = 0;
        for (Product product : basket) {
            if (product != null) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public void listBasket() {
        for (Product slot : basket) {
            if (slot != null) {
                System.out.println(slot);
            }
        }
        System.out.println("Итого: " + this.totalCost());
        byte specialProducts = 0;
        for (Product slot : basket) {
            if (slot != null && slot.isSpecial()) {
                specialProducts++;
            }
        }
        System.out.println("Специальных товаров: " + specialProducts);
    }

    public boolean checkProductExist(String name) {
        for (Product product : basket) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void emptyBasket() {
        basket.clear();
    }

    public void removeProductFromBasket(String product) {
        Iterator<Product> iterator = basket.iterator();
        ArrayList<Product> deletedProducts = new ArrayList<>();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getName().equals(product)) {
                iterator.remove();
                deletedProducts.add(element);
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст");
        } else {
            System.out.println("Удаленные продукты: " + deletedProducts);
        }
    }
}
