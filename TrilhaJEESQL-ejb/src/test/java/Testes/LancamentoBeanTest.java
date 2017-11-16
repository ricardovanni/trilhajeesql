package Testes;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import br.com.logic.trilhajeesql.DAO.LancamentoDAO;
import br.com.logic.trilhajeesql.EJB.Bean.LancamentoBean;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;
import br.com.logic.trilhajeesql.Model.Lancamento;
import br.com.logic.trilhajeesql.Model.TipoLancamentoEnum;
import java.util.List;
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
 * @author Rick-PC
 */
@RunWith(Arquillian.class)
public class LancamentoBeanTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "trilha.jar")
                .addClasses(ConexaoDAO.class, Lancamento.class, LancamentoDAO.class, LancamentoLocal.class,
                        TipoLancamentoEnum.class, LancamentoBean.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private LancamentoLocal lancamentoBean;

//    @Test
    public void testConsultarTodosDadosLancamento() throws Exception {

        List<Lancamento> listaLancamentos = lancamentoBean.consultarDados();

        Assert.assertNotNull(listaLancamentos);
    }

    @Test
    public void testInserirLancamento() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setNome("Antonio");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(1);

        String retorno = lancamentoBean.inserirLancamento(lcto);

    }

}
