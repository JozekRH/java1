package ru.progwards.java1.lessons.sets;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        Product product1 = new Product("art-1");
        Product product2 = new Product("art-2");
        Product product3 = new Product("art-3");
        Product product4 = new Product("art-4");
        Product product5 = new Product("art-5");
        Product product6 = new Product("art-6");
        Product product7 = new Product("art-7");
        Product product8 = new Product("art-8");
        Product product9 = new Product("art-9");
        Product product10 = new Product("art-10");
        List<Product> products1 = new ArrayList<>();
        products1.add(product3);
        products1.add(product4);
        products1.add(product6);
        products1.add(product7);
        List<Product> products2 = new ArrayList<>();
        products1.add(product4);
        products1.add(product5);
        products1.add(product6);
        products1.add(product8);
        List<Product> products3 = new ArrayList<>();
        products1.add(product2);
        products1.add(product3);
        products1.add(product6);
        products1.add(product7);
        Shop shop1 = new Shop(products1);
        Shop shop2 = new Shop(products2);
        Shop shop3 = new Shop(products3);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);
        List<Shop> shops = new ArrayList<>();
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);
        ProductAnalytics productAnalytics = new ProductAnalytics(products, shops);

        System.out.println(productAnalytics.existAtListInOne());
    }

    public Set<Product> existAtListInOne() {
        Set<Product> productsAtListInOne = new HashSet<>();
        for (Shop shop : shops) {
            Set<Product> productsInCurrentShop = new HashSet<>(shop.getProducts());
            productsAtListInOne.addAll(productsInCurrentShop);
        }
        return productsAtListInOne;

//        Set<Product> productsAtListInOne = new HashSet<>(allProducts);
//        Set<Product> productsToRemove = new HashSet<>();
//        allProductsLoop:
//        for(Product product : productsAtListInOne) {
//            for (Shop shop : shops) {
//                List<Product> productsInCurrentShop = shop.getProducts();
//                for (Product currentProduct : productsInCurrentShop) {
//                    if (currentProduct.getCode().equals(product.getCode())) {
//                        continue allProductsLoop;
//                    }
//                }
//            }
//            productsToRemove.add(product);
//        }
//        productsAtListInOne.removeAll(productsToRemove);
//        return productsAtListInOne;
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
