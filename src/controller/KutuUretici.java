/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import gui.NewJFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import model.Listener;

/**
 *
 * @author Abraham
 */
public class KutuUretici extends NewJFrame{
     public static int girilenSayi;
    static int sinirlayici = 0;
    private static JToggleButton[] kutu;
    Listener listener=new Listener();
    public KutuUretici(JLabel puanLabel,JLabel timeLabel){
        for(int i=0; i<kutu.length;i++){
            kutu[i].setText("  ");
            kutu[i].setEnabled(true);
        }
        EslesmeBul es = new EslesmeBul(puanLabel,timeLabel);
    }
    
    public KutuUretici(JPanel kutuPanel,JTextField alınanDeger,JComboBox layout){
        
         String text = alınanDeger.getText();
         girilenSayi = Integer.parseInt(text);
         if(girilenSayi % 2 == 1)
         {
             girilenSayi = girilenSayi + 1;
         }
         
        kutu = new JToggleButton[girilenSayi];
        String[] kutuText = new String[girilenSayi];
        
        String layoutSecilenIsim = (String) layout.getSelectedItem();
        if(layoutSecilenIsim.equals("Grid Layout")){
            kutuPanel.setLayout(new GridLayout(0, girilenSayi/2));
        }
        if(layoutSecilenIsim.equals("Flow Layout")){
            kutuPanel.setLayout(new FlowLayout());
        }
        
        
        int toplam =1;
        for(int k=0;k<kutuText.length/2;k++)
        {
          kutuText[k]=Integer.toString(toplam);
          toplam = toplam + 1;
        }
        toplam = 1;
        for(int k=kutuText.length/2;k<kutuText.length;k++)
        {
          kutuText[k]=Integer.toString(toplam);
          toplam = toplam + 1;
        }
        
        for(int i =  0; i<kutu.length;i++)
        {
            kutu[i] = new JToggleButton(kutuText[i]);
            kutu[i].setName(kutuText[i]);
            kutu[i].setEnabled(false);
            kutu[i].addActionListener(listener);
        }
        
        
       JToggleButton bosKutu;
        int indeks;
        for(int f=0;f<kutu.length;f++){
            indeks= (int) (Math.random()*kutu.length);
            bosKutu = kutu[indeks];
            kutu[indeks] = kutu[f];
            kutu[f]=bosKutu;
          }
     
        
       for(int j=0;j<kutu.length;j++){
           if(sinirlayici<1){
            kutuPanel.add(kutu[j]);
            kutu[j].setSize(100,100);
           }
        }
       kutuPanel.validate();
       sinirlayici = 1;
       kutuPanel.setVisible(true);
       
    }
}
