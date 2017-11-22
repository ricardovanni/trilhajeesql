package br.com.logic.trilhajeesql.EJB.Bean;

import br.com.logic.trilhajeesql.DAO.LancamentoDAO;
import br.com.logic.trilhajeesql.Model.Lancamento;
import javax.ejb.Stateless;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;
import br.com.logic.trilhajeesql.UTIL.Util;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Ricardo Vanni
 */
@Stateless
public class LancamentoBean extends Util implements LancamentoLocal {

    @Inject
    private LancamentoDAO lancamentoDAO;

    @Override
    public Lancamento retornaObjeto() throws Exception {
        return lancamentoDAO.retornaObjeto();
    }

    @Override
    public String inserirLancamento(Lancamento lancamento) throws Exception {
        try {
            validarInserirNome(lancamento.getNome());
            validarData(lancamento.getData());
            validarValor(lancamento.getValor().toString());
            lancamento.setIdTipoLancamento(validarTipoLancamento(lancamento.getTipoLancamento()));
            return lancamentoDAO.inserirDados(lancamento);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Lancamento> consultarLancamento() throws Exception {
        try {
            List<Lancamento> ret = lancamentoDAO.consultarDados();

            if (ret.isEmpty()) {
                throw new Exception("Nao existem dados de lancamentos registrados.");
            } else {
                return ret;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Lancamento> consultarLancamentoPorData(String data) throws Exception {
        try {
            validarData(data);
            List<Lancamento> lista = consultarLancamento();
            List<Lancamento> ret = new ArrayList<>();

            for (Lancamento lancamento : lista) {
                if (lancamento.getData().equals(data)) {
                    ret.add(lancamento);
                }
            }
            return ret;
        } catch (ParseException e) {
            throw e;
        }
    }

    @Override
    public List<Lancamento> consultarLancamentoPorNome(String nome) throws Exception {
        List<Lancamento> lista = consultarLancamento();
        List<Lancamento> ret = new ArrayList<>();
        Boolean isValido = Boolean.FALSE;

        for (Lancamento lancamento : lista) {
            isValido = validarConsultarNome(nome, lancamento.getNome());
            if (isValido) {
                ret.add(lancamento);
            }
        }
        return ret;
    }

    @Override
    public List<Lancamento> consultarLancamentoPorTipo(String tipo) throws Exception {
        Integer tipoLancamento = validarTipoLancamento(tipo);

        List<Lancamento> lista = consultarLancamento();
        List<Lancamento> ret = new ArrayList<>();

        for (Lancamento lancamento : lista) {
            if (lancamento.getIdTipoLancamento().equals(tipoLancamento)) {
                ret.add(lancamento);
            }
        }
        return ret;
    }

    @Override
    public void deletarLancamento(Lancamento lancamento) throws Exception {
        try {
            lancamentoDAO.deletarDados(lancamento);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void alterarLancamento(Integer id, Lancamento dados) throws Exception {
        try {
            lancamentoDAO.alterarDados(id, dados);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String getConexao() throws Exception {
        return lancamentoDAO.getConexao();
    }

    @Override
    public Integer getDado(String nome) throws Exception {
        return validarTipoLancamento(nome);
    }

}
