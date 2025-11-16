package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private static final Product[] basket = new Product[5];

    public void addProductToBasket(Product name) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = name;
                break;
            }
            if (basket[i] != null && i == 4) {
                System.out.println("Невозможно добавить продукт");
                break;
            }
        }
    }

    public int totalCost() {
        int totalCost = 0;
        for (Product product : basket) {
            if (product != null) {
                totalCost = totalCost + product.getPrice();
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
    }

    public boolean checkProduct(String name) {
        for (Product product : basket) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void emptyBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
    }
}
