/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @author Jesper Riis
 */
public class DataBaseConnector {
    
    private final SQLServerDataSource dataSource;

    /*
    * sets the database sources.
    */
    public DataBaseConnector()
    {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("EASV-DB2");
        dataSource.setPortNumber(1433);
        dataSource.setDatabaseName("AutistMovies");
        dataSource.setUser("CS2017A_15");
        dataSource.setPassword("Bjoernhart1234");
    }
    
    /*
    * gets the connection to the database
    */
    public Connection getConnection() throws SQLServerException
    {
        return dataSource.getConnection();
    }

    
}
