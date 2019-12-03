/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazonstore.services;

import com.mycompany.amazonstore.dao.ProductDAOImpl;
import com.mycompany.amazonstore.dtos.Cart;
import com.mycompany.amazonstore.dtos.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author stephenespinal
 */
public class AmazonServiceImpl {
    //addtocart
    //removefromcart
    //savecart when you close browser
    //checkoutcart
    //viewcart
    private Map<Product,Integer> cart;
    private ProductDAOImpl dao;

    public AmazonServiceImpl(Map<Product, Integer> cart, ProductDAOImpl dao) {
        this.cart = cart;
        this.dao = dao;
    }
    
    
    
    public List<Product> viewProducts(){
        return new ArrayList<>();
    }

    public void addToCart(Product product, int qty) {

    }

    public void removeFromCart(Product product, int qty) {

    }

    public void saveCart() {

    }

    public void checkoutCart() {

    }

    public Map<Product,Integer> viewCart() {
        return new HashMap<Product,Integer>();
    }
    
    public BigDecimal checkOut(){
        return new BigDecimal("1.00");
    }
}
