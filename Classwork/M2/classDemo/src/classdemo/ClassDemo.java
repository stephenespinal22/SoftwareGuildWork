/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdemo;

/**
 *
 * @author acetip
 * 
 * 5/10
 */
public class ClassDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        UserIO io = new UserIO();
        
        Hero myHero = new Hero();
        String name = io.prompt("What is your hero name");
        myHero.setName(name);
        int age = io.promptInt("What is your hero's age?");
        myHero.setAge(age);
        myHero.setGoblinsKilled(10);

        
        Hero myHero2 = new Hero();
        String name2 = io.prompt("what is your second hero's name");
        
        myHero2.setName(name2);
        int age2 = io.promptInt("whats your heros age");
        myHero2.setAge(age2);
        
        
        myHero2.setGoblinsKilled(20);
        
    }
    
}
