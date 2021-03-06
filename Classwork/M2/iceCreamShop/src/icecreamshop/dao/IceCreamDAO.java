/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamshop.dao;

import icecreamshop.dto.IceCream;
import java.util.ArrayList;

/**
 *
 * @author acetip
 */
public class IceCreamDAO {

    private ArrayList<IceCream> icecreams;

    public IceCreamDAO() {
        icecreams = new ArrayList<>();
    }

    //create
    IceCream create(IceCream icecream) {
        icecreams.add(icecream);
        return icecream;
    }

    //readAll
    public ArrayList<IceCream> readAll() {
        return icecreams;
    }

    //readByName
    public IceCream readByName(String name) {
        for (int i = 0; i < icecreams.size(); i++) {
            IceCream icecream = icecreams.get(i);
            if (icecream.getName().equals(name)) {
                return icecream;
            }
        }
        return null;
    }

    //update
    public void update(IceCream newIceCreamInfo) {
        for (int i = 0; i < icecreams.size(); i++) {
            IceCream foundIceCream = icecreams.get(i);
            if (foundIceCream.getName().equals(newIceCreamInfo.getName())) {
                icecreams.set(i, newIceCreamInfo);
            }
        }
    }

    //delete
    public void delete(IceCream deleteIcecream) {
        for (int i = 0; i < icecreams.size(); i++) {
            IceCream foundIceCream = icecreams.get(i);
            if (foundIceCream.getName().equals(deleteIcecream.getName())) {
                icecreams.remove(i);
            }
        }
    }

}
