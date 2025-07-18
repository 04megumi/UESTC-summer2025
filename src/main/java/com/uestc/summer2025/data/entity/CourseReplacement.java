package com.uestc.summer2025.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serial;
import java.time.LocalDate;

/**
 * 课程替换表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("CourseReplacement")
public class CourseReplacement extends CommonBaseEntity<CourseReplacement> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 被替换的旧课程代码
    @NonNull
    @TableField("old_course_code")
    private String oldCourseCode;

    // 替代的新课程代码
    @NonNull
    @TableField("new_course_code")
    private String newCourseCode;

    // 适用专业代码（可为空，通用替换)
    @NonNull
    @TableField("major_code")
    private String majorCode;

    // 生效起始日期
    @TableField("effective_from")
    private LocalDate effectiveFrom;

    // 生效截止日期
    @TableField("effective_to")
    private LocalDate effectiveTo;

    public CourseReplacement(String oldCourseCode, String newCourseCode, String majorCode, boolean isDeleted) {
        this.oldCourseCode = oldCourseCode;
        this.newCourseCode = newCourseCode;
        this.majorCode = majorCode;
        setIsDeleted(isDeleted);
    }
}