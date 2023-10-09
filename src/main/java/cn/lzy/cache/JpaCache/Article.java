package cn.lzy.cache.JpaCache;

import cn.lzy.SQL.ArticlReppository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Article {

    @Autowired
    private ArticlReppository mDiscussRepository;
    @GetMapping("/get/{id}")
    @Cacheable(cacheNames = "Article")
    public cn.lzy.SQL.Article findById(@PathVariable("id") int article_id){
        Optional<cn.lzy.SQL.Article> mOprional = mDiscussRepository.findById(article_id);
        if (mOprional.isPresent()){
            return mOprional.get();
        }
        return null;
    }

}
