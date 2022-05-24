package br.com.sistech.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.sistech.dto.PedidoDto;
import br.com.sistech.dto.ProdutoDto;
import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.model.Pedido;
import br.com.sistech.model.Produto;
import br.com.sistech.service.PedidoService;
import br.com.sistech.service.ProdutoService;
import br.com.sistech.service.UsuarioSevice;


/**
 * @author Romilson Júnio Abreu Pereira
 * @version 0.1.0
 * @created 27/11/2020 on 18:37
 */
@Path("produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoRest {

    @Inject
    ProdutoService service;
	
	
    @GET
    @Operation(summary = "Listar Produtos",
            description = "Lista Produtos")
    @APIResponse(responseCode = "201",
            description = "Produtos",
    		content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ProdutoDto.class))
            }
    )
    public Response listar(){
		return Response
                .status(Response.Status.OK)
                .entity(service.listarPedidos())
                .build();
    	
    }

    @GET
    @Path("/{produto}")
    @Operation(summary = "Consultar Produto",
            description = "Consultar Produto")
    @APIResponse(responseCode = "201",
            description = "Produtos",
            content = {
                    @Content(mediaType =  "application/json")
            }
    )
    public Response consultarProduto(@PathParam("produto") String produto){
        return Response
                .status(Response.Status.OK)
                .entity(service.consultarProduto(produto))
                .build();

    }


    @POST
    @Path("/incluir")
    @Operation(summary = "Incluir Produto",
            description = "Incluir Produto")
    @APIResponse(responseCode = "201",
            description = "Produto",
    		content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ProdutoDto.class))
            }
    )
    public Response incluir(ProdutoDto produto){
    	
    	
    	ProdutoDto produtoIncluido;
    	
    	try {
    		produtoIncluido = service.incluirProduto(produto);
    		return Response
                    .status(Response.Status.CREATED)
                    .header("Mensagem", "Listagem Realizada com Sucesso!")
                    .build();
    		
		} catch (IndexOutOfBoundsException e) {
			return Response
	                .status(Response.Status.BAD_REQUEST)
	                .entity("NÃO FOI POSSÍVEL REALIZAR ESTA OPERAÇÃO!")
	                .build();
		}
    	
		
    	
    }
    
}
