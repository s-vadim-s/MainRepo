/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trader;

/**
 *
 * @author VSoldatov
 */
public class TradeRobot {
    
    private int balance;
    private Contract asset;
    private int asset_count;
    
     TradeRobot(int cash){
        
         this.balance = cash;
         
    }
    
     public boolean Buy ( Contract contract) {
         
         if ( this.balance >= contract.price) {
             
             this.asset = contract;
             
             do {
                 this.asset_count++;
                 this.balance = this.balance - contract.price;
                 
             } while ( this.balance >= contract.price );
             
             return true;
             
         } else {
             
             return false;
         }
         
         
     }
     
     public boolean Sell ( int spot) {
         
         if ( this.asset != null) {
             
             if ( this.asset.price < spot ) {  // sell only if we have better price
                 
                 this.balance = this.balance + spot * this.asset_count;
                 this.asset = null;
                 this.asset_count = 0;
                 
                 return true;
             }
             
         }
             
         return false;
         
     }
     
     public String GetAssetInfo() {
     
     String result;
     
     if ( this.asset == null ) {
         result = "No contracts";
         
     } else {
         
         result = this.asset.contractName + " - " + this.asset_count ;
         
     }
     
     
     return result;
     
     }
    

     
    public int GetBalance() {
                
        return this.balance;
                
    }
            
    
}
