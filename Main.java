/* INEW 2438
 * Kuohsun Tsai
 * W208999498
 * Assignment 1
 */
package com.mycompany.assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URL;
import java.io.*;

/**
 *
 * @author W208999498
 */
public class Main {
    public static void main(String[] args)throws MalformedURLException, IOException
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        
       try{
            
            URL w3schools_url = new URL("https://www.w3schools.com/angular/customers.php");
            HttpURLConnection w3schools_url_conn = (HttpURLConnection) w3schools_url.openConnection();
            w3schools_url_conn.setRequestMethod("GET");
            w3schools_url_conn.setRequestProperty("Accept", "application/json");
            
            if (w3schools_url_conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code  : " + w3schools_url_conn.getResponseCode());
            }
        
           String sCurrentLine;
           BufferedReader buffReader = new BufferedReader(new InputStreamReader(w3schools_url_conn.getInputStream(),"UTF-8"));
           while ((sCurrentLine = buffReader.readLine()) != null) {
		System.out.println(sCurrentLine);
	   }
           
           gsonBuilder.registerTypeAdapter(Demographics.class, new DemoInstanceCreator());

           Gson gson = gsonBuilder.create();
           Demographics demo = gson.fromJson(buffReader, Demographics.class);
       

           System.out.println("demo:");
           w3schools_url_conn.disconnect();

       }catch (MalformedURLException e){
            e.printStackTrace();
       }catch (IOException e){
            e.printStackTrace();
       }catch(Exception e){
            e.printStackTrace();
       }
        
    }
}



