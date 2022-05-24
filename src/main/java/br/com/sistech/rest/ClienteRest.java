package br.com.sistech.rest;

import br.com.sistech.dto.ClienteDto;
import br.com.sistech.service.ClienteSevice;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.hibernate.exception.ConstraintViolationException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRest {
    @Inject
    ClienteSevice service;

    @GET
    @Operation(summary = "Listar Clientes", description = "Lista Clientes")
    @APIResponse(responseCode = "201", description = "Clientes", content = {
        @Content(mediaType =  "application/json",
            schema = @Schema(implementation = ClienteDto.class))
        }
    )
    public Response listar(){
        return Response.status(Response.Status.OK).header("Mensagem", "Listagem Realizada com Sucesso!").entity(service.listarClientes()).build();
    }

    @POST
    @Path("/incluir")
    @Operation(summary = "Incluir", description = "Incluir")
    @APIResponse(responseCode = "200", description = "Clientes", content = {
        @Content(mediaType =  "application/json",
            schema = @Schema(implementation = ClienteDto.class))
        }
    )
    public Response incluir(ClienteDto clienteDto){
        service.incluirCliente(clienteDto);
        return Response.status(Response.Status.CREATED).build();
    }
}




