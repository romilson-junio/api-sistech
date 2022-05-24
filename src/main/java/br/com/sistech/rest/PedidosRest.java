package br.com.sistech.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.sistech.dto.request.PedidoRequest;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.sistech.dto.PedidoDto;
import br.com.sistech.service.PedidoService;


/**
 * @author Romilson Júnio Abreu Pereira
 * @version 0.1.0
 * @created 27/11/2020 on 18:37
 */
@Path("pedidos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidosRest {

    @Inject
    PedidoService service;
	
	
    @GET
    @Operation(summary = "Listar Pedidos",
            description = "Lista pedidos")
    @APIResponse(responseCode = "201",
            description = "Pedido",
    		content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = PedidoDto.class))
            }
    )
    public Response listar(){
		return Response
                .status(Response.Status.OK).entity(service.listarPedidos()).build();
    }
    
    @POST
    @Path("/incluir")
    @Operation(summary = "Incluir Pedido",
            description = "Incluir pedido")
    @APIResponse(responseCode = "201",
            description = "Pedido",
    		content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = PedidoRequest.class))
            }
    )
    public Response incluir(PedidoRequest pedido){
    	try {
    		service.incluirPedido(pedido);
    		return Response
                    .status(Response.Status.CREATED).header("Mensagem", "Listagem Realizada com Sucesso!").build();
		} catch (Exception e) {
			return Response
	                .status(Response.Status.BAD_REQUEST).entity("NÃO FOI POSSÍVEL REALIZAR ESTA OPERAÇÃO!").build();
		}
    }
    
}
