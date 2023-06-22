package Connections;
import java.sql.Connection;
import java.sql.SQLException;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import org.jboss.logging.Logger;

import io.agroal.api.AgroalDataSource;

@ApplicationScoped
public class connection {
    
    @Inject
    AgroalDataSource source;
    
    @Inject
    Logger log;

    public Connection getconnection(){
        try {
            
            return source.getConnection();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
