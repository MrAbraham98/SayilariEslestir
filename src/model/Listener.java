/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.EslesmeBul;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;

/**
 *
 * @author Abraham
 */
public class Listener implements ActionListener{
    String sayi;
    EslesmeBul EslesmeBul = new EslesmeBul();
   
    @Override
    public void actionPerformed(ActionEvent ae) {
                    AbstractButton abstractButton = (AbstractButton) ae.getSource();
                    boolean secilmeDurumu = abstractButton.getModel().isSelected();
                    sayi = abstractButton.getName();
                    if(secilmeDurumu==true){
                        abstractButton.setEnabled(false);
                        abstractButton.setText(sayi);
                    }
                    if(secilmeDurumu == false){
                        abstractButton.setText(" ");
                    }
                    int intSayi = Integer.parseInt(sayi);
                    System.out.println(intSayi);
                    EslesmeBul.eslesmeBul(intSayi,abstractButton);
    }
}
