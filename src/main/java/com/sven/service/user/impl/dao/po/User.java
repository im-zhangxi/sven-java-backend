package com.sven.service.user.impl.dao.po;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="user")
@Data
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20,columnDefinition = "varchar(20) COMMENT '姓名'")
    private String name;

    @Column(length = 11, columnDefinition = "char(11) not null comment '手机号'")
    private String phone;

    @Column(length = 50, columnDefinition = "varchar(50) comment '邮箱'")
    private String email;

    @Column(columnDefinition = "varchar(255) comment '头像uri'")
    private String avatar;

    @Column(columnDefinition = "varchar(255) default '' comment '密码'")
    private String pwd;

    @Column(columnDefinition = "tinyint(3) default 1 not null comment '性别'")
    private Integer sex = 1;

    @Column(precision = 12, scale = 2,columnDefinition = "decimal(12,3) default 0.000 comment '余额'")
    private BigDecimal balance;

    @Column(name = "created_at", columnDefinition = "timestamp")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp")
    private Timestamp updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
