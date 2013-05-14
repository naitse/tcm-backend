package com.mulesoft.tcm.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageAwareTransformer;
import org.mule.util.CaseInsensitiveHashMap;

public class PluginsSettingsTransformer extends AbstractMessageAwareTransformer{
	
	@SuppressWarnings("unchecked")
	@Override
	public  HashMap<String, String> transform(MuleMessage message, String outputEncoding) throws TransformerException {
		
		HashMap<String, String> settings = new HashMap<String, String>();
		ArrayList<CaseInsensitiveHashMap> records = (ArrayList<CaseInsensitiveHashMap>) message.getPayload();
		
		for(CaseInsensitiveHashMap row: records){
			settings.put((String)row.get("prop"), (String) row.get("value"));
		}
				
		return settings;
	}
	
}
