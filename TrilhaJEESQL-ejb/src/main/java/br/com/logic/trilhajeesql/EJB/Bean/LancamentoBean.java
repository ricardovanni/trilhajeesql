package br.com.logic.trilhajeesql.EJB.Bean;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import br.com.logic.trilhajeesql.DAO.LancamentoDAO;
import br.com.logic.trilhajeesql.Model.Lancamento;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Ricardo Vanni
 */
@Stateless
@LocalBean
public class LancamentoBean extends ConexaoDAO implements LancamentoLocal {

    @Inject
    private LancamentoDAO lancamentoDAO;

    @Override
    public Lancamento retornaObjeto() throws Exception {
        return lancamentoDAO.retornaObjeto();
    }

    @Override
    public String inserirLancamento(Lancamento lancamento) throws Exception {
        try {
           return lancamentoDAO.inserirDados(lancamento);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Lancamento> consultarDados() throws Exception {
        try {
            return lancamentoDAO.consultarDados();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deletarDados(Lancamento lancamento) throws Exception {
        try {
            lancamentoDAO.deletarDados(lancamento);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void alterarDados(Integer id, Lancamento dados) throws Exception {
        try {
            lancamentoDAO.alterarDados(id, dados);

        } catch (Exception e) {
            throw e;
        }
    }
}
