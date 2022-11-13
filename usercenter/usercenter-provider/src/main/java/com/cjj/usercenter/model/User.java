package com.cjj.usercenter.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author cjj
 * @since 2022-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User extends Model<User> {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

    @TableField("openId")
    private String openid;

    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    @TableField("create_by")
    private Integer createBy;

    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    @TableField("update_by")
    private Integer updateBy;

    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    private Integer isDeleted;

    @TableField(value = "version", fill = FieldFill.INSERT)
    private Integer version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
