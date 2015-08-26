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
public class Contract {
    
      
    public String contractName;
    public int price;
    
    Contract(String name, int price_buy){
        
        this.contractName = name;
        this.price = price_buy;
      
        
    }
            
    
}
