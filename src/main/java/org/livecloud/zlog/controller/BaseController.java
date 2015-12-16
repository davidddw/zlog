package org.livecloud.zlog.controller;

import java.util.HashMap;
import java.util.List;

import org.livecloud.zlog.domain.entity.Category;
import org.livecloud.zlog.domain.entity.User;
import org.livecloud.zlog.service.ArticleService;
import org.livecloud.zlog.service.CategoryService;
import org.livecloud.zlog.service.CommentService;
import org.livecloud.zlog.service.OptionsService;
import org.livecloud.zlog.service.TagService;
import org.livecloud.zlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes(value={"categories", "users", "options"})
public class BaseController {
	
	@Autowired
	protected CategoryService categoryService;
	
	@Autowired
	protected OptionsService optionsService;
	
	@Autowired
	protected ArticleService articleService;
	
	@Autowired
	protected CommentService commentService;
	
	@Autowired
	protected TagService tagService;
	
	@Autowired
	protected UserService userService;
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.findAllCategories();
	}
	
	@ModelAttribute("users")
	public List<User> getUsers() {
		return userService.findAllUsers();
	}
	
	@ModelAttribute("options")
	public HashMap<String, String> getOptions() {
		return optionsService.findAllOptions();
	}
}
