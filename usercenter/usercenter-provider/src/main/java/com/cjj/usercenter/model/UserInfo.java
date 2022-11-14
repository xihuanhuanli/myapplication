package com.cjj.usercenter.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author cjj
 * @since 2022-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_info")
public class UserInfo extends Model<UserInfo> {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("userid")
    private Integer userid;

    @TableField("roles")
    private String roles;

    @TableField("name")
    private String name;

    @TableField("avatar")
    private String avatar;

    @TableField("introduction")
    private String introduction;



    @TableField(value = "creat_date" ,fill= FieldFill.INSERT)
    private LocalDateTime creatDate;

    @TableField("creat_by")
    private Integer creatBy;

    @TableField(value = "update_date",fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    @TableField("update_by")
    private Integer updateBy;

    @TableField(value = "is_deleted",fill= FieldFill.INSERT)
    private Integer isDeleted;

    @TableField(value = "version",fill = FieldFill.INSERT)
    private Integer version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
