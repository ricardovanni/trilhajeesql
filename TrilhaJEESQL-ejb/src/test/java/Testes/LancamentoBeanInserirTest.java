package Testes;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;
import br.com.logic.trilhajeesql.Model.Lancamento;
import br.com.logic.trilhajeesql.Model.TipoLancamentoEnum;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Rick-PC
 */
@RunWith(Arquillian.class)
public class LancamentoBeanInserirTest extends AbstractStartTest {

    @Inject
    private LancamentoLocal lancamentoBean;
    @Inject
    private ConexaoDAO conexao;

    @Test
    public void testInserirLancamentoSucesso() throws Exception {

        Lancamento lcto = new Lancamento();
        lcto.setNome("Gabriel Alexandre");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lcto2 = new Lancamento();
        lcto2.setNome("Rafael Alavés");
        lcto2.setData("16/11/2017");
        lcto2.setValor(965.65);
        lcto2.setTipoLancamento(TipoLancamentoEnum.DEBITO.getTipo());

        retorno = lancamentoBean.inserirLancamento(lcto2);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        List<Lancamento> ret = lancamentoBean.consultarLancamento();
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

    @Test
    public void testInserirLancamentoErroNome() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setNome("RIcArDO Vanni");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.DEBITO.getTipo());

        String msgErro = "";
        try {
            String retorno = lancamentoBean.inserirLancamento(lcto);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Nome Invalido!", msgErro);
    }

    @Test
    public void testInserirLancamentoErroData() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setNome("Ricardo Vanni");
        lcto.setData("11/25/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.DEBITO.getTipo());

        String msgErro = "";
        try {
            String retorno = lancamentoBean.inserirLancamento(lcto);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Data Invalida!", msgErro);
    }

    @Test
    public void testInserirLancamentoErroValor() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setNome("Ricardo Vanni");
        lcto.setData("11/10/2017");
        lcto.setValor(568.645);
        lcto.setTipoLancamento(TipoLancamentoEnum.DEBITO.getTipo());

        String msgErro = "";
        try {
            String retorno = lancamentoBean.inserirLancamento(lcto);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Valor Invalido!", msgErro);
    }

    @Test
    public void testInserirLancamentoErroTipo() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setNome("Ricardo Vanni");
        lcto.setData("11/12/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento("5");

        String msgErro = "";
        try {
            String retorno = lancamentoBean.inserirLancamento(lcto);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Tipo de Lancamento Invalido!", msgErro);
    }
}
