package br.com.sistech.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.service.UsuarioSevice;


	@Path("usuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public class UsuarioRest {
	    @Inject
	    UsuarioSevice service;
	    
	    @GET
	    @Operation(summary = "Listar Usuarios", description = "Lista Usuarios")
	    @APIResponse(responseCode = "201", description = "Usuarios", content = {
			@Content(mediaType =  "application/json",
				schema = @Schema(implementation = UsuarioDto.class))
			}
	    )
	    public Response listar(){
			return Response.status(Response.Status.OK).header("Mensagem", "Listagem Realizada com Sucesso!").entity(service.listarUsuarios()).build();
	    }
	    
	    @POST
	    @Path("/logar")
	    @Operation(summary = "Logar", description = "Logar")
	    @APIResponse(responseCode = "200", description = "Usuarios", content = {
			@Content(mediaType =  "application/json",
				schema = @Schema(implementation = UsuarioDto.class))
			}
	    )
	    public Response logar(UsuarioDto usuarioLogin){
	    	
	    	UsuarioDto usuarioLogado;
	    	
	    	try {
	    		usuarioLogado = service.buscarUsuario(usuarioLogin);
	    		return Response.status(Response.Status.OK).entity(usuarioLogado).build();
			} catch (IndexOutOfBoundsException e) {
				return Response.status(Response.Status.NOT_FOUND).entity("NENHUM REGISTRO ENCONTRADO").build();
			}
	    	
	    }
	    
	    @POST
	    @Path("/incluir")
	    @Operation(summary = "Incluir", description = "Incluir")
	    @APIResponse(responseCode = "200", description = "Usuarios", content = {
			@Content(mediaType =  "application/json",
				schema = @Schema(implementation = UsuarioDto.class))
			}
	    )
	    public Response incluir(UsuarioDto novoUsuario){
	    	service.incluiUsuario(novoUsuario);
    		return Response.status(Response.Status.CREATED).build();
	    	
	    }
	}




