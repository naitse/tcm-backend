package com.mulesoft.tcm.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageAwareTransformer;
import org.mule.util.CaseInsensitiveHashMap;

public class PluginsTransformer extends AbstractMessageAwareTransformer{
	
	@SuppressWarnings("unchecked")
	@Override
	public  ArrayList<Plugin> transform(MuleMessage message, String outputEncoding) throws TransformerException {
		
		ArrayList<Plugin> plugins = new ArrayList<Plugin>();
		ArrayList<CaseInsensitiveHashMap> records = (ArrayList<CaseInsensitiveHashMap>) message.getPayload();
		int currentId = 0;
		Plugin pluginToAdd = null;
		
		for(CaseInsensitiveHashMap row: records){
			
			if( currentId != (Integer)row.get("id") ){
				currentId = (Integer)row.get("id");
				pluginToAdd = new Plugin();
				pluginToAdd.setId(currentId);
				pluginToAdd.setName((String)row.get("name") );
				plugins.add(pluginToAdd);
				
			}
			
		}
		
		for(Plugin p: plugins){
			HashMap<String, String> properties = new HashMap<String, String>();
			for(CaseInsensitiveHashMap row: records){
				if((Integer)row.get("id")  == p.getId()){
					properties.put((String)row.get("prop"), (String)row.get("value"));
				}
			}
			p.setProperties(properties);
			
		}
				
		return plugins;
	}
	
}
