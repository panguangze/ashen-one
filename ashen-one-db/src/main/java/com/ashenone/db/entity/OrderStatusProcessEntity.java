package com.ashenone.db.entity;

import com.ashenone.db.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * @author panguangze
 * @date 2019/10/31
 */
@Setter
@Getter
@ToString
@Entity
public class OrderStatusProcessEntity extends BaseEntity {
    private byte orderStatusType;
}
