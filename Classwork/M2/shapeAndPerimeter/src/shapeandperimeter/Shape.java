/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapeandperimeter;

/**
 *
 * @author stephenespinal
 */
abstract public class Shape {
    protected String color;
    protected double area;
    protected double perimeter;
    
    abstract public double getArea();

    abstract public double getPerimeter();
    
    
}
