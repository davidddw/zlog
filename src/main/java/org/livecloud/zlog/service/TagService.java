package org.livecloud.zlog.service;

import java.util.List;
import java.util.Set;

import org.livecloud.zlog.domain.entity.Article;
import org.livecloud.zlog.domain.entity.Tag;
import org.livecloud.zlog.domain.mapper.TagMapper;
import org.livecloud.zlog.utils.SetOpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tagService")
public class TagService {
    @Autowired
	private TagMapper tagMapper;
	
	public void addNewTag(String tagValue){
		Tag tag = new Tag(tagValue);
		tagMapper.save(tag);
	}
	
	public boolean deleteByTagId(long tagId){
		Tag tag = tagMapper.findOne(tagId);
		if(tag==null){
			return false;
		}else {
			for (Article article : tag.getArticles()){
				article.setTags(null);
			}
			tag.setArticles(null);
			tagMapper.delete(tagId);
			return true;
		}
	}
	
	public Tag findById(long tagId) {
		return tagMapper.findOne(tagId);
	}
	
	public Tag findByName(String tagName) {
		List<Tag> tags = tagMapper.findByName(tagName);
		return tags.size()>0 ? tags.get(0): null;
	}
	
	public boolean checkTagExistById(long id) {
		return tagMapper.exists(id);
	}
	
	public boolean checkTagExistByName(String tagValue) {
		return tagMapper.findByName(tagValue).size()>0 ? true:false;
	}
	
	public void addTagFromStrings(String[] tagValues) {
		List<Tag> list = tagMapper.findAll();
		Set<Tag> newTag = SetOpt.diff(list, tagValues, Tag.class);
		for(Tag tag : newTag){
		    tagMapper.save(tag);
		}
	}
}
