/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trader;

/**
 *
 * * 
 * @author VSoldatov
 */



public class Trader {

 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       // initial values and interval for currency's rate [ 10; 50 ] 
       final int INITIAL_EXCHANGE_RATE = 40;
       final int EXCHANGE_DELTA = 10;
       final double LIBOR = 0.05;  // LIBOR rate = 5% per year
        
       double Cash = 1499;  // initial amount of money
       double margin = 0;   // postive or negative margin as the deal result
       boolean deal;     // deal flag
       
       int spotPrice;    // price for the happened day
       int t0_price = INITIAL_EXCHANGE_RATE;
       
       // first trading day
       TradeDay tday = new TradeDay(INITIAL_EXCHANGE_RATE,EXCHANGE_DELTA);
       
       // new spot currency contract 
       CurrencyContract spotRUB = new CurrencyContract("RUBLES",t0_price );
       
       // new forward currency contract for 10 days for EXCHANE RATE = 35
     //  CurrencyContract fwdRUB = new CurrencyContract("RUBLES", 35, 10);
      
       // Trade Robot creation
       TradeRobot myRobot = new TradeRobot(Cash, LIBOR);
       
       // calculation of investment income using LIBOR
       margin = myRobot.Forecast();
       System.out.println("Using LIBOR = " + LIBOR + " we can get " + margin + " in 1 year");
       
       deal = myRobot.Buy(spotRUB);   // buy contract
       
       System.out.println("Our initial balance was " + Cash );
       System.out.println( "RUB T0 price was " + t0_price);
       
       if (deal)  // if Trade Robot bought something
            System.out.println(myRobot.GetAssetInfo()+ " CASH = " + myRobot.GetBalance() );
       
       // second trading day
       tday.Next();
       spotPrice = tday.ExchangeRate; 
       
       deal = myRobot.Sell(spotPrice, spotRUB); // try to sell contract
                     
       if (!deal) {  // if we didn't sell something
           System.out.println( "But now it's just " + spotPrice + " No reason to sell");
           
           // trying to check the theoretical margin
           double CashCalculation = 0;
           CashCalculation = myRobot.SellAnalysis(spotPrice);
           if ( CashCalculation > 0 ){
               
               margin =  myRobot.GetBalance() + CashCalculation - Cash;
               System.out.println("If we'll do that our lose will be " + margin);
           }
           
                                   
       } else {
           
           System.out.println( " SOLD  " + spotPrice + " per contract" );
           System.out.println(myRobot.GetAssetInfo()+ " CASH = " + myRobot.GetBalance() );
           
           margin = myRobot.GetBalance() - Cash;
           System.out.println("Our margin = " + margin );
       }
        
        
    }
    
}
