/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.util.Arrays;
import utilities.Email;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.*;
import database.Database;
/**
 *
 * @author Matthew Rodriguez
 */
public class EmailModel
{
    
    private Email currentEmail;
    Database HBDatabase = Database.GetSingletonOfdatabase();
    /**
     * @return the currentEmail
     */
    public Email getCurrentEmail()
    {
        return currentEmail;
    }

    /**
     * @param currentEmail the currentEmail to set
     */
    public void setCurrentEmail(Email currentEmail)
    {
        this.currentEmail = currentEmail;
    }
    
    
    //Functions // User Oriented // Must be moved to Login package or something
    public int GenerateVerifcationCode()
    {
        //Random Verifcation Code Generator
        int codeNumber;
        codeNumber = ThreadLocalRandom.current().nextInt(100000,9999999);
        return codeNumber;
    }
    
    //Appearently I can only update stuff with the user_Id so I need to extract key
    public int GetUserIdFromDatabase(String emailAddress)
    {
        int userId = 0;
        try
        {
            Statement stmnt = HBDatabase.GetStmnt();
            ResultSet result = stmnt.executeQuery("select user_id from users where email = '"+emailAddress+"';");
            
             if (result.next() == false)
            {
                System.out.println("User Id does not exist with corresponding email address provided. Returning -1...");
                userId = -1;
            }
            else
            {
                System.out.println("User Id found. Returning ID.");
                userId = result.getInt("user_id");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
        return userId;
    }

    public void SendVerificationCode(String emailAddress, Email currentEmail, String code)
    {
        currentEmail.setHost("smtp.gmail.com");
        String host = currentEmail.getHost();
        currentEmail.setPort("465");
        String port = currentEmail.getPort();
        currentEmail.setMailFrom("swe.healthybytes@gmail.com");
        String mailFrom = currentEmail.getMailFrom();
        currentEmail.setPassword("night_hb18");
        String password = currentEmail.getPassword();
        currentEmail.setToAddress(emailAddress);
        String toAddress = currentEmail.getToAddress();
        currentEmail.setSubject("Email Verification Code.");
        String subject = currentEmail.getSubject();
        currentEmail.setMessage("Please enter this verification code then press OK\n Code: " + code);
        String message = currentEmail.getMessage();
        String attachFiles[] = currentEmail.getAttachFiles();
        try
        {
            EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, toAddress, subject, message, attachFiles);
            System.out.println("Email Sent.");
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
    
    // Most likely User oriented function
    public boolean ToggleAuthenticate(int userId, int userInput, int generatedCode)
    {
        boolean toggled = false;
        if(userInput == generatedCode)
        {
            try
            {
                Statement statement = HBDatabase.GetStmnt();
                String sql = "update users set authenticate = authenticate + 1 where user_id = " + userId +";";
                statement.executeUpdate(sql);
                toggled = true;
            }
            catch(Exception e)
            {
                System.out.println("Error: " + e);
            }
        }
        else
        {
            toggled = false;
        }
        return toggled;
    }
}