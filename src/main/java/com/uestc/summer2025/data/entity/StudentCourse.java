package com.uestc.summer2025.data.entity;

import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.io.Serial;
import java.math.BigDecimal;

/**
 * 学生修课程表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("StudentCourse")
public class StudentCourse extends CommonBaseEntity<StudentCourse> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 主键id，自增
    private Long id;

    // 学生ID（外键）
    @NonNull
    private String studentId;

    // 课程代码（外键）
    @NonNull
    private String courseCode;

    // 成绩，保留两位小数
    private BigDecimal score;

}