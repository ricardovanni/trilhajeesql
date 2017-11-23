package br.com.logic.trilhajeesql.Webservice;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Ricardo Vanni
 */
@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Nao modifique o metodo addRestResourceClasses() Ele eh preenchido
     * automaticamente com todos os recursos definidos no projeto. Se
     * necessario, comente no metodo getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
    }

}
