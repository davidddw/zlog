package org.livecloud.zlog.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.livecloud.zlog.domain.entity.Category;
import org.livecloud.zlog.domain.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

@Service("categoryService")
public class CategoryService {
    
    @Autowired
	private CategoryMapper categoryMapper;
		
	public long getCategoryCount() {
		return categoryMapper.count();
	}
	
	public Category findById(long categoryId) {
		return categoryMapper.findOne(categoryId);
	}
	
	public Category findByClass(Category category) {
		return categoryMapper.findOne(category.getId());
	}
	
	public List<Category> findAllCategories() {
		return categoryMapper.getCategories();
	}
	
	public PageInfo<Category> findAllCategories(int pageIndex, int pageSize) {
	    List<Category> list = categoryMapper.findAll(new RowBounds(pageIndex, pageSize));
	    return new PageInfo<Category>(list); 
	}
	
	public Category addNewCategory(Category category){
		return categoryMapper.save(category);
	}
	
	public Category updateCategory(Category category){
		return categoryMapper.save(category);
	}
	
	public boolean removeCategory(Category category){
		Category c = categoryMapper.findOne(category.getId());
		if(c==null){
			return false;
		} else {
		    categoryMapper.delete(c);
			return true;
		}
	}
	
	public boolean removeCategoryById(long categoryId) {
		Category c = categoryMapper.findOne(categoryId);
		if(c==null){
			return false;
		} else {
		    categoryMapper.delete(c);
			return true;
		}
	}
	
}
