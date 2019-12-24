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
                productsInAllShops.remove(product);
                continue allProductsLoop;
            }
        }
        return productsInAllShops;
    }

    public Set<Product> existAtListInOne() {
        Set<Product> productsAtListInOne = new HashSet<>(allProducts);
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
            productsAtListInOne.remove(product);
        }
        return productsAtListInOne;
    }

    public Set<Product> notExistInShops() {
        Set<Product> productsNotExistInShops = new HashSet<>(allProducts);
        allProductsLoop:
        for(Product product : productsNotExistInShops) {
            for (Shop shop : shops) {
                List<Product> productsInCurrentShop = shop.getProducts();
                for (Product currentProduct : productsInCurrentShop) {
                    if (currentProduct.getCode().equals(product.getCode())) {
                        productsNotExistInShops.remove(product);
                        continue allProductsLoop;
                    }
                }
            }
        }
        return productsNotExistInShops;
    }

    public Set<Product> existOnlyInOne() {
        Set<Product> productsOnlyInOne = new HashSet<>(allProducts);
        boolean productExist = false;
        allProductsLoop:
        for(Product product : productsOnlyInOne) {
            shopsLoop:
            for (Shop shop : shops) {
                List<Product> productsInCurrentShop = shop.getProducts();
                for (Product currentProduct : productsInCurrentShop) {
                    if (currentProduct.getCode().equals(product.getCode())) {
                        if(!productExist) {
                            productExist = true;
                            continue shopsLoop;
                        } else {
                            productExist = false;
                            productsOnlyInOne.remove(product);
                            continue allProductsLoop;
                        }
                    }
                }
            }
            productExist = false;
        }
        return productsOnlyInOne;
    }
}
