package com.sourabh.test;

import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class XeroTest {

	private static final String PROTECTED_RESOURCE_URL = "https://api.xero.com/api.xro/2.0/Organisation";//https://api.xero.com/api.xro/2.0/

	public static void main(String[] args)
	  {
	    // If you choose to use a callback, "oauth_verifier" will be the return value by Twitter (request param)
	    OAuthService service = new ServiceBuilder()
	                                .provider(ZeroApi.class).
	                                apiKey("RVDAMRAYBG0ZJVUAA3CTPKYMPLCFTR").
	                                apiSecret("ZN8H97DI2Z1WAMUWNRIAC5F79LSESJ")
	                                .debugStream(System.out)
	                                .build();
	    Scanner in = new Scanner(System.in);

	    System.out.println("=== Xero's OAuth Workflow ===");
	    System.out.println();

	    // Obtain the Request Token
	    System.out.println("Fetching the Request Token...");
	    Token requestToken = service.getRequestToken();
	    //requestToken.
	    System.out.println(requestToken.getRawResponse());
	    System.out.println("Got the Request Token!");
	    System.out.println();

	    System.out.println("Now go and authorize Scribe here:");
	    System.out.println(service.getAuthorizationUrl(requestToken));
	    System.out.println("And paste the verifier here");
	    System.out.print(">>");
	    Verifier verifier = new Verifier(in.nextLine());
	    System.out.println();

	    // Trade the Request Token and Verfier for the Access Token
	    System.out.println("Trading the Request Token for an Access Token...");
	    Token accessToken = service.getAccessToken(requestToken, verifier);
	    System.out.println("Got the Access Token!");
	    System.out.println("(if your curious it looks like this: " + accessToken + " )");
	    System.out.println();

	    // Now let's go and ask for a protected resource!
	    System.out.println("Now we're going to access a protected resource...");
	    OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
	    //request.addBodyParameter("status", "this is sparta! *");
	    service.signRequest(accessToken, request);
	    Response response = request.send();
	    System.out.println("Got it! Lets see what we found...");
	    System.out.println();
	    System.out.println(response.getBody());

	    System.out.println();
	    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
	  }
}
