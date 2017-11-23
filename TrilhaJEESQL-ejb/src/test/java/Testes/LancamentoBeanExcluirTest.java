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
public class LancamentoBeanExcluirTest extends AbstractStartTest {

    @Inject
    private LancamentoLocal lancamentoBean;
    @Inject
    private ConexaoDAO conexao;

    @Test
    public void testExcluirLancamentoSucesso() throws Exception {
        Lancamento lcto = new Lancamento();
        lcto.setNome("Gabriel Alexandre");
        lcto.setData("16/11/2017");
        lcto.setValor(568.65);
        lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

        String retorno = lancamentoBean.inserirLancamento(lcto);
        Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

        List<Lancamento> ret = lancamentoBean.consultarLancamentoPorNome("Gabriel Alexandre");
        Integer idLancamento = ret.get(0).getId();

        retorno = lancamentoBean.deletarLancamento(idLancamento);
        Assert.assertEquals("Dados de Lancamento de contas excluidos com sucesso!", retorno);

        String msgErro = "";
        try {
            ret = lancamentoBean.consultarLancamento();
        } catch(Exception e) {
            msgErro = e.getMessage();
        }
        Assert.assertEquals("Nao existem dados de lancamentos registrados.", msgErro);
    }

    @Test
    public void testExcluirLancamentoIdInvalido() throws Exception {
      Lancamento lcto = new Lancamento();
      lcto.setNome("Gabriel Alexandre");
      lcto.setData("16/11/2017");
      lcto.setValor(568.65);
      lcto.setTipoLancamento(TipoLancamentoEnum.CREDITO.getTipo());

      String retorno = lancamentoBean.inserirLancamento(lcto);
      Assert.assertEquals("Dados Inseridos com sucesso!", retorno);

      List<Lancamento> ret = lancamentoBean.consultarLancamentoPorNome("Gabriel Alexandre");
      Integer idLancamento = ret.get(0).getId() + 100;

      String msgErro = "";
      try {
            retorno = lancamentoBean.deletarLancamento(idLancamento);
      } catch(Exception e) {
          msgErro = e.getMessage();
      }
          Assert.assertEquals("O Id de numero '" + idLancamento + "' informado nao consta no registro de dados de lancamentos", msgErro);
    }
}
