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
public class Remote {
    
    JSONObject inputUp = new JSONObject();
    JSONObject inputDown = new JSONObject();
    JSONObject inputLeft = new JSONObject();
    JSONObject inputRight = new JSONObject();
    
    JSONObject inputHome = new JSONObject();
    JSONObject inputBack = new JSONObject();
    JSONObject inputInfo = new JSONObject();
    JSONObject inputContextMenu = new JSONObject();
    
    JSONObject inputSelect = new JSONObject();
    

    String path = "http://192.168.1.105:8081/jsonrpc";

    /**
     * @param address IP address of XBMC server
     * @param port port number of HTTP server
     */	
    Remote(String address, int port) {
        
        buildCommands();

        //JSONObject request = inputHome;
        
        //System.out.println(request.toString());
        
        path = String.format("http://%s:%s/jsonrpc", address, port);
        
        //sendCommand(address, request);
    }

   Remote(String address) {
        int port = 8080;
            
        buildCommands();

        //JSONObject request = inputHome;
        
        //System.out.println(request.toString());
        
        path = String.format("http://%s:%s/jsonrpc", address, port);
        
        //sendCommand(request);
    }

    
    private void buildCommands() {
        
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
        
        inputInfo.putAll(jsonHeaders);
        inputInfo.put("method", "Input.Info");
        
        inputContextMenu.putAll(jsonHeaders);
        inputContextMenu.put("method", "Input.ContextMenu");
        
        
        inputSelect.putAll(jsonHeaders);
        inputSelect.put("method", "Input.Select");
    }
    
    public void sendCommand(JSONObject jsonBody) {
         	
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpPost httpRequest = new HttpPost(path);
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
