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

    List<Lancamento> consultarLancamentoPorNome(String nome) throws Exception;

    List<Lancamento> consultarLancamentoPorTipo(String tipo) throws Exception;

    String deletarLancamento(Integer idLancamento) throws Exception;

    String alterarLancamento(Lancamento dados) throws Exception;

    Lancamento retornaObjeto() throws Exception;
}
