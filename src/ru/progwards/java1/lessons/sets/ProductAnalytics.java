package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductAnalytics {
    private List<Shop> shops;
    private List<Product> allProducts;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.allProducts = products;
        this.shops = shops;
    }

    public Set<Product> existInAll() {
        Set<Product> productsInAllShops = new HashSet<>(allProducts);
        Set<Product> productsToRemove = new HashSet<>();
        allProductsLoop:
        for(Product product : productsInAllShops) {
            shopsLoop:
            for (Shop shop : shops) {
                List<Product> productsInCurrentShop = shop.getProducts();
                for (Product currentProduct : productsInCurrentShop) {
                    if (currentProduct.getCode().equals(product.getCode())) {
                        continue shopsLoop;
                    }
                }
                productsToRemove.add(product);
                continue allProductsLoop;
            }
        }
        productsInAllShops.removeAll(productsToRemove);
        return productsInAllShops;
    }

    public Set<Product> existAtListInOne() {
        Set<Product> productsAtListInOne = new HashSet<>(allProducts);
        Set<Product> productsToRemove = new HashSet<>();
        allProductsLoop:
        for(Product product : productsAtListInOne) {
            for (Shop shop : shops) {
                List<Product> productsInCurrentShop = shop.getProducts();
                for (Product currentProduct : productsInCurrentShop) {
                    if (currentProduct.getCode().equals(product.getCode())) {
                        continue allProductsLoop;
                    }
                }
            }
            productsToRemove.add(product);
        }
        productsAtListInOne.removeAll(productsToRemove);
        return productsAtListInOne;
    }

    public Set<Product> notExistInShops() {
        Set<Product> productsNotExistInShops = new HashSet<>(allProducts);
        Set<Product> productsToRemove = new HashSet<>();
        allProductsLoop:
        for(Product product : productsNotExistInShops) {
            for (Shop shop : shops) {
                List<Product> productsInCurrentShop = shop.getProducts();
                for (Product currentProduct : productsInCurrentShop) {
                    if (currentProduct.getCode().equals(product.getCode())) {
                        productsToRemove.add(product);
                        continue allProductsLoop;
                    }
                }
            }
        }
        productsNotExistInShops.removeAll(productsToRemove);
        return productsNotExistInShops;
    }

    public Set<Product> existOnlyInOne() {
        Set<Product> productsOnlyInOne = new HashSet<>();
        int numberOfShopsWithProduct;
        for(Product product : allProducts) {
            numberOfShopsWithProduct = 0;
            shopsLoop:
            for (Shop shop : shops) {
                List<Product> productsInCurrentShop = shop.getProducts();
                for (Product currentProduct : productsInCurrentShop) {
                    if (currentProduct.getCode().equals(product.getCode())) {
                        numberOfShopsWithProduct++;
                        continue shopsLoop;
                    }
                }
            }
            if(numberOfShopsWithProduct == 1)
                productsOnlyInOne.add(product);
        }
        return productsOnlyInOne;
    }
}
