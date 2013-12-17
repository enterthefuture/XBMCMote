/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.json.simple.JSONObject;
import asg.cliche.Command;
import asg.cliche.ShellFactory;
import java.io.IOException;
import java.util.LinkedHashMap;
         
/**
 *
 * @author William
 */
public class XBMCmote {
    /**
     * @param args the command line arguments
     */	
    Remote XBMC = new Remote( "192.168.1.105", 8081 );
    
    public static void main(String[] args) {
        try {
            ShellFactory.createConsoleShell("xbmc", "XBMC Control Shell v0.1.", new XBMCmote()) 
                    .commandLoop();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
 
    
    
    @Command
    public String up() {
        JSONObject request = XBMC.inputUp;
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }
    
    
    @Command
    public String down() {
        JSONObject request = XBMC.inputDown;
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }
    
    
    @Command
    public String left() {
        JSONObject request = XBMC.inputLeft;
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }
    
    
    @Command
    public String right() {
        JSONObject request = XBMC.inputRight;
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }
    
    @Command
    public String back() {
        JSONObject request = XBMC.inputBack;
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }
    
    @Command
    public String home() {
        JSONObject request = XBMC.inputHome;
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }
    
    @Command
    public String info() {
        JSONObject request = XBMC.inputInfo;
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }
    
    @Command
    public String menu() {
        JSONObject request = XBMC.inputContextMenu;
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }
    
    @Command
    public String select() {
        JSONObject request = XBMC.inputSelect;
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }

    /**
     *
     * @param title title of notification
     * @param message body of notification
     * @param image icon to be displayed with notification
     * @param timeout time to display notification
     * @return command sent
     */
    @Command
    public String notify(String title, String message, String image, int timeout) {
        JSONObject request = XBMC.guiNotify;
        
        LinkedHashMap params = new LinkedHashMap();
        
        params.put("title", title);
        params.put("message", message);
        params.put("image", image);
        params.put("timeout", timeout);
        
        request.put("params", params);
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }    
    
    /**
     *
     * @param title title of notification
     * @param message body of notification
     * @param image icon to be displayed with notification
     * @return command sent
     */
    @Command
    public String notify(String title, String message, String image) {
        JSONObject request = XBMC.guiNotify;
        
        LinkedHashMap params = new LinkedHashMap();
        
        params.put("title", title);
        params.put("message", message);
        params.put("image", image);
        
        request.put("params", params);
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }

    /**
     *
     * @param title title of notification
     * @param message body of notification
     * @return command sent
     */
    @Command
    public String notify(String title, String message) {
        JSONObject request = XBMC.guiNotify;
        
        LinkedHashMap params = new LinkedHashMap();
        
        params.put("title", title);
        params.put("message", message);
        params.put("image", "info");
        
        request.put("params", params);
        
        String response = XBMC.sendCommand(request);
        
        return String.format("%s\n%s", request.toString(), response);
    }
}
