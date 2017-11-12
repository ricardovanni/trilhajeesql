
package br.com.logic.trilhajeesql.EJB.Bean;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import br.com.logic.trilhajeesql.EJB.Interface.AcessoBanco;
import br.com.logic.trilhajeesql.Model.Lancamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * 
 * @author Ricardo Vanni
 */
@Stateless
@LocalBean
public class AcessoBancoBean extends ConexaoDAO implements AcessoBanco{
 @Override
    public void insereDados(Lancamento dados) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        
        try {
            //<editor-fold defaultstate="collapsed" desc="Conexao">
            conn = conecta();
            stmt = conn.createStatement();
            //</editor-fold>
            
            StringBuilder sql = new StringBuilder();
            sql.append("\n INSERT INTO lancamento(nome, data, valor, idtipolancamento)");
            sql.append("\n VALUES (?, ?, ?, ?)");
            
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1, dados.getNome());
            ps.setString(1, dados.getData());
            ps.setDouble(3, dados.getValor());
            ps.setInt(4, dados.getTipoLancamento());
            
            ps.execute();
            stmt.execute("shutdown");
            
        } catch (Exception e) {
            throw e;
        } finally {
            fechaConexao(conn, stmt, null);
        }
    }

    @Override
    public Lancamento retornaObjeto() throws Exception {
        Lancamento ret = new Lancamento();
        ret.setNome("Ricardo");
        ret.setData("10/11/2017");
        ret.setValor(134.56);
        ret.setTipoLancamento(1);
        return  ret;
    }
}
