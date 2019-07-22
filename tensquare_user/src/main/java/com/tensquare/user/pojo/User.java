package com.tensquare.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    private String id;
    private String mobile;
    private String password;
    @Column(name = "nickname")
    private String nickName;
    private String sex;
    private Timestamp birthday;
    private String avatar;
    private String email;
    private Timestamp ragdate;
    @Column(name = "updatedate")
    private Timestamp updateDate;
    @Column(name = "lastdate")
    private Timestamp lastDate;
    private Long online;
    private String interest;
    private String personality;
    @Column(name = "fanscount")
    private Integer fansCount;
    @Column(name = "fllowcount")
    private Integer fllowCount;

}
