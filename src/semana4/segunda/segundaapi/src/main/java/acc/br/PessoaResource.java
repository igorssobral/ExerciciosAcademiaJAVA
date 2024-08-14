package acc.br;

import acc.br.model.Pessoa;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/pessoas")
public class PessoaResource {

    @GET
    public List<Pessoa> listarTodas() {
        return Pessoa.listAll();
    }

    @GET
    @Path("/{nome}")
    public Pessoa buscarPorNome(@PathParam("nome") String nome) {
        return Pessoa.findByName(nome);
    }

    @POST
    @Transactional
    public Response criarPessoa(Pessoa pessoa) {
        pessoa.persist();
        return Response.status(Response.Status.CREATED).entity(pessoa).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletarPessoa(@PathParam("id") Long id) {
        Pessoa.deleteById(id);
        return Response.noContent().build();
    }
}