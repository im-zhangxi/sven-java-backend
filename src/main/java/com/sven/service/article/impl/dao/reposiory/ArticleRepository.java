package com.sven.service.article.impl.dao.reposiory;

import com.sven.service.article.impl.dao.po.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author xianglong
 * @date 2019/1/29
 */
public interface ArticleRepository extends JpaRepository<Article, Long>{

    List<Article> findByUserId(Long userId);
}
