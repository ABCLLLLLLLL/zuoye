package cn.lzy.cache.JpaCache;

import cn.lzy.mybatiscatalog.jpa.Discuss;
import cn.lzy.mybatiscatalog.jpa.DiscussReppository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class JpaController {

    @Autowired
    private DiscussReppository mDiscussRepository;
    @GetMapping("/get/{id}")
    @Cacheable(cacheNames = "comment")
    public Discuss findById(@PathVariable("id") int comment_id){
        Optional<Discuss> mOprional = mDiscussRepository.findById(comment_id);
        if (mOprional.isPresent()){
            return mOprional.get();
        }
        return null;
    }
}
