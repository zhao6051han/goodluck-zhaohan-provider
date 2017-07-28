package com.bw.bean;

import lombok.Data;

/**
 * Created by 赵翰 on 2017/7/28.
 */
@Data
public class MongoDBLogger {
    private int id;
    private String URL;
    private String HTTP_METHOD;
    private String IP;
    private String CLASS_METHOD;
    private String ARGS;
}
