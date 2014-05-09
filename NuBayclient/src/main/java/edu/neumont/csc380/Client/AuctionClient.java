package edu.neumont.csc380.Client;

import edu.neumont.csc380.AuctionInterfaces.IAuction;
import edu.neumont.csc380.ProfileWebService.model.*;
import edu.neumont.csc380.ProfileWebService.services.ProfileClient;
import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.auth.client.AuthClientImpl;


public class AuctionClient {
	
	public static void main(String[] args)
	{
		AuthClientImpl ai = new AuthClientImpl();
		ProfileClient pi = new ProfileClient();
		try
		{
			Profile p = new Profile();
			p.setUsername("test");
			p.setPassword("password");
			p.setLastName("last");
			p.setFirstName("first");
			ContactInformation c = new ContactInformation();
			c.setAddress("here");
			c.setEmail("this@email.com");
			c.setPhone("012394");
			p.setContactInformation(c);

			ai.createUser(p.getUsername(), p.getPassword(), AuthorityLevel.Admin);
			ai.authenticateUser(p.getUsername(), p.getPassword());
			pi.createProfile(p);
			
		}
		catch(Exception e)
		{
			
		}
	}

}
