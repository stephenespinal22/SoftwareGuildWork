/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazonstore.controller;

import com.mycompany.amazonstore.dtos.Product;
import com.mycompany.amazonstore.services.AmazonServiceImpl;
import com.mycompany.amazonstore.views.AmazonView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author stephenespinal
 */
public class AmazonController {
    
    private AmazonView view;
    private AmazonServiceImpl service;
    
    public AmazonController(AmazonView view,AmazonServiceImpl s) {
        
        //if you type new instantiate it is tightly coupled
        //when you do dependency injection/ loosely coupled with each other
        this.view = view;
       this.service = s;
    }
    
    public void run(){
        while(true){
            MainMenu choice = MainMenu.values()[view.getMainMenuChoice() - 1];
            switch(choice)
            {
                case Unknown:
                    break;
                case ViewProducts:
                    viewProducts();
                    break;
                case ViewCart:
                    break;
                default:
                    throw new AssertionError(choice.name());

            }
        }
    }

    private void viewProducts() {
        List<Product> products = new ArrayList<Product>();
        int choice = view.viewProducts(products);
        if (choice == products.size()) return;
        
        viewProduct(products.get(choice-1)); //-1 because array starts at 0
    }

    private void viewProduct(Product product) {
        int choice = view.viewProduct(product);
        switch(choice) {
            case 1: //Add to cart
                int qty = view.addProductToCart(product);
                service.addToCart(product, qty);
                break;
            case 2: //return to products
                viewProducts();
                break;
            case 3: //view cart
                viewCart();
                break;
            default:
                view.displayMsg("Unknown");
        }
    }

    private void viewCart() {
        int choice = view.displayCartMenu(service.viewCart());
        switch (choice) {
            case 1: //removeProduct
                removeProduct();
                break;
            case 2: //checkout
                view.displayCheckoutMessage(service.checkOut());
                break;
        }
    }

    private void removeProduct() {
        int choice = view.displayRemoveProductMenu(service.viewCart());
        Set<Product> products = service.viewCart().keySet();
        if(products.size() == choice)//last choice
            viewCart();
        else if (choice >= 0 && choice <= products.size()) //did they choose an option
        {
            Product selectedProduct = (Product)products.toArray()[choice-1];
            int qty = view.displayRemoveProductQty(selectedProduct);
            service.removeFromCart(selectedProduct, qty);
        }        
    }
}
