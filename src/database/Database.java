package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Alexis Arriola
 */
public class Database 
{
    //variables
    private Connection conn;
    private Statement  stmnt;
    private ResultSet  resul;
    
    //private constructor
    private Database() { Connect(); }

    //private static instance
    private static Database singletonOfDatabase = null;

    //property to return the singleton instance
    public static Database GetSingletonOfdatabase() 
    {
        if (singletonOfDatabase == null) 
        {
            singletonOfDatabase = new Database();
        }
        return singletonOfDatabase;
    }
    
    /**
     * @return the conn
     */
    public Connection GetConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void SetConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * @return the stmnt
     */
    public Statement GetStmnt() {
        return stmnt;
    }

    /**
     * @param stmnt the stmnt to set
     */
    public void SetStmnt(Statement stmnt) {
        this.stmnt = stmnt;
    }

    /**
     * @return the resul
     */
    public ResultSet GetResul() {
        return resul;
    }

    /**
     * @param resul the resul to set
     */
    public void SetResul(ResultSet resul) {
        this.resul = resul;
    }
    
    //functions
    public void Connect()
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthybytes", "root", "swe_3340");
            stmnt = conn.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Could not connect: " + e);
        }
    }
}