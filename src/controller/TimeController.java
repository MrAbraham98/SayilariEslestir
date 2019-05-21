

package controller;

import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JLabel;



 
 
public class TimeController {
     int saniye;
     int dakika;
     int saat;
     String saniyeSayac = "0";
     String dakikaSayac = "0";
     String saatSayac = "0";
     private static boolean zamanDurdur = false;
     public TimeController(boolean zamanDurdur){
         this.zamanDurdur = zamanDurdur;
         
     }
    public TimeController(JLabel timeLabel){
         Timer t = new Timer();
        TimerTask task = new TimerTask()
                {
                        public void run()
                        {
                            if(zamanDurdur == false){
                                saniye++;
                                saniyeSayac = Integer.toString(saniye);
                                if(saniye >= 10){
                                timeLabel.setText("Süre:  " + "0"+saatSayac  + ":0"+ dakikaSayac  + ":" + saniyeSayac);
                                }else {
                                    timeLabel.setText("Süre:  "+ "0"+saatSayac  + ":0"+dakikaSayac  + ":0" + saniyeSayac);
                                }
                                    if(saniye == 60){
                                        saniye = 0;
                                        dakika++;
                                        dakikaSayac = Integer.toString(dakika);
                                        if(dakika >= 10){
                                    timeLabel.setText("Süre:  " + "0"+saatSayac + ":" + dakikaSayac + ":" + saniyeSayac);
                                }else {
                                    timeLabel.setText("Süre:  " + "0"+saatSayac + ":0" + dakikaSayac + ":" + saniyeSayac);
                                }
                                        if(dakika == 60){
                                            dakika = 0;
                                            saat++;
                                            saatSayac = Integer.toString(saat);
                                            if(saat >= 10){
                                    timeLabel.setText("Süre:  " + "" + saatSayac + ":0" + dakikaSayac + ":0" + saniyeSayac);
                                }else{
                                    timeLabel.setText("Süre:  " + "0" + saatSayac + ":" + dakikaSayac + ":" + saniyeSayac);
                                }
                                        }
                                    }
                            }
                        }
                };
               
                t.schedule(task, 0, 1000);
        
                
    }
    

   
    
}


