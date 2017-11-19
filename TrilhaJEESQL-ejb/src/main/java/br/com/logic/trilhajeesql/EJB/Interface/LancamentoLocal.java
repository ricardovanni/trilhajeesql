package br.com.logic.trilhajeesql.EJB.Interface;

import br.com.logic.trilhajeesql.Model.Lancamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo Vanni
 */
@Local
public interface LancamentoLocal {

    String inserirLancamento(Lancamento lancamento) throws Exception;

    List<Lancamento> consultarLancamento() throws Exception;

    List<Lancamento> consultarLancamentoPorData(String data) throws Exception;

    void deletarLancamento(Lancamento lancamento) throws Exception;

    void alterarLancamento(Integer id, Lancamento dados) throws Exception;

    Lancamento retornaObjeto() throws Exception;

    String getConexao() throws Exception;

    String getDado() throws Exception;
}
