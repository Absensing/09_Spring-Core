package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {


        private final List<Product> items;

        public ShoppingCart() {
            items = new ArrayList<>();
        }

        public void additem(Product item) {
            items.add(item);
        }

        public List<Product> getItem() {
            return items;
        }

    public List<Product> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                '}';
    }
}

