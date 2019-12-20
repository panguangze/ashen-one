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
public class OrderEntity extends BaseEntity {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String uuid;
    private String customId;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private BuyerEntity buyerEntity;
    private int CreateUserId;
    private boolean sequence;
    private boolean post;
    private float realPrice;

    private byte orderStatusType;
    private boolean active;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Set<OrderStatusProcessEntity> statusProcesses;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Set<IdentifierEntity> identifierEntities;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private ReportEntity reportEntity;
}
