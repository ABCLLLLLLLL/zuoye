package cn.lzy.mybatiscatalog;

public class CommentMapper {
    @Select("SELECT * FROM t_comment WHERE id =#{id}")
    public Comment findById(Integer id);
}
