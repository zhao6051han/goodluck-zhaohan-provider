package com.bw.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 赵翰 on 2017/7/28.
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String username;
    private String pwd;
    private int age;
    private String sex;
    private String hobby;
}
