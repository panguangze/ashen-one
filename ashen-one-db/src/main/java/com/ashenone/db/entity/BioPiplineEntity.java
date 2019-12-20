package com.ashenone.db.entity;

import com.ashenone.db.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author panguangze
 * @date 2019/10/31
 */
@Setter
@Getter
@ToString
@Entity
public class BioPiplineEntity extends BaseEntity {
    private String name;
    private int CreateUserId;
    @OneToMany
    @JoinColumn(name = "bio_pipline_id", referencedColumnName = "id")
    private Set<ProductEntity> productEntities;
}
