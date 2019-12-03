/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazonstore.views;

import com.mycompany.amazonstore.dtos.Cart;
import com.mycompany.amazonstore.dtos.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author stephenespinal
 */
public class AmazonView {

    private int promptInt() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }

    public void printBanner(String title) {
        System.out.println("=================");
        System.out.println(StringUtils.center(title, 17, '='));
    }

    public int getMainMenuChoice() {
        printBanner("Products");
        System.out.println("1. View Products");
        System.out.println("2. View Cart");
        System.out.println("3. Exit");
        printBanner("");
        return promptInt();
    }

    public int viewProducts(List<Product> products) {
        printBanner("Products");
        int i = 0;
        for (i = 0; i < products.size(); i++) {

            System.out.println((i + 1) + ". Name COST");
        }
        System.out.println((i + 1) + ". Return to Menu");
        return promptInt();
    }

    public int viewProduct(Product product) {
        printBanner("View Product");
        System.out.println("1. Add to Cart");
        System.out.println("2. Return to Product");
        System.out.println("3. View Cart");
        printBanner("");

        return promptInt();
    }

    public int addProductToCart(Product product) {
        printBanner("Add to Cart");
        displayMsg("How many NAME do you want to add?");
        printBanner("");
        return promptInt();
    }

    public void displayMsg(String msg, String banner) {
        //method overloading
        printBanner(banner);
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        System.out.println("Press Enter to Continue");
        printBanner("");
        sc.nextLine();
    }

    public void displayMsg(String msg) {
        System.out.println(msg);
    }

    public int displayCartMenu(Map<Product, Integer> cart) {
        printBanner("View Cart");
        Set<Product> keys = cart.keySet();
        for (Product key : keys) {
            Integer qty = cart.get(key);
            BigDecimal cost = key.getCost().multiply(new BigDecimal(qty)
                    .setScale(2, RoundingMode.HALF_DOWN));
            System.out.println(key.getName() + " " + qty + " " + cost);
        }

        System.out.println("1. Remove Product");
        System.out.println("2. Check out");
        System.out.println("3. Return Menu");
        printBanner("");
        return promptInt();

    }

    public int displayRemoveProductMenu(Map<Product, Integer> cart) {
        printBanner("Remove Product");

        Set<Product> products = cart.keySet();
        int i = 1;
        for (Product product : products) {
            System.out.println(i + ". " + product.getName());
            i++;
        }
        System.out.println(i + ".Return to Cart");
        printBanner("");
        return promptInt();
    }

    public int displayRemoveProductQty(Product product) {
        printBanner("Remove Product");
        System.out.println("How many " + product.getName()
                + " do you want to remove?");
        printBanner("");
        return promptInt();
    }

    public void displayCheckoutMessage(BigDecimal amount) {
        printBanner("Check out");
        System.out.println("You owe... " + amount);
        System.out.println("Press enter to Continue");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
    
    
}
