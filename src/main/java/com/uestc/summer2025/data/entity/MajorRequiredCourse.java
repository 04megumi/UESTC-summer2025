package com.uestc.summer2025.data.entity;

import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serial;

/**
 * 专业毕业所需课程表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("MajorRequiredCourse")
public class MajorRequiredCourse extends CommonBaseEntity<MajorRequiredCourse> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 主键id，自增
    private Long id;

    // 专业代码（外键）
    @NonNull
    private String majorCode;

    // 课程代码（外键）
    @NonNull
    private String courseCode;

    // 是否为毕业必修课程（1 是，0 否），默认1
    private Boolean requiredToGraduate;

}