/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.*;

/**
 *
 * @author Matthew Rodriguez
 */
public class HBIO
{
    OutputStreamWriter out;
    
    public void OpenToWriteToTextFile(File file)
    {
        try
        {
            out = new OutputStreamWriter(new BufferedOutputStream(
            new FileOutputStream(file, true)));  /* Open the data file */
            
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
    }
    
    public String OpenToReadFromTextFile(File file)
    {
        String data = "";
        try
        {
            FileReader in = new FileReader(file); /* Input File to read from */
            BufferedReader inputline = new BufferedReader(in); /* BufferedReader to read lines in file */
            boolean line = true; /* Flag to see if there is something to be read from file */         
            while(line == inputline.ready())
            {
                data += inputline.readLine() + "\n";
            }
        }
        catch (Exception e)
        {
            
        }
        return data;        
    }
    
    public void ConvertBlobToTextFile()
    {
        
    }
    
    public void ConvertBlobToImage()
    {
        
    }
}
