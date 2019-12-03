/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.vendingmachine;

import sg.com.vendingmachine.controller.VendingMachineController;
import sg.com.vendingmachine.daos.VendingMachineDao;
import sg.com.vendingmachine.daos.VendingMachineDaoFileImpl;
import sg.com.vendingmachine.services.VendingMachineServiceLayer;
import sg.com.vendingmachine.services.VendingMachineServiceLayerImpl;
import sg.com.vendingmachine.views.UserIO;
import sg.com.vendingmachine.views.UserIOConsoleImpl;
import sg.com.vendingmachine.views.VendingMachineView;

/**
 *
 * @author stephenespinal
 */
public class App {

    public static void main(String[] args) {

        //instaiate necessary objects
        UserIO io = new UserIOConsoleImpl();

        VendingMachineView view = new VendingMachineView(io);
        
        VendingMachineDao dao = new VendingMachineDaoFileImpl("Inventory.txt");
        
        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao);

        VendingMachineController controller = new VendingMachineController(view,service);

        //run the controller
        controller.run();

    }

}
