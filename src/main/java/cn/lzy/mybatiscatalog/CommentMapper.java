package cn.lzy.mybatiscatalog;

import cn.lzy.mybatiscatalog.Comment;
import org.apache.ibatis.annotations.*;
    @Mapper
    public interface CommentMapper {
        @Select("SELECT * FROM t_comment WHERE id =#{id}")
        public Comment findById(Integer id);

        @Update("UPDATE t_comment SET content=#{content} WHERE id=#{id}")
        public int updateComment(Comment comment);

        @Update("UPDATE t_comment SET content=#{content} WHERE author=#{author}")
        public int updateAuthorComment(Comment comment);
        @Insert("INSERT INTO t_comment(content,author,a_id) " + "values (#{content},#{author},#{aId})")
        public int insertComment(Comment comment);


        @Delete("DELETE FROM t_comment WHERE id=#{id}")
        public int deleteComment(Integer id);

        @Select("SELECT * FROM t_comment WHERE author=#{author}")
        public Comment findByautor(String author);
    }
