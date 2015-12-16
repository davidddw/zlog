package org.livecloud.zlog.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.livecloud.zlog.domain.entity.Tag;

public interface TagMapper {
	
	List<Tag> getByName(String name);
	
	Tag getOneTagByName(@Param("tagValue") String tagValue);

    List<Tag> getAllTags();

    long deleteTag(long id);

    long updateTag(Tag tag);
    
    long addTag(Tag tag);

    Tag getTag(long tagId);

    boolean exists(long id);

}
