/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docente.implementation;

import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author DonTulio
 */
public interface ImplementationConnectionDB {
    @Deprecated
    public void closeConnection();
    public void closeConnection(Connection con);
    public Connection openConnection() throws SQLException,ClassNotFoundException,Exception;
}
