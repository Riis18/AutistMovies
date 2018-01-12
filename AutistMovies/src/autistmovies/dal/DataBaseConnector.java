/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autistmovies.dal;

/**
 *
 * @author Jesper
 */

private SQLServerDataSource dataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DataBaseConnector 
{
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("EASV-DB2");
        dataSource.setPortNumber(1433);
        dataSource.setDatabaseName("Autistify");
        dataSource.setUser("CS2017A_15");
        dataSource.setPassword("Bjoernhart1234");
}
