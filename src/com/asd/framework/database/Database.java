package com.asd.framework.database;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by 985552 on 6/12/2017.
 */
public class Database {
    private static Database INSTANCE = new Database();
   private Properties properties=new Properties();
    private InputStream input = null;

    DbContext dbContext;
    private Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            input=getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(input);
            dbContext=new DbContext(new MySqlStrategy(properties.getProperty("dburl"),properties.getProperty("dbusername"),
                    properties.getProperty("password")));
            //dbContext.executeStrategy();
            System.out.println(properties.getProperty("dbusername"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public Connection getConnection(){
        return dbContext.executeStrategy();
    }
    public static Database getINSTANCE() {
        return INSTANCE;
    }

}

