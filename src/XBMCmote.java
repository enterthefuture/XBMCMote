/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.json.simple.JSONObject;
import asg.cliche.Command;
import asg.cliche.ShellFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
         
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
            ShellFactory.createConsoleShell("xbmc", "XBMC Control Shell v0.01.", new XBMCmote()) 
                    .commandLoop();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
 
    
    
    @Command
    public String up() {
        JSONObject request = XBMC.inputUp;
        
        XBMC.sendCommand(request);
        
        return request.toString();
    }
    
    
    @Command
    public String down() {
        JSONObject request = XBMC.inputDown;
        
        XBMC.sendCommand(request);
        
        return request.toString();
    }
    
    
    @Command
    public String left() {
        JSONObject request = XBMC.inputLeft;
        
        XBMC.sendCommand(request);
        
        return request.toString();
    }
    
    
    @Command
    public String right() {
        JSONObject request = XBMC.inputRight;
        
        XBMC.sendCommand(request);
        
        return request.toString();
    }
    
    
    @Command
    public String back() {
        JSONObject request = XBMC.inputBack;
        
        XBMC.sendCommand(request);
        
        return request.toString();
    }
    
    @Command
    public String select() {
        JSONObject request = XBMC.inputSelect;
        
        XBMC.sendCommand(request);
        
        return request.toString();
    }
}
