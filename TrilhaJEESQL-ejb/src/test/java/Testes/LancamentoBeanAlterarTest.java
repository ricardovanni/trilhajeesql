package Testes;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;
import br.com.logic.trilhajeesql.Model.Lancamento;
import br.com.logic.trilhajeesql.Model.TipoLancamentoEnum;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Rick-PC
 */
@RunWith(Arquillian.class)
public class LancamentoBeanAlterarTest extends AbstractStartTest {

    @Inject
    private LancamentoLocal lancamentoBean;
    @Inject
    private ConexaoDAO conexao;

    @Test
    public void testAlterarLancamentoSucesso() throws Exception {

        Lancamento lcto = new Lancamento();
        lcto.setNome("Gabriel Alexandre");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        List<Lancamento> ret = lancamentoBean.consultarLancamentoPorNome("Gabriel Alexandre");

        Lancamento lctoAlt = new Lancamento();
        lctoAlt.setId(ret.get(0).getId());
        lctoAlt.setNome("Gabriel Alexandre Vanni");
        lctoAlt.setData("23/11/2017");
        lctoAlt.setValor(645.37);
        lctoAlt.setTipoLancamento("Debito");

        retorno = lancamentoBean.alterarLancamento(lctoAlt);
        Assert.assertEquals("Dados de lancamento de contas alterado com sucesso!", retorno);

        ret = lancamentoBean.consultarLancamento();
        Assert.assertEquals(1, ret.size());
        Assert.assertEquals(lctoAlt.getId(), ret.get(0).getId());
        Assert.assertEquals(lctoAlt.getNome(), ret.get(0).getNome());
        Assert.assertEquals(lctoAlt.getData(), ret.get(0).getData());
        Assert.assertEquals(lctoAlt.getValor(), ret.get(0).getValor(), 0.0001);
        Assert.assertEquals(lctoAlt.getTipoLancamento().toUpperCase(), ret.get(0).getTipoLancamento());
    }

    @Test
    public void testAlterarLancamentoErroNome() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setId(1);
        lcto.setNome("Gabriel Alexandre");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lctoAlt = new Lancamento();
        lctoAlt.setId(1);
        lctoAlt.setNome("GAB2el Alexandre Vanni");
        lctoAlt.setData("23/11/2017");
        lctoAlt.setValor(645.37);
        lctoAlt.setTipoLancamento("Debito");

        String msgErro = "";
        try {
            retorno = lancamentoBean.alterarLancamento(lctoAlt);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Nome Invalido!", msgErro);
    }

    @Test
    public void testAlterarLancamentoErroData() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setId(1);
        lcto.setNome("Gabriel Alexandre");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lctoAlt = new Lancamento();
        lctoAlt.setId(1);
        lctoAlt.setNome("Gabriel Alexandre Vanni");
        lctoAlt.setData("45/11/2017");
        lctoAlt.setValor(645.37);
        lctoAlt.setTipoLancamento("Debito");

        String msgErro = "";
        try {
            retorno = lancamentoBean.alterarLancamento(lctoAlt);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Data Invalida!", msgErro);
    }

    @Test
    public void testAlterarLancamentoErroValor() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setId(1);
        lcto.setNome("Gabriel Alexandre");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lctoAlt = new Lancamento();
        lctoAlt.setId(1);
        lctoAlt.setNome("Gabriel Alexandre Vanni");
        lctoAlt.setData("25/11/2017");
        lctoAlt.setValor(645.237);
        lctoAlt.setTipoLancamento("Debito");

        String msgErro = "";
        try {
            retorno = lancamentoBean.alterarLancamento(lctoAlt);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Valor Invalido!", msgErro);
    }

    @Test
    public void testAlterarLancamentoErroTipo() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setId(1);
        lcto.setNome("Gabriel Alexandre");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lctoAlt = new Lancamento();
        lctoAlt.setId(1);
        lctoAlt.setNome("Gabriel Alexandre Vanni");
        lctoAlt.setData("25/11/2017");
        lctoAlt.setValor(645.27);
        lctoAlt.setTipoLancamento("FElito");

        String msgErro = "";
        try {
            retorno = lancamentoBean.alterarLancamento(lctoAlt);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Tipo de Lancamento Invalido!", msgErro);
    }

    @Test
    public void testAlterarLancamentoIdInvalido() throws Exception {

        Lancamento lcto = new Lancamento();
        lcto.setId(1);
        lcto.setNome("Gabriel Alexandre");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lctoAlt = new Lancamento();
        lctoAlt.setId(100);
        lctoAlt.setNome("Gabriel Alexandre Vanni");
        lctoAlt.setData("23/11/2017");
        lctoAlt.setValor(645.37);
        lctoAlt.setTipoLancamento("Debito");

        String msgErro = "";
        try {
            retorno = lancamentoBean.alterarLancamento(lctoAlt);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("O Id de numero '" + lctoAlt.getId() + "' informado nao consta no registro de dados de lancamentos", msgErro);
    }
}
