package com.sven.service.article.impl.dao.po;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * @author xianglong
 * @date 2019/1/29
 */
@Data
@Table(name = "article")
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String content;

}
