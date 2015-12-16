package org.livecloud.zlog.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.livecloud.zlog.domain.entity.Tag;

public interface TagMapper {
	
	List<Tag> findByName(String name);
	
	Tag getOneTagByName(@Param("tagValue") String tagValue);

    List<Tag> findAll();

    void delete(long id);

    void save(Tag tag);

    Tag findOne(long tagId);

    boolean exists(long id);

}
