package br.com.logic.trilhajeesql.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Ricardo Vanni
 */
@Stateless
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

//    Connection con = null;
//    String driver = "org.hsqldb.jdbc.JDBCDriver";
//
//    String url = "jdbc:hsqldb:file:";
//    String caminho = System.getProperty("user.dir") + "/src/main/resources/lancamento/lancamento";
//    String user = "SA";
//    String senha = "";
//    /**
//     * METODO PARA CONEXÃO COM O BANCO DE DADOS HSQLDB
//     *
//     * @return retorna a conexão do BD
//     */
//    public Connection conecta() {
//
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url + caminho, user, senha);
//
//            System.out.println("Conectado ao banco HSQLDB!");
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return con;
//    }
//
//    public Connection getConnection() {
//        return con;
//    }
//
//    public void fechaConexao(Connection conn, Statement stmt, ResultSet rs) {
//        try {
//            if (conn != null) {
//                conn.close();
//            }
//
//            if (stmt != null) {
//                stmt.close();
//            }
//
//            if (rs != null) {
//                rs.close();
//            }
//
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
