/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave;


import org.json.JSONObject;



/**
 *
 * @author Theresa
 */
public class Charge {
    
    ApiConnection apiConnection;
    Endpoints ed= new Endpoints();
 
   
/**
 *
 * @param client
 * @return JSONObject
 */
    
    
    //for all charges
    public JSONObject charge(String client){
        this.apiConnection = new ApiConnection(ed.getChargeEndPoint());
          
       String alg="3DES-24";
      
     
        ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey", RaveConstant.PUBLIC_KEY);

        api.putParams("client", client);

        api.putParams("alg", alg);
      
        
        return this.apiConnection.connectAndQuery(api);
    }
     /**
    *
    * 
    * @return JSONObject
    * @param  transaction_reference
    * @param otp
    * 
    */
    
    public JSONObject validateCharge(String transaction_reference, String otp){
    
       this.apiConnection = new ApiConnection(ed.getValidateChargeEndPoint());
      
        ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey",RaveConstant.PUBLIC_KEY);
        api.putParams("transaction_reference", transaction_reference);
    
        api.putParams("otp", otp);

        return this.apiConnection.connectAndQuery(api);
    }

   
   
    
   
}
