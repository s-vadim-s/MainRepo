/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trader;

import java.lang.Math;

/**
 *
 * @author VSoldatov
 */
public class TradeRobot {
    
    private double balance;
    private CurrencyContract asset;     // type of contract on balance
    private int asset_count;   // num of contracts on balance
    private double Libor;  // LIBOR rate
    
    // creation of the Robot's balance
     TradeRobot(double cash, double Libor){
        
         this.balance = cash;
         this.Libor = Libor;                          
    }
    
     // main function: execution of Order recieved
     public boolean Execute ( Order order){
         
         return true;
         
     }
     
     // Calculation of income got from investment for the years using LIBOR
     private double LiborForecast(double cash, double years) {
         double result = 0;
         
         /*
            Capital = Cash * ( 1 + LIBOR  ) ^ num_years
         */
         
         result = Math.pow((1+Libor), years);  // math exponent power
         result = cash * result;
         
         return result;
     }
     
     // Buing of the Currency contract
     public boolean Buy ( CurrencyContract contract) {
         
         if ( this.balance >= contract.price) {   // buy only if we have money on balance
             
             this.asset = contract;
             
             do {
                 this.asset_count++;
                 this.balance = this.balance - contract.price;
                 
             } while ( this.balance >= contract.price );  // buy until we have money
             
             return true;
             
         } else {
             
             return false;
         }
         
         
     }
     
     // sell all contracts by spot price
     public boolean Sell ( int spot_price, CurrencyContract contract) {
         
         if ( this.asset != null) {   //  sell only if we have something to sell
             
             if(  this.asset.price < spot_price )  {  // sell only if we got better price
                 
                 this.balance = this.balance + spot_price * this.asset_count;
                 this.asset = null;
                 this.asset_count = 0;
                 
                 return true;
             }
             
         }
             
         return false;
         
     }
     
     // returns the deal result in case if contracts will be sold by sport price
     public double SellAnalysis ( int spot_price ) {
         
         if ( this.asset != null) {   //  sell only if we have something to sell
             
             return spot_price * this.asset_count ;
                          
         }
         
         return 0;
     }
     
     
     public String GetAssetInfo() {    // print status info
     
     String result;
     
     if ( this.asset == null ) {
         result = "No contracts";
         
     } else {
         
         result = "We have " + this.asset_count + " " + this.asset.contractName   + " contracts ";
         
     }
     
     
     return result;
     
     }
    
     // forecast of income got from investment of Cash on LIBOR rate for 1 year
     public double Forecast(){
         
         double result = 0;
         
         result = this.LiborForecast(this.balance, 1);
         
         return result;
         
     }

    // Robot's actual balance 
    public double GetBalance() {
                
        return this.balance;
                
    }
            
    
}
