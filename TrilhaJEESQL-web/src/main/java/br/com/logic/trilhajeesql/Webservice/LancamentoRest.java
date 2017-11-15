/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilhajeesql.Webservice;

import br.com.logic.trilhajeesql.DAO.ConexaoDAO;
import br.com.logic.trilhajeesql.Model.Lancamento;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import br.com.logic.trilhajeesql.EJB.Interface.LancamentoLocal;
import java.sql.Connection;
import javax.ws.rs.POST;

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
    private LancamentoLocal lancamentoBean;

    /**
     * Creates a new instance of LancamentoRest
     */
    public LancamentoRest() {
    }

    /**
     * Retrieves representation of an instance of
     * br.com.logic.trilhajeesql.Webservice.LancamentoRest
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("objeto")
    public Lancamento getJson() throws Exception {
        //TODO return proper representation object
        return lancamentoBean.retornaObjeto();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insert")
    public String insert() throws Exception {
        //TODO return proper representation object
        ConexaoDAO con = new ConexaoDAO();
        Connection conn = con.conectarHsqldb();

        if (conn == null) {
            return "Conexao vazia";
        } else {
            return "Conectado";
        }
    }

}
