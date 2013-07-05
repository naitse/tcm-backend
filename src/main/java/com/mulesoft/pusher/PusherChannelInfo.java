package com.mulesoft.pusher;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.mortbay.log.Log;
import org.mule.util.CaseInsensitiveHashMap;

import com.mulesoft.pusher.transport.HttpClientPusherTransport;

public class PusherChannelInfo{
	static HttpClientPusherTransport transport = new HttpClientPusherTransport();
	
    public static byte[] getChannelInfo(CaseInsensitiveHashMap message) throws PusherTransportException{
    	PusherChannel channel = new PusherChannel((String) message.get("user_name"), "48682", "17eb9ecb711bee47d32d", "7a5a500515001f4c077e", transport);
    	
    	return channel.getChannelInfo().getContent();
    }   

}
