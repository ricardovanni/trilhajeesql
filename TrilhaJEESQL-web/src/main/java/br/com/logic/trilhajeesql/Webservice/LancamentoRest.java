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
     * Este Metodo retorna a consulta de todos os lancamentos cadastrados na
     * base de dados
     *
     * @return Retorna uma lista de lancamentos
     * @throws Exception
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("consultar")
    public List<Lancamento> consultarDados() throws Exception {
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

}
