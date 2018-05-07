/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.*;
import java.sql.Blob;

/**
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
                    new FileOutputStream(file, true)));
            /* Open the data file */

        } catch (FileNotFoundException e)
        {
            System.out.println("Error:" + e);
        }
    }

    public static String OpenToReadFromTextFile(String path)
    {
        String data = "";
        try
        {
            File file = new File(path);
            FileReader in = new FileReader(file);
            /* Input File to read from */
            BufferedReader inputline = new BufferedReader(in);
            /* BufferedReader to read lines in file */
            boolean line = true;
            /* Flag to see if there is something to be read from file */
            while (line == inputline.ready())
            {
                data += inputline.readLine() + "\n";
            }
        } catch (IOException e)
        {
            System.out.println("Exception at HBIO, Function OpenReadFromTextFile: " + e);
        }
        return data;
    }

    public static String ConvertBlobToFile(String name, int owner,Blob blob, int type)
    {
        String filepath = "";
        try
        {
            if (type == 1)
            {
                filepath = "src/tempfiles/" + name + owner +".jpg";
                OutputStream outputStream;
                try (InputStream in = blob.getBinaryStream()) 
                {
                    outputStream = new FileOutputStream(filepath);
                    int bytesRead = -1;
                    byte[] buffer = new byte[4096];
                    while ((bytesRead = in.read(buffer)) != -1)
                    {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.close();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
                System.out.println("File saved");
                filepath = "tempfiles/" + name + owner +".jpg";
                return filepath;
            }
            else if (type == 2)
            {
                filepath = "src/tempfiles/" + name + owner +"Info.txt";
                OutputStream outputStream;
                try (InputStream in = blob.getBinaryStream()) {
                    outputStream = new FileOutputStream(filepath);
                    int bytesRead = -1;
                    byte[] buffer = new byte[4096];
                    while ((bytesRead = in.read(buffer)) != -1)
                    {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.close();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
                System.out.println("File saved");
                return filepath;
            }
            else
            {
                filepath = "src/tempfiles/" + name + owner +"Desc.txt";
                OutputStream outputStream;
                try (InputStream in = blob.getBinaryStream())
                {
                    outputStream = new FileOutputStream(filepath);
                    int bytesRead = -1;
                    byte[] buffer = new byte[4096];
                    while ((bytesRead = in.read(buffer)) != -1)
                    {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    outputStream.close();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                System.out.println("File saved");
                return filepath;
            }

        }
        catch (Exception e)
        {
            System.out.println("Exception at HBIO, Function ConvertBlobToFile: " + e);
        }
        
        return filepath;
    }
}
