package com.sven.service.article.impl;

import com.sven.service.article.api.ArticleService;
import com.sven.service.article.api.dto.ArticleDTO;
import com.sven.service.article.impl.dao.po.Article;
import com.sven.service.article.impl.dao.reposiory.ArticleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xianglong
 * @date 2019/1/29
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public List<ArticleDTO> getByUserId(Long userId) {
        List<Article> articles = articleRepository.findByUserId(userId);
        if (articles == null) {
            return Collections.emptyList();
        }
        return articles.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ArticleDTO toDTO(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        BeanUtils.copyProperties(article, articleDTO);
        return articleDTO;
    }
}
