package com.ashenone.db.entity;

import com.ashenone.db.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author panguangze
 * @date 2019/10/31
 */
@Setter
@Getter
@ToString
@Entity
public class BuyerEntity extends BaseEntity {
    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String phoneNum;
    @Column(length = 120)
    private String email;
    private String address;
    private byte buyerRoleType;
}
