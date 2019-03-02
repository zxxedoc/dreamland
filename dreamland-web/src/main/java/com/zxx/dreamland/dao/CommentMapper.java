package com.zxx.dreamland.dao;

import com.zxx.dreamland.entity.Comment;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//通用 Mapper 是基于 MyBatis 的一个插件，
//它实现了大部分常用的增删改查方法，只要继承它就能拥有所有的通用方法，省去手写 XML 的烦恼。
//但是对于复杂的查询语句还是需要手写 XML 的。

public interface CommentMapper extends Mapper<Comment> {
    //根据文章id查询所有评论
    List<Comment> selectAll(@Param("cid")long cid);
    //根据文章id查询所有一级评论
    List<Comment> findAllFirstComment(@Param("cid")long cid);
    //根据文章id和二级评论ids查询出所有二级评论
    List<Comment> findAllChildrenComment(@Param("cid")long cid,@Param("children")String children);
    //插入评论并返回主键id 返回值是影响行数  id在Comment对象中
    int insertComment(Comment comment);
}
