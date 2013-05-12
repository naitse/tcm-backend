package com.mulesoft.tcm.model;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleMessage;
import org.mule.api.annotations.Transformer;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.transformer.TransformerException;
import org.mule.util.CaseInsensitiveHashMap;
import org.mule.transformer.AbstractMessageAwareTransformer;

public class ReleasesTransformer extends AbstractMessageAwareTransformer{


	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Release> transform(MuleMessage message, String outputEncoding) throws TransformerException {
		ArrayList<Release> releases = new ArrayList<Release>();
		List<Iteration> iterations = null;
		Release release = null;
		Iteration iteration = null;
		ArrayList<CaseInsensitiveHashMap> records = (ArrayList<CaseInsensitiveHashMap>) message.getPayload();
		
		for(CaseInsensitiveHashMap row: records){
			
			if(!releases.isEmpty() && containsRelease(releases, (Integer) row.get("id")) )
			{
				for(Release rls: releases){
					if(rls.getId() == (Integer)row.get("id")){
						
						iteration = new Iteration();
						iteration.setId((Integer)row.get("iterId"));
						iteration.setName((String)row.get("iterationName"));
						
						rls.iterations.add(iteration) ;
						
					}
				}
				
			}else{
				release = new Release();
				release.setId((Integer)row.get("id"));
				release.setName((String)row.get("releaseName"));
				
				iterations = new ArrayList<Iteration>();
				
				iteration = new Iteration();
				iteration.setId((Integer)row.get("iterId"));
				iteration.setName((String)row.get("iterationName"));
				iterations.add(iteration);
				
				release.setIterations(iterations);
				releases.add(release);
			}
			
		}
				
		return releases;
	}

	private boolean containsRelease(ArrayList<Release> releases, Integer rlsId) {
		boolean bret = false;
		
		for(Release rls: releases){
			if(rls.getId() == rlsId){
				bret = true;
			}
		}
		
		return bret;
	}

	
	 
}
