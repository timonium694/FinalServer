package edu.neumont.csc380.service;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import models.Auction;
import models.Bid;
import models.Item;

@Path("/auction")
@Consumes("application/vnd.neumont.auth.edu-v1+jso")
@Produces("application/vnd.neumont.auth.edu-v1+jso")
public interface AuctionService {
	Auction auctionDataLayer = new Auction();
	@POST
	Response createAuction(Item item);
	
	@GET
	Response getAllAuctions();
	
	@GET
	@Path("/{id}")
	Response getAuction(@PathParam("id") int id);
	
	@DELETE
	Response deleteBid(Bid bid);
	
	@PUT
	@Path("/{id}")
	Response updateItem(Item item);
	
	@POST
	@Path("/{id}")
	Response placeBid(@PathParam("id") int id);
}