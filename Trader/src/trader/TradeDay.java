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
public class TradeDay {
    
    public int ExchangeRate = 0;   // exchange rate for some currency
    
    private int basis = 0;    // initial currency exchange rate
    private int delta = 0;    // maximum delta from basis to generate the random num not bigger than basis + delta
    
        
    public TradeDay (int basis, int delta){
        
        this.basis = basis;
        this.delta = delta;
    
  
    }

    // next Trade Day. Here are generated all daily values
    public void Next() {
        
       this.ExchangeRate = GetNextExchangeRate(this.basis, this.delta);
                
    }
    
    // generation of the values for ExchangeRate
    private int GetNextExchangeRate(int basis, int delta) {
        
       Random rn = new Random();
       return  (rn.nextInt(basis)+delta);  // random num from delta till basis + delta
       
    }
    
}
