
package br.com.mcg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author alafaria
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/mastercontrolguide?useTimezone=true&serverTimezone=UTC", "root", "root");
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
}
