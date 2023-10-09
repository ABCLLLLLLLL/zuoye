package cn.lzy.cache.RedisCache;

import cn.lzy.mybatiscatalog.jpa.Discuss;
import cn.lzy.mybatiscatalog.jpa.DiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedisService {

    @Autowired
    private DiscussRepository mDiscussRepository;

    //根据评论id查询评论信息
    //@Cacheable(cacheNames = "comment")
    @Cacheable(cacheNames = "comment",unless = "#result==null")
    public Discuss findById(int comment_id) { //2
        Optional<Discuss> optional = mDiscussRepository.findById(comment_id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    //  更新评论信息
    @CachePut(cacheNames = "comment",key = "#result.id")
    public Discuss updateById(Discuss comment) {
        mDiscussRepository.updateDiscuss(comment.getAuthor(), comment.getaId());
        return comment;
    }

    //    删除评论信息
    @CacheEvict(cacheNames = "comment")//删除redis服务里面的comment表里面数据
    public String deleteById(int comment_id) {
        mDiscussRepository.deleteById(comment_id);//只会删除mysql里面数据
        return "删除成功";
    }
}

