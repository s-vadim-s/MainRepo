/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trader;

import java.util.Random;
/**
 *
 * @author VSoldatov
 */
public class Trader {


    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       int Cash = 1499;  // initial amount of money
       boolean deal;
       
       int spotPrice;
        
       Contract fwdRUB = new Contract("RUBLES",60);
      
       TradeRobot myRobot = new TradeRobot(Cash);
       deal = myRobot.Buy(fwdRUB);
       
       if (deal)
            System.out.println(myRobot.GetAssetInfo()+ " CASH = " + myRobot.GetBalance() );
       
       Random rn = new Random();
       spotPrice = rn.nextInt(50)+40;  // random num from 40 till 90
       
       deal = myRobot.Sell(spotPrice);
       
       if (!deal) {
           System.out.println( "RUB price was 60, but now it's just " + spotPrice);
       } else {
           System.out.println( " SOLD  " + spotPrice + " per contract" );
           System.out.println(myRobot.GetAssetInfo()+ " CASH = " + myRobot.GetBalance() );
       }
        
        
    }
    
}
