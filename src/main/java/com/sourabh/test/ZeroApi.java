package com.sourabh.test;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class ZeroApi extends DefaultApi10a
{
  private static final String AUTHORIZE_URL = "https://api.xero.com/oauth/Authorize";
  private static final String REQUEST_TOKEN_ENDPOINT = "https://api.xero.com/oauth/RequestToken";
  private static final String ACCESS_TOKEN_ENDPOINT = "https://api.xero.com/oauth/AccessToken";
 
  @Override
  public String getAccessTokenEndpoint()
  {
    return ACCESS_TOKEN_ENDPOINT;
  }

  @Override
  public String getRequestTokenEndpoint()
  {
    return REQUEST_TOKEN_ENDPOINT;
  }
  
  @Override
  public String getAuthorizationUrl(Token requestToken)
  {
	  return "https://api.xero.com/oauth/Authorize?oauth_token=" + requestToken.getToken();
  }
}