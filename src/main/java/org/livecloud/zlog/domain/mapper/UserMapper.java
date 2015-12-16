package org.livecloud.zlog.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.livecloud.zlog.domain.entity.User;

public interface UserMapper {
	
	User getUserByUsername(@Param("name") String username);

    User findOne(long inputUserId);

    void delete(long userId);

    User save(User user);

    List<User> findAll(RowBounds rowBounds);

    List<User> findAll();

    long count();
}
