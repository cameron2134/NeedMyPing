package dev.cameron2134.nmp.utilities;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;



public class IO {

    
    private static final File dataFolder = new File("resources/data");

    

    public static void saveDefaultAddress(String address, File addressFile) {
        
        FileWriter filewriter = null;
        BufferedWriter writer = null;
        
        if (!dataFolder.exists())
            dataFolder.mkdir();
        
        
        try {
            filewriter = new FileWriter(addressFile);
            writer = new BufferedWriter(filewriter);
            
            writer.write(address);
            
        } 
        
        
        
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        finally {
            try {
                writer.close();
            }
            
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    
    
    public static void saveWindowPos(Point anchorPos, File anchorFile){
        
        FileWriter filewriter = null;
        BufferedWriter writer = null;
        
        
        if (!dataFolder.exists())
                dataFolder.mkdir();
            
            
        if (anchorPos == null)
            JOptionPane.showMessageDialog(null, "Widget cannot be anchored if it has not been moved!", "Error", JOptionPane.ERROR_MESSAGE);
            
        else {
            
            try {
                filewriter = new FileWriter(anchorFile);
                writer = new BufferedWriter(filewriter);


                writer.write(anchorPos.toString());
                

            }



            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            finally {
                try {
                    writer.close();
                } 
                
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            
        }
            
        
            
    } 
 
        
        
        
        
        
        
    
    
    

    
    
    
    
    public static String loadDefaultAddress(File addressFile) {
        
        String defaultAddress = null;
        
        FileReader fileReader = null;
        BufferedReader reader = null;    
        
        
        try {
        	
            
            fileReader = new FileReader(addressFile);
            reader = new BufferedReader(fileReader);

            
            defaultAddress = reader.readLine();           
            
        }
        
        catch(IOException ex) {
        	
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        
        finally {
            try {
                reader.close();
            }
            
            catch(IOException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return defaultAddress;
    }
    
    
    
    
    
    
    public static int[] loadWindowPos(File anchorFile){
        // Will need to split the string up to get the coordinates to convert back into point
        
        String posFromFile = null;
        String[] tempArray1;
        String[] tempArray2;
        
        int[] coords = new int[2];
        
        FileReader fileReader = null;
        BufferedReader reader = null;  
        
        try {
        	
            
            fileReader = new FileReader(anchorFile);
            reader = new BufferedReader(fileReader);

            
            posFromFile = reader.readLine();

            
            // Splitting coordinate data from the string
            
            tempArray1 = posFromFile.split("=");
            
            
            
            String temp1 = tempArray1[1]; 
            String temp2 = tempArray1[2]; 

            tempArray1 = temp1.split(",");
            tempArray2 = temp2.split("]");
            
            
            coords[0] = Integer.parseInt(tempArray1[0]); // storing x coordinate into position 0 and y into position 1 of the array to be returned
            coords[1] = Integer.parseInt(tempArray2[0]);            
            
        }
        
        catch(IOException ex) {	
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        finally {
            try {
                reader.close();
            }
            
            catch(IOException ex) {	
                JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        

        return coords;
        
    } 
    
    

    
    
    
    
    public static boolean isInt(String text) {
        
        try {
            int x = Integer.parseInt(text);
        }
        
        catch (NumberFormatException ex) {
            return false;
        }
        
        return true;
        
    }
    
    
    
    
}
