package com.tensquare.qa.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_pl")
@Data
public class pl implements Serializable {

    @Id
    @Column(name = "problemid")
    private String problemId; //问题id
    @Id
    @Column(name = "labelid")
    private String labelId; //标签id
}
