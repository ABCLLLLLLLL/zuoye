package cn.lzy.SQL;

import cn.lzy.mybatiscatalog.jpa.Discuss;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ArticlReppository extends JpaRepository<Article,Integer> {
//    public List<Article> findByAuthorNotNull();
    @Query("select c from t_article c where c.id=?1")
    public List<Article> getDiscussPaged(Integer aid, Pageable pageable);
//    @Query(value = "select *from t_article where a_Id=?1",nativeQuery = true)
//    public List<Article> getDiscussPaged2(Integer aid,Pageable pageable);
    @Transactional
    @Modifying
    @Query("update t_article c set c.content=?1 where c.id=?2")
    public int updateDiscuss(String author,Integer id);
    @Transactional
    @Modifying
    @Query("select c from t_article c where c.id=?1")
    public int select (Integer id);
}
