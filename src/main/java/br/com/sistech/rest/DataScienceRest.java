package br.com.sistech.rest;

import br.com.sistech.dto.DataScienceDto;
import br.com.sistech.dto.UsuarioDto;
import br.com.sistech.dto.request.UsuarioRequest;
import br.com.sistech.service.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("graficos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DataScienceRest {

    @Inject
    DataScienceSevice sevice;

    @GET
    @Operation(summary = "Dados", description = "Dados")
    @APIResponse(responseCode = "201", description = "Dados Dashboard", content = {
        @Content(mediaType =  "application/json",
            schema = @Schema(implementation = DataScienceDto.class))
        }
    )
    public Response listar(){
        return Response.status(Response.Status.OK).header("Mensagem", "Dados gerados com sucesso!").entity(sevice.gerarDadosGrafico()).build();
    }

}




