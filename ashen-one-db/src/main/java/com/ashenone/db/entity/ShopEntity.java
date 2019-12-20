package com.ashenone.db.entity;

import com.ashenone.db.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * @author panguangze
 * @date 2019/10/31
 * 商店表
 */
@Setter
@Getter
@ToString
@Entity
public class ShopEntity extends BaseEntity {
    @Column(length = 30)
    private String shopName;
    /**
     * 是谁创建的这个商店
     */
    private int createUserId;
    @Column(columnDefinition = "text")
    private String profile;
    @Column(length = 120)
    private String address;
    @OneToOne(mappedBy = "shopEntity")
    private UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Set<ProductEntity> productEntities;

}
