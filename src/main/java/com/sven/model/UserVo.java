package com.sven.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author xianglong
 * @date 2019/1/29
 */
@Data
public class UserVo implements Serializable {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String avatar;
    private Integer sex = 1;
    private BigDecimal balance;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
