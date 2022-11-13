package com.cjj.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MybatisplusHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createDate", LocalDateTime.now(), metaObject);
        setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
        setFieldValByName("version",1,metaObject);
        setFieldValByName("isDeleted",0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateDate", LocalDateTime.now(), metaObject);
    }
}
