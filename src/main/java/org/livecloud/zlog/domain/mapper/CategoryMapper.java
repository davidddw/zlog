package org.livecloud.zlog.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.livecloud.zlog.domain.entity.Category;

public interface CategoryMapper {
	
    List<Category> getCategories(RowBounds rowBounds);
	
	List<Category> getCategories();

    Category getCategory(@Param("id") long id);

    long getCount();

    long deleteCategory(Category c);

    long addCategory(Category category);
    
    long updateCategory(Category category);
}
