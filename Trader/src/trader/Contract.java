/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trader;

enum ContractType {
    NA, CurrencyExchange, CurrencyForward, Option
}

/**
 *
 * @author VSoldatov
 */
public interface Contract {
    
  public ContractType type = ContractType.NA;  // default value
    
  public String Ticker = "";  
  public String ContractName = "";
  public int Price = 0;
  
     
}
