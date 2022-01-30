/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.api.tcc.pmbd.resources;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import java.util.Set;
import javax.servlet.annotation.WebFilter;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author lucas
 */
@ApplicationPath("v1")
@WebFilter(asyncSupported = true)
public class AplicationConfig extends Application {

    private final Logger log = LogManager.getLogger();


    public AplicationConfig() {
        try {
            BeanConfig conf = new BeanConfig();
            conf.setTitle("API - PMBD (Prefeitura Municipal de Bom Destino)");
            conf.setDescription("TCC Arquitetura de sistemas distribuidos...");
            conf.setBasePath("pmbd/api/v1"); 
            conf.setSchemes(new String[]{"http"});
            conf.setResourcePackage("br.com.api.tcc.pmbd.resources");
            conf.setScan(true);
            
        } catch (Exception e) {
            log.error("Erro ao iniciar swagger....", e);
        }

    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        try {
            Class jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature");
            resources.add(jsonProvider);

        } catch (ClassNotFoundException ex) {
            log.trace("Erro ao adicionar o provider do Json", ex);
        }
        //classes do swagger...
        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.api.tcc.pmbd.resources.CORSFilter.class);
        resources.add(br.com.api.tcc.pmbd.resources.PMBDImoveisResources.class);
        resources.add(br.com.api.tcc.pmbd.resources.PMBDLoginResources.class);
        resources.add(br.com.api.tcc.pmbd.resources.PMBDResources.class);
        resources.add(io.swagger.jaxrs.listing.AcceptHeaderApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
    }
}
