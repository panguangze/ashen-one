package com.ashenone.db.entity;

import com.ashenone.db.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
public class PostEntity extends BaseEntity {

    @Column(length = 30)
    private String company;
    @Column(length = 30)
    private String postNum;
    @Column(columnDefinition = "Date")
    private Date postTime;
    private float postPrice;
    private boolean received;
    @Column(columnDefinition = "Date")
    private Date receivedTime;
    @Column(length = 30)
    private String receiver;
    @Column(length = 30)
    private String sender;
    private int createUserId;

    @ManyToMany(mappedBy = "postEntities")
    private Set<SampleEntity> sampleEntities;

}
