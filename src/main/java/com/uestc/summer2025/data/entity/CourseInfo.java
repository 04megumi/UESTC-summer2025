package com.uestc.summer2025.data.entity;

import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * 课程信息表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("CourseInfo")
public class CourseInfo extends CommonBaseEntity<CourseInfo> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 课程代码（主键）
    @NonNull
    private String courseCode;

    // 课程名称
    @NonNull
    private String name;

    // 课程类型（ENUM: '必修', '选修'）
    @NonNull
    private String type;

    // 课程学分
    @NonNull
    private BigDecimal credit;

    // 是否实践课（1 是，0 否）
    private Boolean isPractical;

    // 课程简介
    private String description;

}