/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.api.tcc.pmbd.resources;

import br.com.api.tcc.pmbd.entity.safim.PessoaFisica;
import br.com.api.tcc.pmbd.entity.stur.Imovel;
import br.com.api.tcc.pmbd.exception.APIException;
import br.com.api.tcc.pmbd.response.Message;
import br.com.api.tcc.pmbd.response.ResponseModel;
import br.com.api.tcc.pmbd.service.Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObserverException;
import javax.inject.Inject;
import javax.servlet.annotation.WebFilter;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

@Path("imoveis")
@RequestScoped
@Api("Endpoints de imoveis (STUR) da Prefeitura Bom Destino")
@WebFilter(asyncSupported = true)
public class PMBDImoveisResources {

    @EJB
    private Service service;

    private Logger log = LogManager.getLogger();

    @ApiOperation(
            value = "Cadastrar imovel",
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    @ApiResponses(
            @ApiResponse(message = "",
                    code = 201,
                    response = ResponseModel.class))
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Imovel imovel) {
        ResponseModel responseModel = new ResponseModel();

        try {
            responseModel.getData().add(service.inserirImovel(imovel));
            responseModel.getMessages().add(new Message(200, "OK!"));

        } catch (ObserverException ex) {
            if (ex.getCause() instanceof APIException) {
                APIException exc = (APIException) ex.getCause();
                responseModel.getMessages().add(new Message(exc.getCodigo(), exc.getDescricao()));
            }
            return Response.status(Response.Status.OK).entity(responseModel).build();
        } catch (Exception ex) {
            log.error(ex, ex);
            responseModel.getMessages().add(new Message(500, Response.Status.INTERNAL_SERVER_ERROR.toString()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseModel).build();
        }
        return Response.ok(responseModel).status(Response.Status.CREATED).build();
    }

    @ApiOperation(
            value = "Atualizar imovel",
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    @ApiResponses(
            @ApiResponse(message = "",
                    code = 200,
                    response = ResponseModel.class))
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(Imovel imovel) {
        ResponseModel responseModel = new ResponseModel();

        try {
            responseModel.getData().add(service.atualizarImovel(imovel));
            responseModel.getMessages().add(new Message(200, "OK!"));
        } catch (ObserverException ex) {
            if (ex.getCause() instanceof APIException) {
                APIException exc = (APIException) ex.getCause();
                responseModel.getMessages().add(new Message(exc.getCodigo(), exc.getDescricao()));
            }
            return Response.status(Response.Status.OK).entity(responseModel).build();
        } catch (Exception ex) {
            log.error(ex, ex);
            responseModel.getMessages().add(new Message(500, Response.Status.INTERNAL_SERVER_ERROR.toString()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseModel).build();
        }
        return Response.ok(responseModel).build();
    }

    @ApiOperation(value = "Buscar Imovel por ID", produces = MediaType.APPLICATION_JSON)
    @ApiResponses(
            @ApiResponse(message = "",
                    code = 200,
                    response = ResponseModel.class
            ))
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorImovelPorID(
            @ApiParam(
                    value = "ID (identificador) do Imovel",
                    name = "id",
                    required = true) @PathParam("id") @Required long id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            Imovel imovel = service.buscarImovelPorId(id);
            if (imovel == null) {
                return Response.status(Response.Status.NOT_FOUND).entity(responseModel).build();
            }
            responseModel.getData().add(imovel);
            responseModel.getMessages().add(new Message(200, "OK!"));
        } catch (Exception ex) {
            log.error(ex, ex);
            responseModel.getMessages().add(new Message(500, Response.Status.INTERNAL_SERVER_ERROR.toString()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseModel).build();
        }
        return Response.ok(responseModel).build();
    }

        @ApiOperation(value = "Buscar Imovel por bairro", produces = MediaType.APPLICATION_JSON)
    @ApiResponses(
            @ApiResponse(message = "",
                    code = 200,
                    response = ResponseModel.class
            ))
    @GET
    @Path("bairro/{bairro}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorBairro(
            @ApiParam(
                    value = "Bairro do Imovel",
                    name = "id",
                    required = true) @PathParam("bairro") @Required String bairro) {
        ResponseModel responseModel = new ResponseModel();
        try {
            Imovel imovel = service.buscarPorBairro(bairro);
            if (imovel == null) {
                return Response.status(Response.Status.NOT_FOUND).entity(responseModel).build();
            }
            responseModel.getData().add(imovel);
            responseModel.getMessages().add(new Message(200, "OK!"));
        } catch (Exception ex) {
            log.error(ex, ex);
            responseModel.getMessages().add(new Message(500, Response.Status.INTERNAL_SERVER_ERROR.toString()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseModel).build();
        }
        return Response.ok(responseModel).build();
    }

   
}
