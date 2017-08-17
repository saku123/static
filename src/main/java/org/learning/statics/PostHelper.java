package org.learning.statics;

import com.google.gson.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostHelper {
	public static final String URL = "http://162.220.8.246:3000/translate";

    public static String transltePost(String text) {
        JsonObject obj = new JsonObject();
        obj.addProperty("text",text);
    	String response = null;
        try {
            CloseableHttpClient httpclient = null;
           CloseableHttpResponse httpresponse = null;
           try {
               httpclient = HttpClients.createDefault();
               HttpPost httppost = new HttpPost(URL);
               
               StringEntity stringentity = new StringEntity(obj.toString(),
                      ContentType.create("application/json", "UTF-8"));
               httppost.setEntity(stringentity);
              httpresponse = httpclient.execute(httppost);
               response = EntityUtils
                       .toString(httpresponse.getEntity());
           } finally {
               if (httpclient != null) {
                   httpclient.close();
               }
               if (httpresponse != null) {
                  httpresponse.close();
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return response;
    }
    
    public static void main(String args[]){
    	transltePost("MongoDB Tutorial");
    }
}
