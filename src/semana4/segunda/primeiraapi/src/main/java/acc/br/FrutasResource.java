package acc.br;

import acc.br.model.Fruta;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/frutas")
public class FrutasResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(FrutasResource.class);


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> frutas() {
        LOGGER.info("Listando todas as frutas salvas");
        return Fruta.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response novaFruta(Fruta fruta) {
        fruta.persist();
        LOGGER.info("Salvando uma fruta");
        return Response.status(Response.Status.CREATED)
                .entity(fruta)  // Retorna o objeto criado
                .build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletarFruta(@PathParam("id") Long id) {
        Fruta fruta = Fruta.findById(id);
        LOGGER.info("Deletando uma fruta fruta");
        fruta.delete();
        return Response.noContent().build();
    }
}
