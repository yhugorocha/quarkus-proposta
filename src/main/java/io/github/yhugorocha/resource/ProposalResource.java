package io.github.yhugorocha.resource;

import io.github.yhugorocha.dto.ProposalRequestDTO;
import io.github.yhugorocha.service.ProposalService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/proposal")
public class ProposalResource {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    ProposalService proposalService;

    @GET
    @Path("/{id}")
    public Response findDetailProposal(@PathParam("id") Long id){
        return Response.ok(proposalService.findFullProposal(id)).build();
    }

    @POST
    public Response createNewProposal(ProposalRequestDTO proposalRequestDTO){
        proposalService.createNewProposal(proposalRequestDTO);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProposal(@PathParam("id") Long id){
        proposalService.removeProposal(id);
        return Response.ok().build();
    }
}
