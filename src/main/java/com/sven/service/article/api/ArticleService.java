package com.sven.service.article.api;

import com.sven.service.article.api.dto.ArticleDTO;

import java.util.List;

/**
 *
 * @author xianglong
 * @date 2019/1/29
 */
public interface ArticleService {

    List<ArticleDTO> getByUserId(Long userId);


}
