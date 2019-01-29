package com.sven.service.article.api.dto;

import lombok.Data;

/**
 *
 * @author xianglong
 * @date 2019/1/29
 */
@Data
public class ArticleDTO {

    private Long id;

    private Long userId;

    private String content;

}
