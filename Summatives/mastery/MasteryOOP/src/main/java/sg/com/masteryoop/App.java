/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.masteryoop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sg.com.masteryoop.controller.FlooringController;


/**
 *
 * @author stephenespinal
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller  = ctx.getBean("controller", FlooringController.class);
        controller.setCtx(ctx);
        controller.run();

    }

}
