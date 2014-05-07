package edu.neumont.csc380.AuctionInterfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public interface IAuction {
	
	@GET
	public Response item();
	
	@POST
	public Response bid();
	
	@GET
	public Response getBid();
	
	@PUT
	public Response update();
	
	@DELETE
	public Response delete();
	
	@POST
	public Response create();
}
