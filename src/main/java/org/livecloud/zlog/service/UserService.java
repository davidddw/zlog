package org.livecloud.zlog.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.livecloud.zlog.domain.entity.User;
import org.livecloud.zlog.domain.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

@Service("userService")
public class UserService {
    
    @Autowired
	private UserMapper userMapper;
	
	public User findUserByName(String name) {
		return userMapper.getUserByUsername(name);
	}
	
	public long getUserCount() {
		return userMapper.count();
	}
	
	public User findById(long userId) {
		return userMapper.findOne(userId);
	}
	
	public List<User> findAllUsers() {
		return userMapper.findAll();
	}
	
	public PageInfo<User> findAllUsers(int pageIndex, int pageSize) {
	    List<User> list = userMapper.findAll(new RowBounds(pageIndex, pageSize));
	    return new PageInfo<User>(list);
	}
	
	public User addNewUser(User user) {
		if(userMapper.getUserByUsername(user.getName())!=null){
			return null; 
		} else {
			return userMapper.save(user);
		}
	}
	
	public User updateUser(User user){
		return userMapper.save(user);
	}
	
	public boolean removeUserById(long userId) {
		User u = userMapper.findOne(userId);
		if(u == null){
			return false;
		}else {
		    userMapper.delete(userId);
			return true;
		}	
	}
}