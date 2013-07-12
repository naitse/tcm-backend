package com.mulesoft.pusher;

import org.mule.api.MuleEventContext;

import com.mulesoft.pusher.transport.HttpClientPusherTransport;

public class PusherTriggerInUseBy implements org.mule.api.lifecycle.Callable{
	static HttpClientPusherTransport transport = new HttpClientPusherTransport();
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		PusherChannel channel = new PusherChannel("being-seen", "48682", "17eb9ecb711bee47d32d", "7a5a500515001f4c077e", transport);
    	
		String itemId = (String)eventContext.getMessage().getInvocationProperty("itemId");
		String userName = (String)eventContext.getMessage().getInvocationProperty("userName");
		String projectId = (String)eventContext.getMessage().getInboundProperty("projectId");
		
    	channel.pushEvent("item-selected", "{\"itemId\": \""  + itemId + "\",\"userName\":\""+userName+"\",\"projectId\":\""+projectId+"\"}");
		return null;
	}

}
