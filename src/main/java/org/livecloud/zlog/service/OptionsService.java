package org.livecloud.zlog.service;

import java.util.HashMap;
import java.util.List;

import org.livecloud.zlog.domain.entity.Options;
import org.livecloud.zlog.domain.mapper.OptionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("optionsService")
public class OptionsService {

    @Autowired
	private OptionsMapper optionsMapper;

	public Options findById(long optionId){
		return optionsMapper.findOne(optionId);
	}
	
	public Options addNewOption(Options options){
		return optionsMapper.save(options);
	}
	
	public Options updateOption(Options options){
		return optionsMapper.save(options);
	}
	
	public HashMap<String, String> findAllOptions() {
		HashMap<String, String> options = new HashMap<String, String>();
		for (Options option : optionsMapper.getOptions()){
			options.put(option.getName(), option.getValue());
		}
		return options;
	}
	
	public List<Options> findOptions() {
		return optionsMapper.getOptions();
	}
	
	public boolean removeOption(Options options){
		Options option = optionsMapper.findOne(options.getId());
		if(option == null){
			return false;
		} else {
		    optionsMapper.delete(option);
			return true;
		}
	}
	
	public boolean removeOptionById(long optionId){
		Options g = optionsMapper.findOne(optionId);
		if(g == null){
			return false;
		} else {
		    optionsMapper.delete(g);
			return true;
		}
	}

}
