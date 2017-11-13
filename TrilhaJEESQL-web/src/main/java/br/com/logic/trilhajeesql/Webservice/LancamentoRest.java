/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilhajeesql.Webservice;

import br.com.logic.trilhajeesql.Model.Lancamento;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;

/**
 * REST Web Service
 *
 * @author HomeBook
 */
@Path("lancamento")
@RequestScoped
public class LancamentoRest {

    @Context
    private UriInfo context;
    
    @EJB
    private LancamentoLocal lancamento;
    /**
     * Creates a new instance of LancamentoRest
     */
    public LancamentoRest() {
    }

    /**
     * Retrieves representation of an instance of br.com.logic.trilhajeesql.Webservice.LancamentoRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Lancamento getJson() throws Exception {
        //TODO return proper representation object
        return lancamento.retornaObjeto();
    }

    /**
     * PUT method for updating or creating an instance of LancamentoRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
