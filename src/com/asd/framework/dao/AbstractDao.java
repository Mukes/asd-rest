package com.asd.framework.dao;

import com.asd.framework.database.Database;

import java.sql.*;
import java.util.List;

public class AbstractDao<T> implements IDao<T> {
    private Connection connection;
    PreparedStatement preparedStatement;

    public AbstractDao(Connection connection) {
        this.connection = connection;
        template();
    }

    private final void template(){
        //Algorithm Steps
        //No need to bother now
    }

    public Long insert(String tableName, String columnNames, String values) {
        String sql="INSERT INTO "+tableName+"( \""+columnNames+" \") VALUES ( \""+values+"\" )";
        Integer id=0;
        try {
            preparedStatement=connection.prepareStatement(sql);
            System.out.println(preparedStatement);
           id= preparedStatement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (long)id;
    }

    public Long update(String tableName, String statement, Long id) {
        String updateStr = "UPDATE "+tableName+" SET "+ statement+" WHERE id =  "+id;
        Integer updateid=0;
        try {
            preparedStatement=connection.prepareStatement(updateStr);
            System.out.println(preparedStatement);
            updateid= preparedStatement.executeUpdate(updateStr, Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (long)updateid;
    }

    public void delete(String tableName, Long id) {

    }

    public T get(String tableName, String relation, String condition, Class clazz) {
        return null;
    }

    public List<T> getAll(String tableName, String relation, String condition, String pagination, Class clazz) {
        return null;
    }

    public static void main(String[] args) {
        Connection connection =Database.getINSTANCE().getConnection();
        AbstractDao abstractDao=new AbstractDao(connection);
        abstractDao.insert("zam","hello","123");
    }


}
