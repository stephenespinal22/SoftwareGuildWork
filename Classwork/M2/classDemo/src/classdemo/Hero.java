/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdemo;

import java.util.Random;

/**
 *
 * @author acetip
 */
public class Hero {

    public static int goblinsKilled;
    private String name;
    private boolean alive;
    private int age;
    private double gold;
    private int[] potions;
    private int health;

    public Hero() {
        alive = true;
        age = 1;
        potions = new int[]{5, 5, 5, 5, 5};
        Random r = new Random();
        int maxHealth = r.nextInt(40) + 10;
        health = maxHealth;

    }
    
        public  int getGoblinsKilled() {
        return goblinsKilled;
    }

    public  void setGoblinsKilled(int goblinsKilled) {
        Hero.goblinsKilled = goblinsKilled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    void setAge(int age) {
        this.age = age;
    }

}
