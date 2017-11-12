package br.com.logic.trilhajeesql.EJB.Interface;

import br.com.logic.trilhajeesql.Model.Lancamento;
import javax.ejb.Local;

/**
 *
 * @author Ricardo Vanni
 */
@Local
public interface AcessoBanco {
    
    void insereDados(Lancamento dados) throws Exception;
    
    Lancamento retornaObjeto() throws Exception;
}
