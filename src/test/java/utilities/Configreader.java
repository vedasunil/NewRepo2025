package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configreader {

    private static Properties prop;
    
    public static void loadproperties() throws IOException
    {
    	FileInputStream fis= new FileInputStream("/Users/sunilbj/Veda/TestAutomation/src/test/resources/Configfile.properties");
    	prop=new Properties();
    	prop.load(fis);
    }
    

    // Method to get property by key
    public static String getProperty(String key) {
    	if(prop==null)
    	{
    		try 
    		{
    		loadproperties();
    		
    		}
    		catch(Exception e)
    		{
    			System.out.println(e.getMessage());
    		}
    	
    		
    	}
    		return prop.getProperty(key);
    }
    public static void main(String[] args) {
        System.out.println(Configreader.getProperty("browser"));
        System.out.println(Configreader.getProperty("testurl"));
    }
    
    public static void deleteJsonFiles(String []folders) {
    	for(String folderpath : folders)
    	{
    		File folder = new File(folderpath);

            if (folder.exists() && folder.isDirectory()) {
                for (File file : folder.listFiles()) {
                    if (file.getName().endsWith(".png") || file.getName().endsWith(".json")) {
                        file.delete();
                        System.out.println("Deleted: " + file.getName());
                    }
                    else
                    	System.out.println("cant be Deleted: " + file.getName());
                    	
                    }
                
                }
    	}
       /* File folder = new File(folderpath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("️Folder not found: " + folderpath);
            return;
        }

        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

        if (files == null || files.length == 0) {
            System.out.println("No .json files found in folder: " + folderpath);
            return;
        }
        
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                String name = file.getName();
                if (name.endsWith(".png") || name.endsWith(".json")) {
                    file.delete();
                    System.out.println("Deleted: " + file.getName());
                }
                    else
                    	System.out.println("Could not delete: " + file.getName());
                }
            }
        

        /*for (File file : files) {
            if (file.delete()) {
                System.out.println("Deleted: " + file.getName());
            } else {
                System.out.println("Could not delete: " + file.getName());
            }
        }*/
    }
    
}