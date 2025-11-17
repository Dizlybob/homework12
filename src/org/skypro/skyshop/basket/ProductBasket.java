package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] basket = new Product[5];

    public void addProductToBasket(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
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
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
    }
}
