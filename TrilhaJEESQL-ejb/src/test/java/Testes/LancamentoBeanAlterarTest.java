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
 * @author Ricardo Vanni
 */
@RunWith(Arquillian.class)
public class LancamentoBeanAlterarTest extends AbstractStartTest {

    @Inject
    private LancamentoLocal lancamentoBean;
    @Inject
    private ConexaoDAO conexao;

    @Test
    public void testConsultarLancamentoSemRegistros() throws Exception {
        String msgErro = "";
        try {
            List<Lancamento> listaLancamentos = lancamentoBean.consultarLancamento();

        } catch (Exception e) {
            msgErro = e.getMessage();
        }

        Assert.assertEquals("Nao existem dados de lancamentos registrados.", msgErro);
    }

    @Test
    public void testConsultarLancamentoPorData() throws Exception {
        String data = "10/10/2017";

        Lancamento lcto = new Lancamento();
        lcto.setNome("Maria");
        lcto.setData("10/10/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lcto2 = new Lancamento();
        lcto2.setNome("Jose");
        lcto2.setData("16/11/2017");
        lcto2.setValor(965.65);
        lcto2.setTipoLancamento(TipoLancamentoEnum.DEBITO.getTipo());

        retorno = lancamentoBean.inserirLancamento(lcto2);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        List<Lancamento> listaLancamentos = lancamentoBean.consultarLancamentoPorData(data);

        Assert.assertEquals(1, listaLancamentos.size());
        Assert.assertEquals(lcto.getNome(), listaLancamentos.get(0).getNome());
        Assert.assertEquals(lcto.getData(), listaLancamentos.get(0).getData());
        Assert.assertEquals(lcto.getValor(), listaLancamentos.get(0).getValor());
        Assert.assertEquals(lcto.getTipoLancamento(), listaLancamentos.get(0).getTipoLancamento());
    }

    @Test
    public void testConsultarLancamentoPorDataInvalida() throws Exception {
        String data = "10/25/2017";

        String msgErro = "";
        try {
            List<Lancamento> listaLancamentos = lancamentoBean.consultarLancamentoPorData(data);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }
        Assert.assertEquals("Data Invalida!", msgErro);
    }

    @Test
    public void testConsultarLancamentoPorNome() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setNome("Kauã Jessé dos Santos");
        lcto.setData("10/10/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lcto2 = new Lancamento();
        lcto2.setNome("Jose");
        lcto2.setData("16/11/2017");
        lcto2.setValor(965.65);
        lcto2.setTipoLancamento(TipoLancamentoEnum.DEBITO.getTipo());

        retorno = lancamentoBean.inserirLancamento(lcto2);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        String nome = "Kauã";
        List<Lancamento> listaLancamentos = lancamentoBean.consultarLancamentoPorNome(nome);

        Assert.assertEquals(1, listaLancamentos.size());
        Assert.assertEquals(lcto.getNome(), listaLancamentos.get(0).getNome());
        Assert.assertEquals(lcto.getData(), listaLancamentos.get(0).getData());
        Assert.assertEquals(lcto.getValor(), listaLancamentos.get(0).getValor());
        Assert.assertEquals(lcto.getTipoLancamento(), listaLancamentos.get(0).getTipoLancamento());
    }

    @Test
    public void testConsultarLancamentoPorNomeSemRegistro() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setNome("Kauã Jessé dos Santos");
        lcto.setData("10/10/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lcto2 = new Lancamento();
        lcto2.setNome("Jose");
        lcto2.setData("16/11/2017");
        lcto2.setValor(965.65);
        lcto2.setTipoLancamento(TipoLancamentoEnum.DEBITO.getTipo());

        retorno = lancamentoBean.inserirLancamento(lcto2);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        String nome = "Emirval";

        List<Lancamento> listaLancamentos = lancamentoBean.consultarLancamentoPorNome(nome);

        Assert.assertTrue(listaLancamentos.isEmpty());
    }

    @Test
    public void testConsultarLancamentoPorTipoLancamento() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setNome("Kauã Jessé dos Santos");
        lcto.setData("10/10/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        Lancamento lcto2 = new Lancamento();
        lcto2.setNome("Jose");
        lcto2.setData("16/11/2017");
        lcto2.setValor(965.65);
        lcto2.setTipoLancamento(TipoLancamentoEnum.DEBITO.getTipo());

        retorno = lancamentoBean.inserirLancamento(lcto2);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        List<Lancamento> listaLancamentos = lancamentoBean.consultarLancamentoPorTipo("DéBiTo");

        Assert.assertEquals(1, listaLancamentos.size());
        Assert.assertEquals(lcto2.getNome(), listaLancamentos.get(0).getNome());
        Assert.assertEquals(lcto2.getData(), listaLancamentos.get(0).getData());
        Assert.assertEquals(lcto2.getValor(), listaLancamentos.get(0).getValor());
        Assert.assertEquals(lcto2.getTipoLancamento(), listaLancamentos.get(0).getTipoLancamento());

        listaLancamentos = lancamentoBean.consultarLancamentoPorTipo("1");

        Assert.assertEquals(1, listaLancamentos.size());
        Assert.assertEquals(lcto.getNome(), listaLancamentos.get(0).getNome());
        Assert.assertEquals(lcto.getData(), listaLancamentos.get(0).getData());
        Assert.assertEquals(lcto.getValor(), listaLancamentos.get(0).getValor());
        Assert.assertEquals(lcto.getTipoLancamento(), listaLancamentos.get(0).getTipoLancamento());
    }

    @Test
    public void testConsultarLancamentoPorTipoLancamentoInvalido() throws Exception {
        String tipo = "Crreditoo";

        String msgErro = "";
        try {
            List<Lancamento> listaLancamentos = lancamentoBean.consultarLancamentoPorTipo(tipo);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }
        Assert.assertEquals("Tipo de Lancamento Invalido!", msgErro);

        tipo = "3";
        msgErro = "";
        try {
            List<Lancamento> listaLancamentos = lancamentoBean.consultarLancamentoPorTipo(tipo);
        } catch (Exception e) {
            msgErro = e.getMessage();
        }
        Assert.assertEquals("Tipo de Lancamento Invalido!", msgErro);
    }
}
