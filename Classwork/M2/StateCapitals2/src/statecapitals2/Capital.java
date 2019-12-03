/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

/**
 *
 * @author stephenespinal
 */
public class Capital {
    
    private String name;
    private int population;
    private int squareMileage;
    
    public Capital(String name, int population, int area){
        this.name = name;
        this.population = population;
        this.squareMileage = area;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getSquareMileage() {
        return squareMileage;
    }
    
    @Override
    public String toString()
    {
       return this.name + " | Pop: "+ this.population + " | Area: " + this.squareMileage + " sq mi";
    }
    
}
