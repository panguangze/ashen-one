package com.ashenone.db.entity;

import com.ashenone.db.base.BaseRecord;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@ToString
@Entity
@AllArgsConstructor
public class OperationRecord extends BaseRecord {
    @Column(length = 30)
    private String operateInterface;
    @Column(length = 30)
    private String interfaceMessage;
    private String ip;
    private String parameters;
}
