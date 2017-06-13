package com.asd.framework.dao;

import java.sql.Connection;
import java.util.List;

public class AbstractDao<T> implements IDao<T> {
    private Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
        template();
    }

    private final void template(){
        //Algorithm Steps
        //No need to bother now
    }

    @Override
    public Long insert(String tableName, String columnNames, String values) {
        return null;
    }

    @Override
    public Long update(String tableName, String statement, Long id) {
        return null;
    }

    @Override
    public void delete(String tableName, Long id) {

    }

    @Override
    public T get(String tableName, String relation, String condition, Class clazz) {
        return null;
    }

    @Override
    public List<T> getAll(String tableName, String relation, String condition, String pagination, Class clazz) {
        return null;
    }
}
