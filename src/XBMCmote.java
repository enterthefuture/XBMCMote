/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.LinkedHashMap;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.simple.JSONObject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

         
/**
 *
 * @author William
 */
public class XBMCmote {
    
    static JSONObject inputUp = new JSONObject();
    static JSONObject inputDown = new JSONObject();
    static JSONObject inputLeft = new JSONObject();
    static JSONObject inputRight = new JSONObject();
    
    static JSONObject inputHome = new JSONObject();
    static JSONObject inputBack = new JSONObject();
    
    /**
     * @param args the command line arguments
     */	
    public static void main(String[] args) {
        
        buildCommands();

        JSONObject request = inputHome;
        
        System.out.println(request.toString());
        
        String address = "http://192.168.1.105:8081/jsonrpc";
        if (args.length != 0) address = args[1];
        
        sendCommand(address, request);
    }
    
    private static void buildCommands() {
        
        LinkedHashMap jsonHeaders = new LinkedHashMap();
        
        jsonHeaders.put("id", 0);
        jsonHeaders.put("jsonrpc", "2.0");
        
        inputUp.putAll(jsonHeaders);
        inputUp.put("method", "Input.Up");

        inputDown.putAll(jsonHeaders);
        inputDown.put("method", "Input.Down");
        
        inputLeft.putAll(jsonHeaders);
        inputLeft.put("method", "Input.Left");
        
        inputRight.putAll(jsonHeaders);
        inputRight.put("method", "Input.Right");
        
        inputHome.putAll(jsonHeaders);
        inputHome.put("method", "Input.Home");
        
        inputBack.putAll(jsonHeaders);
        inputBack.put("method", "Input.Back");
        
    }
    
    private static void sendCommand(String xbmcAddress, JSONObject jsonBody) {
         		
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpPost httpRequest = new HttpPost(xbmcAddress);
			StringEntity httpParams = new StringEntity(jsonBody.toString());
			httpParams.setContentType("application/json");
                        httpRequest.setEntity(httpParams);
			httpClient.execute(httpRequest);
		// handle response here...
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
                    try {
                        httpClient.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
		}
    }
    
}
