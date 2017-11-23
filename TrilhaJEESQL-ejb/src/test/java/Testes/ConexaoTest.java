package Testes;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Ricardo Vanni
 */
@RunWith(Arquillian.class)
public class ConexaoTest extends AbstractStartTest {

    @Inject
    ConexaoDAO conexao;

    @Test
    public void testConexaoBD() throws Exception {
        Connection conn;

        try {
            conn = conexao.conectarHsqldb();

            boolean ver = conn != null;

            Assert.assertTrue(ver);

        } catch (SQLException e) {
            throw e;
        }
    }
}
