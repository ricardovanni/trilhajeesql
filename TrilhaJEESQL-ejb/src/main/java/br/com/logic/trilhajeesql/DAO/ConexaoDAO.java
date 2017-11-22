package br.com.logic.trilhajeesql.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private Connection conn = null;

    public Connection conectarHsqldb() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("DataSource inexistente");
        }
        Connection connection = dataSource.getConnection();
        if (connection == null) {
            throw new SQLException("Não há conexão com o banco");
        }
        conn = connection;
        return connection;
    }

    public Connection getConnection() {
        return conn;
    }

    public void finalizarConexao(Connection conn, Statement stmt, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
