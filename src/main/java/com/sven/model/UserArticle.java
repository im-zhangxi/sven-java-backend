package com.sven.model;

import lombok.Data;

/**
 * Created by xianglong on 2019/1/29.
 */
@Data
public class UserArticle {

    private Long id;

    private String userName;

    private String phone;

    private String content;

    private Long userId;
}
