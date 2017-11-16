package br.com.logic.trilhajeesql.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.sql.DataSource;

/**
 *
 * @author Ricardo Vanni
 */
@SessionScoped
public class ConexaoDAO implements Serializable {

    @Resource(lookup = "java:jboss/datasources/Hsqldb")
    private DataSource dataSource;

    public Connection conectarHsqldb() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("DataSource inexistente");
        }
        Connection connection = dataSource.getConnection();
        if (connection == null) {
            throw new SQLException("Não há conexão com o banco");
        }
        return connection;
    }
}
