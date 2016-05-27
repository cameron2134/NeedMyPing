package dev.cameron2134.nmp;

import dev.cameron2134.nmp.display.GUI;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class PingChecker implements Runnable {

    
    private boolean changeServer;
    
    private String address;
    
    private String[] cmdLineArray, pingArray;
    private String pingLine, line;
    
    private int timeouts;
    
    private Process process;
    
    private BufferedReader in;
    
    private GUI gui;
    
    
    
    
    public PingChecker(GUI gui) {
        
        this.gui = gui;
        this.changeServer = false;
        this.timeouts = 0;
        
    }
    
    
    
    
    
    
    public void ping() {
        
        String currentPing = null;
        int count = 0;

        setup();

        try {
            
    
           while (true) {

               if (changeServer) {
                   // If user changes ping server, destroy old process, create new process to ping new server
                   process.destroy();

                   setup(); // re-does the setup to use the new address
                   
                   changeServer = false;
               }
    
               
                line = in.readLine();
                System.out.println(line);


                // If the user entered an invalid address, or the address is unreachable, inform user, change server
                if (line == null || line.contains("could not find host")) {

                    gui.setColour(new Color(143, 16, 16));
                    gui.setDisplayLbl("ERR");
                    
                    JOptionPane.showMessageDialog(null, "Unreachable host. Changing server to eBay.", "Error", JOptionPane.ERROR_MESSAGE);
                    
                    setAddress("www.ebay.co.uk");
                    setServer(true);
                    
                    try {
                        Thread.sleep(1500);
                    } 

                    catch (InterruptedException ex) {
                        Logger.getLogger(PingChecker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                
                
                else {
                    
                    while ((line != null) && (count < 2)) {

                        if (line.length() > 0) {
                            
                            if (line.contains("timed out")) {
                                timeouts++;
                                
                                gui.setColour(new Color(143, 16, 16));
                                gui.setDisplayLbl("T/O");

                                if (timeouts >= 3) {
                                    JOptionPane.showMessageDialog(null, "Your selected server is timing out a lot. Consider changing.", "Error", JOptionPane.ERROR_MESSAGE);
                                    System.out.println("This server is timing out a lot. Change server?");

                                    timeouts = 0;
                                }
                            }
                            
                            else {
                            
                                // Basically splits the line if it contains the word time. The words before time are stored in position 0, while words after time are stored in position 1
                                cmdLineArray = line.split("time="); 

                                 count++;
                            }
                        }
                        

                        line = in.readLine();
                        System.out.println("Line reads: " + line);
                    }



                    pingLine = cmdLineArray[1]; // getting the line that the ping details are stored from array

                    pingArray = pingLine.split(" "); // Splitting the ping latency from the TTL



                    currentPing = pingArray[0]; // Position 0 is the latency value, 1 would be the TTL

                    // Remove letters to allow comparison to numbers
                    gui.setDisplayLbl(currentPing.substring(0,currentPing.length()-2));


                } 
                    
                count = 0; // needs to be reset here so the arrays will be updated with new data
            
           }
        } 
        
        
        
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
               

    }
    
    
    
    
    private void setup() {
        
        ProcessBuilder builder;
        
        try {
            builder = new ProcessBuilder(new String[] {"ping", address, "-t"});
            process = builder.start();
            
            //Gets the inputstream to read the output of the command
            in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
        } 
        
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
 
    }
    
    
    
    @Override
    public void run() {
        ping();
    }
    
    
    
    
    
    
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setServer(boolean changeServer) {
        this.changeServer = changeServer;
    }
    
    
    
    
    
    
    public String getAddress() {
        return this.address;
    }
    
    public Process getProcess() {
        return this.process;
    }
    
    public boolean getChangeServer() {
        return this.changeServer;
    }

    
 
    
    
}
