package org.livecloud.zlog.domain.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.livecloud.zlog.domain.entity.Category;

public interface CategoryMapper {
	
    List<Category> getCategories(RowBounds rowBounds);
	
	List<Category> getAllCategories();

    Category findOne(long inputCategoryId);

    long count();

    void delete(Category c);

    Category save(Category category);

    List<Category> findAll(RowBounds rowBounds);

    List<Category> getCategories();
}
