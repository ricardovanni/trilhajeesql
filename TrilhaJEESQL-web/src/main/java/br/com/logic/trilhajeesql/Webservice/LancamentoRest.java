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
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

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
     * @return Retorna mensagem de sucesso ou erro na insercao de dados
     * @throws Exception
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("inserir")
    public Response inserirLancamento(Lancamento lancamento) throws Exception {
        try {
            return Response.ok(lancamentoBean.inserirLancamento(lancamento)).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(HttpServletResponse.SC_BAD_REQUEST).build();
        }
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
    public Response consultarLancamentos() throws Exception {
        try {
            return Response.ok(lancamentoBean.consultarLancamento()).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(HttpServletResponse.SC_BAD_REQUEST).build();
        }
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
    public Response consultarLancamentosPorData(@QueryParam("data") String data) throws Exception {
        try {
            return Response.ok(lancamentoBean.consultarLancamentoPorData(data)).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(HttpServletResponse.SC_BAD_REQUEST).build();
        }
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
    public Response consultarLancamentosPorNome(@QueryParam("nome") String nome) throws Exception {
        try {
            return Response.ok(lancamentoBean.consultarLancamentoPorNome(nome)).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(HttpServletResponse.SC_BAD_REQUEST).build();
        }
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
    public Response consultarLancamentosPorTipo(@QueryParam("tipo") String tipo) throws Exception {
        try {
            return Response.ok(lancamentoBean.consultarLancamentoPorTipo(tipo)).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(HttpServletResponse.SC_BAD_REQUEST).build();
        }
    }

    /**
     * Este Metodo Altera dados de lancamentos na base de dados
     *
     * @param lancamento Parametro de entrada de dados
     * @return Retorna mensagem de sucesso ou erro na alteracao de dados
     * @throws Exception
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("alterar")
    public Response AlterarLancamento(Lancamento lancamento) throws Exception {
        try {
            return Response.ok(lancamentoBean.alterarLancamento(lancamento)).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(HttpServletResponse.SC_BAD_REQUEST).build();
        }
    }
}
