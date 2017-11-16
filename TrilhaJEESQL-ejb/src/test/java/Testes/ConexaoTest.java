package Testes;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Ricardo Vanni
 */
@RunWith(Arquillian.class)
public class ConexaoTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "trilha.jar")
                .addClass(ConexaoDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

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
