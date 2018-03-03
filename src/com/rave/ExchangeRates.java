/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;

import java.io.FileNotFoundException;
import org.json.JSONObject;

/**
 *
 * @author Theresa
 */
public class ExchangeRates {
     ApiConnection apiConnection;
     Endpoints end= new Endpoints();
     Keys key=new Keys();
    private String amount;
    private String origin_currency;
    private String destination_currency;
     /**
 *
 * @params
 * origin_currency,destination_currency , amount
 * @return JSONObject
 */
     

    public JSONObject forex(){

        
      this.apiConnection = new ApiConnection(end.getForexEndPoint());
      ApiQuery api= new ApiQuery();
     
      //API PARAMETERS
      api.putParams("SECKEY",key.getSecretKey());
      api.putParams("origin_currency", this.getOrigin_currency());
      api.putParams("destination_currency", this.getDestination_currency());
      api.putParams("amount", this.getAmount());
    
      
      return this.apiConnection.connectAndQuery(api);
    
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public ExchangeRates setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * @return the origin_currency
     */
    public String getOrigin_currency() {
        return origin_currency;
    }

    /**
     * @param origin_currency the origin_currency to set
     */
    public ExchangeRates setOrigin_currency(String origin_currency) {
        this.origin_currency = origin_currency;
        return this;
    }

    /**
     * @return the destination_currency
     */
    public String getDestination_currency() {
        return destination_currency;
    }

    /**
     * @param destination_currency the destination_currency to set
     */
    public ExchangeRates setDestination_currency(String destination_currency) {
        this.destination_currency = destination_currency;
        return this;
    }
}
