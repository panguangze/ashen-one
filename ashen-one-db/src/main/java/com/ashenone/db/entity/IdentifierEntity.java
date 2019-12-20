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
public class IdentifierEntity extends BaseEntity {
    @Column(length = 30)
    private String name;
    private byte genderType;
    @Column(columnDefinition = "Date")
    private Date birthday;
    private byte idType;
    @Column(length = 30)
    private String idNum;
    @Column(length = 120)
    private String idTypeFirstImg;
    @Column(length = 120)
    private String idTypeSecondImg;
    private int creatUserId;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "identifier_id", referencedColumnName = "id")
    private Set<SampleEntity> sampleEntities;

}
