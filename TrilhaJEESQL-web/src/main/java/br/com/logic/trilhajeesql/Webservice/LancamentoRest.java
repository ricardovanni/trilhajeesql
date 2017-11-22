package br.com.logic.trilhajeesql.Webservice;

import br.com.logic.trilhajeesql.Model.Lancamento;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author Ricardo Vanni
 */
@Path("lancamento")
@RequestScoped
public class LancamentoRest {

    @Context
    private UriInfo context;
    @EJB
    private LancamentoLocal lancamentoBean;

    /**
     * Este Metodo Insere dados de lancamentos na base de dados
     *
     * @param lancamento Parametro de entrada de dados
     * @return Retorna mensagem de sucesso na insercao de dados
     * @throws Exception
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("inserir")
    public String inserirLancamento(Lancamento lancamento) throws Exception {
        return lancamentoBean.inserirLancamento(lancamento);
    }

    /**
     * Este Metodo retorna a consulta de todos os lancamentos cadastrados na
     * base de dados
     *
     * @return Retorna uma lista de lancamentos
     * @throws Exception
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultar")
    public List<Lancamento> consultarLancamentos() throws Exception {
        return lancamentoBean.consultarLancamento();
    }

    /**
     * Este metodo retorna a consulta de todos os lancamentos com filtro para a
     * data informada no parametro.
     *
     * @param data Parametro que define a data do lancamento
     * @return Retorna uma lista de lancamentos filtrados por data
     * @throws Exception
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarPorData")
    public List<Lancamento> consultarLancamentosPorData(@QueryParam("data") String data) throws Exception {
        return lancamentoBean.consultarLancamentoPorData(data);
    }

    /**
     * Este metodo retorna a consulta de todos os lancamentos com filtro para o
     * nome informado no parametro.
     *
     * @param nome Parametro que define a data do lancamento
     * @return Retorna uma lista de lancamentos filtrados por nome
     * @throws Exception
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarPorNome")
    public List<Lancamento> consultarLancamentosPorNome(@QueryParam("nome") String nome) throws Exception {
        return lancamentoBean.consultarLancamentoPorNome(nome);
    }

    /**
     * Este metodo retorna a consulta de todos os lancamentos com filtro para o
     * tipo de lancamento informado no parametro.
     *
     * @param tipo Parametro que define a data do lancamento
     * @return Retorna uma lista de lancamentos filtrados por tipo
     * @throws Exception
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultarPorTipo")
    public List<Lancamento> consultarLancamentosPorTipo(@QueryParam("tipo") String tipo) throws Exception {
        return lancamentoBean.consultarLancamentoPorTipo(tipo);
    }

}
