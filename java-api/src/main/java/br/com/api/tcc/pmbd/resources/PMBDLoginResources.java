/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.api.tcc.pmbd.resources;

import br.com.api.tcc.pmbd.entity.security.Login;
import br.com.api.tcc.pmbd.exception.APIException;
import br.com.api.tcc.pmbd.response.Message;
import br.com.api.tcc.pmbd.response.ResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.ObserverException;
import javax.servlet.annotation.WebFilter;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("security")
@RequestScoped
@Api("Endpoints segurança (logins) etc.")
@WebFilter(asyncSupported = true)
public class PMBDLoginResources {

    private Logger log = LogManager.getLogger();

    @ApiOperation(
            value = "Login",
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    @ApiResponses(
            @ApiResponse(message = "",
                    code = 201,
                    response = ResponseModel.class))
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Login login) {
        ResponseModel responseModel = new ResponseModel();

        try {
            if("tcc".equals(login.getEmail()) && "tcc123".equals(login.getSenha())){
                responseModel.getData().add("Bem vindo usuario!");
                responseModel.getMessages().add(new Message(200, "OK!")); 
            }else{
               return Response.ok(responseModel).status(Status.FORBIDDEN).build();
            }
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
        return Response.ok(responseModel).status(Response.Status.OK).build();
    }   
}
