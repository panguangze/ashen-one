package com.ashenone.db.entity;

import com.ashenone.db.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * @author panguangze
 * @date 2019/10/31
 */
@Setter
@Getter
@ToString
@Entity
public class ProductEntity extends BaseEntity {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String uuid;
    private String customId;
    @Column(length = 30)
    private String name;
    @Column(columnDefinition = "text")
    private String profile;
    @Column(length = 120)
    private String productFirstImgPath;
    @Column(length = 120)
    private String productSecondImgPath;
    private float price;
    private int createUserId;
    private boolean analysis;
    private boolean generateReport;

    private byte statusType;

    @ManyToOne
    @JoinColumn(name = "bio_pipline_id", referencedColumnName = "id")
    private BioPiplineEntity bioPipLineEntity;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Set<PanelEntity> panelEntities;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private ShopEntity shopEntity;
}
