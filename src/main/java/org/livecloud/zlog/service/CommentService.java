package org.livecloud.zlog.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.livecloud.zlog.domain.entity.Article;
import org.livecloud.zlog.domain.entity.Comment;
import org.livecloud.zlog.domain.mapper.CommentMapper;
import org.livecloud.zlog.domain.vo.CommentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.github.pagehelper.PageInfo;

@Service("commentService")
public class CommentService {
    
    @Autowired
	private CommentMapper commentMapper;
	
	public long getCommentCount() {
		return commentMapper.count();
	}
	
	public long getCommentCountByArticle(long articleId) {
		return commentMapper.getCommentCountByArticle(articleId);
	}
	
	public Comment addNewComment(CommentInfo commentInfo, Article article){
		Comment com = new Comment(HtmlUtils.htmlEscape(commentInfo.getSubmitter()), 
				HtmlUtils.htmlEscape(commentInfo.getEmail()), HtmlUtils.htmlEscape(commentInfo.getContent()));
		com.setArticle(article);
		article.setCommentCount(article.getCommentCount()+1);
		return commentMapper.save(com);
	}
	
	public Comment findById(long commentId){
		return commentMapper.findOne(commentId);
	}
	
	public PageInfo<Comment> findAllByArticle(long articleId, int pageIndex, int pageSize){
        List<Comment> list = commentMapper.getCommentsByArticle(articleId, new RowBounds(pageIndex, pageSize));
        return new PageInfo<Comment>(list);
	}
	
	public PageInfo<Comment> findLatestComments(int pageIndex, int pageSize){
	    List<Comment> list = commentMapper.getCommentsBySubmitDate(new RowBounds(pageIndex, pageSize));
	    return new PageInfo<Comment>(list);
	}
	
	public Comment updateComment(Comment comment){
		return commentMapper.save(comment);
	}
	
	public boolean removeComment(Comment comment){
		Comment c = commentMapper.findOne(comment.getId());
		if(c==null){
			return false;
		} else {
			Article article = c.getArticle();
			article.setCommentCount(article.getCommentCount()-1);
			commentMapper.delete(c);
			return true;
		}
	}
	
	public boolean removeCommentById(long commentId){
		Comment c = commentMapper.findOne(commentId);
		if(c==null){
			return false;
		} else {
			Article article = c.getArticle();
			article.setCommentCount(article.getCommentCount()-1);
			commentMapper.delete(c);
			return true;
		}
	}
}
