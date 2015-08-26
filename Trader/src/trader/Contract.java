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
    
    enum ContractType {
        Forward, Futures, Option
    }
    
    public String contractName;
    public ContractType contractType;
    public int price;
    
    public void Contract(String name, int price_buy, ContractType type){
        
        this.contractName = name;
        this.price = price_buy;
        this.contractType = type;
        
    }
            
    
}
