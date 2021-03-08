/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Nandha Kumar RP
 */
public class PartsReq extends ViewBooking{
    JPanel p3;
    PartsReq(){
        p3 = new JPanel();
        tp.add("Parts Required",p3);
        tp.setBackgroundAt(2, Color.WHITE);
    }
    public static void main(String args[]){
        new PartsReq();
    }
    
}
