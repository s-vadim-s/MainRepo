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
public class CurrencyContract implements Contract {
    
        
    public String contractName;
    public int price;
    public int initial_price = 0;
    public int days; // for forward contract
    public ContractType type;
    
    // spot contract
    CurrencyContract(String name, int price_buy){
        
        this.contractName = name;
        this.price = price_buy;
        this.days = 0; // since it's not forward, but spot
        this.type = ContractType.CurrencyExchange;
              
    }
         
    // forward contract
    CurrencyContract(String name, int price_buy, int forward_price, int days){
        
        this.contractName = name;
        this.initial_price = price_buy;
        this.price = forward_price;
        this.days = days;
        this.type = ContractType.CurrencyForward;
              
    }
    
}
