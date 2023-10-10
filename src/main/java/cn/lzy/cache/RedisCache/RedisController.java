package cn.lzy.cache.RedisCache;

import cn.lzy.mybatiscatalog.jpa.Discuss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    //    查询信息
    @GetMapping("/getRedis/{id}")
    public Discuss findById(@PathVariable("id") int comment_id) {
        Discuss mDiscuss = redisService.findById(comment_id);
        if(mDiscuss != null) {
            return mDiscuss;
        }
        return null;
    }

    //    更新信息
    @GetMapping("/updateById/{id}/{author}")
    public Discuss updateById(@PathVariable("id") int comment_id) {
        Discuss mDiscuss = redisService.findById(comment_id);
        return mDiscuss;
    }

    //    删除信息
    @GetMapping("/deleteRedis/{id}")
    public String deleteById(@PathVariable("id") int comment_id) {
        String result = redisService.deleteById(comment_id);
        return result;
    }
}
