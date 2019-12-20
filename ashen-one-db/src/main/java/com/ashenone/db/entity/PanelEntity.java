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
public class PanelEntity extends BaseEntity {
    private String name;
    @Column(name = "create_user_id")
    private int CreateUserId;
    @Column(columnDefinition = "text")
    private String data;
    private boolean active;
}
