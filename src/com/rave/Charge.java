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
    Keys key= new Keys();
/**
 *
 * @param encrypted_message
 * @return JSONObject
 */
    
    //for all charges
    public JSONObject charge(String encrypted_message){
        this.apiConnection = new ApiConnection(ed.getChargeEndPoint());
          
       String alg="3DES-24";
     
        ApiQuery api=new ApiQuery();
        
        api.putParams("PBFPubKey", key.getPublicKey());
        System.out.println(key.getPublicKey());
        api.putParams("client", encrypted_message);
        System.out.println(encrypted_message);
        api.putParams("alg", alg);
      
        
        return this.apiConnection.connectAndQuery(api);
    }
   
    
   
}
