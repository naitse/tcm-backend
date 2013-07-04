package com.mulesoft.tcm.utils;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GetJiraIssueInfo extends AbstractMessageTransformer{

	
	  private static URI getBaseURI(String issueKey) {
	    return UriBuilder.fromUri("https://www.mulesoft.org/jira/rest/api/2/issue/"+issueKey).build();
	  }

	@Override
	public Object transformMessage(MuleMessage message,
			String outputEncoding) throws TransformerException {
		String issueKey = message.getInvocationProperty("issueKey");
		String user = message.getInvocationProperty("user");
		String pass = message.getInvocationProperty("pass");
	    ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(user, pass));
	    WebResource service = client.resource(getBaseURI(issueKey));
	    return service.accept(MediaType.APPLICATION_JSON).get(String.class);
	}

}

