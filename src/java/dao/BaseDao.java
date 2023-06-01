/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mido
 * @param <T>
 */
public abstract class BaseDao<T> {
    Connection con = null;
    
    public BaseDao() throws Exception {
        con = new DBContext().connection;        
    }
    
    public PreparedStatement createPreparedStatement(String query, Object... params) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            for(int i=0;i<params.length;i++) {
                ps.setObject(i+1, params[i]);
            }
        } catch (SQLException e) {
            // Handle the exception
        } finally {
            closeResources(ps);
        }
        return ps;
    }
    public abstract List<T> getAll();
    
    public abstract int insert(T obj);
    
    public abstract int update(T obj);
    
    public abstract int delete(int id);
    
    public abstract T get(int id); 
    
    public void closeResources(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                // Handle or log the exception
            }
        }
    }
}
