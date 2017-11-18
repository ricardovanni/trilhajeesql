package Testes;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import br.com.logic.trilhajeesql.DAO.LancamentoDAO;
import br.com.logic.trilhajeesql.EJB.Bean.LancamentoBean;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;
import br.com.logic.trilhajeesql.Model.Lancamento;
import br.com.logic.trilhajeesql.Model.TipoLancamentoEnum;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Rick-PC
 */
@RunWith(Arquillian.class)
public class LancamentoBeanTest extends AbstractStartTest {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive ret = ShrinkWrap.create(JavaArchive.class, "trilha.jar");
        ret.addClasses(AbstractStartTest.class, ConexaoDAO.class, Lancamento.class, LancamentoDAO.class, LancamentoLocal.class,
                TipoLancamentoEnum.class, LancamentoBean.class);
        ret.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return ret;
    }

    @Before
    public void verificaBase() throws Exception {
        consultarSeBaseEstaVazia();
    }

    @After
    public void limparBase() throws SQLException {
        limparBaseDeDados();
    }

    @Inject
    private LancamentoLocal lancamentoBean;
    @Inject
    private ConexaoDAO conexao;

    @Test
    public void testConsultarLancamentoSemRegistros() throws Exception {

        String msgErro = "";
        try {
            List<Lancamento> listaLancamentos = lancamentoBean.consultarDados();

        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Nao existem dados de lancamentos registrados.", msgErro);
    }

    @Test
    public void testInserirLancamento() throws Exception {

        Lancamento lcto = new Lancamento();
        lcto.setNome("Gabriel");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(1);

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lcto2 = new Lancamento();
        lcto2.setNome("Rafael");
        lcto2.setData("16/11/2017");
        lcto2.setValor(965.65);
        lcto2.setTipoLancamento(2);

        retorno = lancamentoBean.inserirLancamento(lcto2);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        List<Lancamento> ret = lancamentoBean.consultarDados();
        Assert.assertEquals(2, ret.size());
        Assert.assertEquals(lcto.getNome(), ret.get(0).getNome());
        Assert.assertEquals(lcto.getData(), ret.get(0).getData());
        Assert.assertEquals(lcto.getValor(), ret.get(0).getValor(), 0.0001);
        Assert.assertEquals(lcto.getTipoLancamento(), ret.get(0).getTipoLancamento());
        Assert.assertEquals(lcto2.getNome(), ret.get(1).getNome());
        Assert.assertEquals(lcto2.getData(), ret.get(1).getData());
        Assert.assertEquals(lcto2.getValor(), ret.get(1).getValor(), 0.0001);
        Assert.assertEquals(lcto2.getTipoLancamento(), ret.get(1).getTipoLancamento());
    }

}
