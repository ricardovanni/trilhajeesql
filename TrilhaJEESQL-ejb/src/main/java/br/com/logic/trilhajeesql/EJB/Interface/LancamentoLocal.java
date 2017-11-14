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
    
    List<Lancamento> consultarDados() throws Exception;
    
    void deletarDados(Lancamento lancamento) throws Exception;
    
    void alterarDados(Integer id, Lancamento dados) throws Exception;
    
    Lancamento retornaObjeto() throws Exception;
}
