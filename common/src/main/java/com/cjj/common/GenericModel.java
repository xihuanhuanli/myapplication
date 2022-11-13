package com.cjj.common;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class GenericModel {
    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private int isDeleted;

    private int version;

}
