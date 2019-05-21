/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author Abraham
 */
public class EslesmeBul{
    
    private AbstractButton sonAbstractButton;
    private int gelenKutu;
    static int sonKutu = 0;
    public JToggleButton sonButton;
    int gelenSayi;
    int sayici ;
    int puan;
    public String toplamPuan = "0";
    private static JLabel puanLabel;
    private JLabel timeLabel;
    
    public EslesmeBul(JLabel puanLabel,JLabel timeLabel){
       this.puanLabel = puanLabel;
       this.timeLabel = timeLabel;
       TimeController tc = new TimeController(timeLabel);
    }
   public EslesmeBul(){
        
   }
     
    
    public void eslesmeBul(int gelenKutu,AbstractButton gelenAbstractButton)
    {
         gelenSayi = KutuUretici.girilenSayi;
        if(sonKutu > 0 ){
          if(sonKutu == gelenKutu){
              gelenAbstractButton.setEnabled(false);
              sonAbstractButton.setEnabled(false);
              sayici = sayici + 1;
              puan = puan + 50;
              if(gelenSayi/2 == sayici){
                  TimeController tc = new TimeController(true);
                  puan = puan * gelenSayi;
                  toplamPuan = Integer.toString(puan);
                   puanLabel.setText("Puan = " + toplamPuan);
                   JOptionPane.showMessageDialog(null, "Oyun Bitti");
               }
          }else{
              gelenAbstractButton.setText(" ");
              gelenAbstractButton.setEnabled(true);
              gelenAbstractButton.setSelected(false);
              sonAbstractButton.setText(" ");
              sonAbstractButton.setEnabled(true);
              sonAbstractButton.setSelected(false);
              puan = puan - 20;
          } 
          sonKutu=0;
        }else{
            sonKutu = gelenKutu;
            sonAbstractButton = gelenAbstractButton;
        } 
        
    }
}
