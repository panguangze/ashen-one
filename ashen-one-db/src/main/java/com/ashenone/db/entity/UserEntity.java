package com.ashenone.db.entity;


import com.ashenone.db.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author panguangze
 * @date 2019/10/31
 * 用户表
 */
@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
public class UserEntity extends BaseEntity {
    public UserEntity(String username, String password, String phoneNum, String email) {
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.email = email;
    }
    @Column(length = 30)
    private String username;
    private String password;
    @Column(length = 30)
    private String firstName;
    @Column(length = 30)
    private String LastName;
    /**
     * 存储头像的位置
     */
    @Column(length = 120)
    private String avatarPath;
    @Column(length = 120)
    private String email;
    @Column(length = 30)
    private String phoneNum;
    @Column(length = 120)
    private String city;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private ShopEntity shopEntity;
    /**
     * 该用户是否可用，默认可用
     */
    private boolean active;
    private int createUserId;
    /**
     * 角色，目前设计0：平台管理员，1：商家，后期可能会有扩展
     */
    private byte userRoleType = 1;
}
