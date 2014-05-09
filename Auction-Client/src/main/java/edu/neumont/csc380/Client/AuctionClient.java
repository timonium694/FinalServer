package edu.neumont.csc380.Client;

import edu.neumont.csc380.ExceptionManagement.invalidInput.InvalidInputException;
import edu.neumont.csc380.ProfileWebService.model.ContactInformation;
import edu.neumont.csc380.ProfileWebService.model.Profile;
import edu.neumont.csc380.ProfileWebService.services.ProfileClient;
import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.auth.client.AuthClientImpl;
import edu.neumont.csc380.exceptions.InvalidTokenException;
import edu.neumont.csc380.exceptions.UserDoesNotExistException;

public class AuctionClient
{

	public static void main(String[] args)
	{
		AuthClientImpl authClient = new AuthClientImpl();
		ProfileClient profileClient = new ProfileClient();
		try
		{
			createUsers(authClient, profileClient);

		} 
		catch (Exception e)
		{

		}
	}

	private static void createUsers(AuthClientImpl authClient, ProfileClient profileClient) throws InvalidTokenException, UserDoesNotExistException,
			InvalidInputException
	{
		Profile timProfile = new Profile();
		timProfile.setUsername("tim1");
		timProfile.setFirstName("tim");
		timProfile.setLastName("toth");
		timProfile.setPassword("test100");
		Profile adamProfile = new Profile();
		adamProfile.setUsername("adam1");
		adamProfile.setFirstName("tim");
		adamProfile.setLastName("toth");
		adamProfile.setPassword("test100");
		Profile brandenProfile = new Profile();
		brandenProfile.setUsername("branden1");
		brandenProfile.setFirstName("tim");
		brandenProfile.setLastName("toth");
		brandenProfile.setPassword("test100");

		ContactInformation timContactInfo = new ContactInformation();
		timContactInfo.setAddress("143 South Main St.");
		timContactInfo.setEmail("timonium694@gmail.com");
		timContactInfo.setPhone("330-766-0092");
		timProfile.setContactInformation(timContactInfo);

		ContactInformation adamContactInfo = new ContactInformation();
		adamContactInfo.setAddress("143 South Main St.");
		adamContactInfo.setEmail("timonium694@gmail.com");
		adamContactInfo.setPhone("330-766-0092");
		adamProfile.setContactInformation(adamContactInfo);

		ContactInformation brandenContactInfo = new ContactInformation();
		brandenContactInfo.setAddress("143 South Main St.");
		brandenContactInfo.setEmail("timonium694@gmail.com");
		brandenContactInfo.setPhone("330-766-0092");
		brandenProfile.setContactInformation(brandenContactInfo);

		authClient.createUser(timProfile.getUsername(), timProfile.getPassword(), AuthorityLevel.Admin);
		authClient.authenticateUser(timProfile.getUsername(), timProfile.getPassword());

		authClient.createUser(adamProfile.getUsername(), adamProfile.getPassword(), AuthorityLevel.User);
		authClient.authenticateUser(adamProfile.getUsername(), "iheartpronz");

		authClient.createUser(brandenProfile.getUsername(), brandenProfile.getPassword(), AuthorityLevel.User);
		authClient.authenticateUser(brandenProfile.getUsername(), brandenProfile.getPassword());

		profileClient.createProfile(timProfile);
		profileClient.createProfile(adamProfile);
		profileClient.createProfile(brandenProfile);
	}

}
