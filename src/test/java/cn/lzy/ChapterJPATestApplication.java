package cn.lzy;


import cn.lzy.SQL.ArticlReppository;
import cn.lzy.SQL.Article;
import cn.lzy.mybatiscatalog.jpa.Discuss;
import cn.lzy.mybatiscatalog.jpa.DiscussRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterJPATestApplication {
    @Autowired
    private DiscussRepository discussRepository;
    @Autowired
    private ArticlReppository reppository;

    @Test
    public void selectComment(){
        Optional<Discuss> optional= discussRepository.findById(1);
        if (optional.isPresent()){
            System.out.println(optional.get());
        }
    }
    @Test
    public void deleteComment() {
        discussRepository.deleteById(3);
    }

    //查询article
    @Test
    public void selectArticle(){
        Optional<Article> optional=reppository.findById(1);

            System.out.println(optional);

    }
}
