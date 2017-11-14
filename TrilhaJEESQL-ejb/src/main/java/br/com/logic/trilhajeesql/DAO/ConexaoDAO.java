package br.com.logic.trilhajeesql.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;

/**
 * 
 * @author Ricardo Vanni
 */
public class ConexaoDAO {
    
    
    @Resource(lookup = "java:/jboss/resources/hsqldb")
            
    
    
    Connection con = null;
    String driver = "org.hsqldb.jdbc.JDBCDriver";
   
    String url = "jdbc:hsqldb:file:";
    String caminho = System.getProperty("user.dir")+ "/src/main/resources/lancamento/lancamento";
    String user = "SA";
    String senha = "";
    
    /**
     * METODO PARA CONEXÃO COM O BANCO DE DADOS HSQLDB
     * @return retorna a conexão do BD
     */
    public Connection conecta(){
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url+caminho,user,senha);
            
            System.out.println("Conectado ao banco HSQLDB!");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return con;
    }
          
    public Connection getConnection(){
        return con;
    }
    
    public void fechaConexao(Connection conn, Statement stmt, ResultSet rs){
        try {
            if(conn != null){
                conn.close();
            }
            
            if(stmt != null){
                stmt.close();
            }
            
            if(rs != null){
                rs.close();
            }
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
