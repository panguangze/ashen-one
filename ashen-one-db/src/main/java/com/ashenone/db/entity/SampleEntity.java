package com.ashenone.db.entity;

import com.ashenone.db.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
public class SampleEntity extends BaseEntity {
    @Column(length = 30)
    private String number;
    private byte sampleType;
    private int quantity;
    @Column(columnDefinition = "Date")
    private Date sampleTime;
    @Column(columnDefinition = "Date")
    private Date receiveTime;
    private boolean active;
    private int creatUserId;
    private byte statusType;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "sample_id", referencedColumnName = "id")
    private Set<SequenceEntity> sequenceEntities;

    @ManyToMany
    @JoinTable(
            name = "samples_posts",
            joinColumns = {@JoinColumn(name = "sample_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "id")}
    )
    private Set<PostEntity> postEntities;
}
