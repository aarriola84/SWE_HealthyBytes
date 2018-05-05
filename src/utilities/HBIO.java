/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    new FileOutputStream(file, true)));
            /* Open the data file */

        } catch (Exception e)
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
        } catch (Exception e)
        {

        }
        return data;
    }

    public static String ConvertBlobToFile(String name, Blob blob, int type)
    {
        String filepath = "";
        try
        {
            if (type == 1)
            {
                filepath = "src/tempfiles/" + name + ".jpg";
                InputStream in = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filepath);
                int bytesRead = -1;
                byte[] buffer = new byte[4096];
                while ((bytesRead = in.read(buffer)) != -1)
                {
                    outputStream.write(buffer, 0, bytesRead);
                }
                in.close();
                outputStream.close();
                System.out.println("File saved");
                filepath = "tempfiles/" + name + ".jpg";
                return filepath;
            }
            else if (type == 2)
            {
                filepath = "src/tempfiles/" + name + "Info.txt";
                InputStream in = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filepath);
                int bytesRead = -1;
                byte[] buffer = new byte[4096];
                while ((bytesRead = in.read(buffer)) != -1)
                {
                    outputStream.write(buffer, 0, bytesRead);
                }
                in.close();
                outputStream.close();
                System.out.println("File saved");
                return filepath;
            }
            else
            {
                filepath = "src/tempfiles/" + name + "Desc.txt";
                InputStream in = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filepath);
                int bytesRead = -1;
                byte[] buffer = new byte[4096];
                while ((bytesRead = in.read(buffer)) != -1)
                {
                    outputStream.write(buffer, 0, bytesRead);
                }
                in.close();
                outputStream.close();
                System.out.println("File saved");
                return filepath;
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(HBIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(HBIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(HBIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return filepath;
    }

    public void ConvertBlobToImage()
    {
        
    }
}
