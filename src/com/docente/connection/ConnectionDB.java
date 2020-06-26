/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.connection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;
import com.docente.implementation.ImplementationConnectionDB;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
/**
 *
 * @author DonTulio
 */
public class ConnectionDB implements ImplementationConnectionDB{
    
    private static ConnectionDB connectionDB;
    
    private Connection connection;
    
    private static List<Connection> pools;
    
    private ConnectionDB(){
        
    }
    
    
    public static ConnectionDB newInstance(){
        if(connectionDB == null){
            connectionDB = new ConnectionDB();
            pools = new ArrayList<Connection>();
        }
        return connectionDB;
    }
    
    private synchronized Connection getNewConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =
                    DriverManager
                            .getConnection(
                                    "jdbc:mysql://localhost:3307/respaldo", 
                                    "root",
                                    "password");
        pools.add(con);
        System.out.println("Connection abierta : " +con.toString());
        return con;
        
    }
    
    public Connection openConnection() throws SQLException,ClassNotFoundException,Exception{
        if(pools.size()>10){
            System.out.println("Entro");
            throw  new Exception("La operación deberá esperar");
        }
        return this.getNewConnection();
    }
    
    @Deprecated
    public void closeConnection() {
        try{
            if(!this.connection.isClosed()){
                this.connection.close();
            }
        }
        catch(SQLException e){
            System.out.println(
                        String
                                .format("SQL Exception : %s - %s",
                                        e.getErrorCode(),
                                        e.getMessage())
            );
        }
        catch(Exception e){
            System.out.println(
                        String
                                .format("Exception : %s - %s",
                                        e.hashCode(),
                                        e.getMessage())
            );
        }
    }
    
    public void closeConnection(Connection connection) {
        try{
            for(Connection temp: pools){
                if(temp.equals(connection)){
                    if(!temp.isClosed()){
                        System.out.println("Connection Cerrada:"  +temp.toString());
                        temp.close();
                        this.pools.remove(temp);
                        break;
                    }
                }
            }
            
        }
        catch(SQLException e){
            System.out.println(
                        String
                                .format("SQL Exception : %s - %s",
                                        e.getErrorCode(),
                                        e.getMessage())
            );
        }
        catch(Exception e){
            System.out.println(
                        String
                                .format("Exception : %s - %s",
                                        e.hashCode(),
                                        e.getMessage())
            );
        }
    }
    
}
