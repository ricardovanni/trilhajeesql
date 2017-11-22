package br.com.logic.trilhajeesql.DAO;

import br.com.logic.trilhajeesql.Model.Lancamento;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Ricardo Vanni
 */
@SessionScoped
public class LancamentoDAO implements Serializable {

    @Inject
    private ConexaoDAO connection;

    public String inserirDados(Lancamento dados) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        try {
            //<editor-fold defaultstate="collapsed" desc="Conexao">
            conn = connection.conectarHsqldb();
            stmt = conn.createStatement();
            //</editor-fold>

            StringBuilder sql = new StringBuilder();
            sql.append("\n INSERT INTO lancamento(nome, data, valor, idtipolancamento)");
            sql.append("\n VALUES ('").append(dados.getNome()).append("', '")
                    .append(dados.getData()).append("', ")
                    .append(dados.getValor()).append(", ")
                    .append(dados.getIdTipoLancamento()).append(")");

            stmt.execute(sql.toString());
            stmt.execute("commit");

            return "Dados Inseridos com sucesso!";
        } catch (SQLException e) {
            throw e;
        } finally {
            connection.finalizarConexao(conn, stmt, null);
        }
    }

    public List<Lancamento> consultarDados() throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Lancamento> ret = new ArrayList<>();
        try {
            //<editor-fold defaultstate="collapsed" desc="Conexao">
            conn = connection.conectarHsqldb();
            stmt = conn.createStatement();
            //</editor-fold>

            StringBuilder sql = new StringBuilder();
            sql.append("\n SELECT l.id, l.nome, l.data, l.valor, l.idtipolancamento, tl.tipolancamento");
            sql.append("\n FROM lancamento l ");
            sql.append("\n INNER JOIN tipolancamento tl ON tl.id = l.idtipolancamento ");

            rs = stmt.executeQuery(sql.toString());

            while (rs.next()) {
                Lancamento lcto = new Lancamento();
                lcto.setId(rs.getInt("id"));
                lcto.setNome(rs.getString("nome"));
                lcto.setData(rs.getString("data"));
                lcto.setValor(rs.getDouble("valor"));
                lcto.setIdTipoLancamento(rs.getInt("idtipolancamento"));
                lcto.setTipoLancamento(rs.getString("tipolancamento"));

                ret.add(lcto);
            }
            return ret;
        } catch (SQLException e) {
            throw e;
        } finally {
            connection.finalizarConexao(conn, stmt, rs);
        }
    }

    public void deletarDados(Lancamento lancamento) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        List<Lancamento> ret = new ArrayList<>();
        try {
            //<editor-fold defaultstate="collapsed" desc="Conexao">
            conn = connection.conectarHsqldb();
            stmt = conn.createStatement();
            //</editor-fold>

            StringBuilder sql = new StringBuilder();
            sql.append("\n DELETE FROM lancamento ");
            sql.append("\n WHERE  id = ").append(lancamento.getId());

            stmt.execute(sql.toString());
            stmt.execute("commit");

        } catch (SQLException e) {
            throw e;
        } finally {
            connection.finalizarConexao(conn, stmt, null);
        }
    }

    public String alterarDados(Lancamento dados) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        try {
            //<editor-fold defaultstate="collapsed" desc="Conexao">
            conn = connection.conectarHsqldb();
            stmt = conn.createStatement();
            //</editor-fold>

            StringBuilder sql = new StringBuilder();
            sql.append("\n UPDATE lancamento SET ");
            sql.append("\n nome = '").append(dados.getNome()).append("',");
            sql.append("\n data = '").append(dados.getData()).append("',");
            sql.append("\n valor = ").append(dados.getValor()).append(",");
            sql.append("\n idtipolancamento = ").append(dados.getIdTipoLancamento());
            sql.append("\n WHERE id = ").append(dados.getId());

            stmt.execute(sql.toString());
            stmt.execute("commit");

            return "Dados de lancamento de contas alterado com sucesso!";
        } catch (SQLException e) {
            throw e;
        } finally {
            connection.finalizarConexao(conn, stmt, null);
        }
    }

    public Lancamento retornaObjeto() throws Exception {
        Lancamento ret = new Lancamento();
        ret.setNome("Ricardo");
        ret.setData("10/11/2017");
        ret.setValor(134.56);
        ret.setTipoLancamento("1");
        return ret;
    }

    public String getConexao() {
        Connection con = null;
        String conexao = "";
        try {
            con = connection.conectarHsqldb();

            if (con == null) {
                return "Sem conexao";
            } else {
                return "Conectado!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }
}
