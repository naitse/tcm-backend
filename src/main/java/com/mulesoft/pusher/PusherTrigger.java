package com.mulesoft.pusher;

import org.mule.api.MuleEventContext;
import org.mule.util.CaseInsensitiveHashMap;

import com.mulesoft.pusher.transport.HttpClientPusherTransport;

public class PusherTrigger implements org.mule.api.lifecycle.Callable{
	static HttpClientPusherTransport transport = new HttpClientPusherTransport();
	
    public void triggerPush() throws PusherTransportException{
    	PusherChannel channel = new PusherChannel("", "48682", "17eb9ecb711bee47d32d", "7a5a500515001f4c077e", transport);
    	
    	channel.pushEvent("release-updates", "{'message': 'mensajeeeeeee'}");
    }

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		String mensaje = "";
		CaseInsensitiveHashMap notif = (CaseInsensitiveHashMap)eventContext.getMessage().getInvocationProperty("UserNotification");
		
		PusherChannel channel = new PusherChannel((String) notif.get("user_name"), "48682", "17eb9ecb711bee47d32d", "7a5a500515001f4c077e", transport);
    	
		mensaje = (String) notif.get("user_name");
    	channel.pushEvent("release-updates", "{'message': "  + mensaje + "'}");
		return null;
	}

}
