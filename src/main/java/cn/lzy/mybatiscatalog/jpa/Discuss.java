package cn.lzy.mybatiscatalog.jpa;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity(name = "t_comment")//映射的表名
public class Discuss implements Serializable {
    @Id//表示映射对应的主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键自增策略
    private Integer id;
    private String content;
    private String author;
    @Column(name = "a_id")//指定映射的表字段名
    private Integer aId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String contnent) {
        this.content = contnent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "id=" + id +
                ", contnent='" + content + '\'' +
                ", author='" + author + '\'' +
                ", aId=" + aId +
                '}';
    }
}
