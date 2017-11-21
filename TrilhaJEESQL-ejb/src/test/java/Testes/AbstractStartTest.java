package Testes;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import br.com.logic.trilhajeesql.DAO.LancamentoDAO;
import br.com.logic.trilhajeesql.EJB.Bean.LancamentoBean;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;
import br.com.logic.trilhajeesql.Model.Lancamento;
import br.com.logic.trilhajeesql.Model.TipoLancamentoEnum;
import br.com.logic.trilhajeesql.UTIL.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author Ricardo Vanni
 */
public abstract class AbstractStartTest {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive ret = ShrinkWrap.create(JavaArchive.class, "trilha.jar");
        ret.addClasses(AbstractStartTest.class, ConexaoDAO.class, Lancamento.class, LancamentoDAO.class, LancamentoLocal.class,
                TipoLancamentoEnum.class, LancamentoBean.class, Util.class);
        ret.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return ret;
    }

    protected static Boolean isBDTest = Boolean.TRUE;

    @Inject
    private ConexaoDAO conexao;

    @Before
    public void consultarSeBaseEstaVazia() throws SQLException, Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = conexao.conectarHsqldb();
            stmt = conn.createStatement();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM lancamento");
            rs = stmt.executeQuery(sql.toString());

            if (rs.next()) {
                isBDTest = Boolean.FALSE;
                throw new Exception("A base de dados utilizada para testes nao esta vazia. Verifique!");
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao consultar se base esta vazia.");
        } finally {
            finalizarConexao(conn, stmt, rs);
        }
    }

    @After
    public void limparBaseDeDados() throws SQLException {
        if (isBDTest) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                conn = conexao.conectarHsqldb();
                stmt = conn.createStatement();
                StringBuilder sql = new StringBuilder();
                sql.append("DELETE FROM lancamento");
                stmt.execute(sql.toString());
                stmt.execute("commit");

            } catch (SQLException e) {
                throw new SQLException("Erro ao limpar a base de dados de testes.");
            } finally {
                finalizarConexao(conn, stmt, null);
            }
        }
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
                Logger.getLogger(AbstractStartTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
