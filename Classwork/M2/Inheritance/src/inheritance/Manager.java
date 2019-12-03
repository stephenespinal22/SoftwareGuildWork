/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author stephenespinal
 */
public class Manager extends Employee {

    public void hire() {
        // code to hire someone...
    }

    public void fire() {
        // code to fire someone...
    }

    public void givePerformanceReview() {
        // code to give performance review
    }

    @Override
    public void createYearlyObjectives() {
	        // we're overriding the version of this method in Employee
	        // put new code here...
	        super.createYearlyObjectives();
	        // put more new code here...
    }
}
