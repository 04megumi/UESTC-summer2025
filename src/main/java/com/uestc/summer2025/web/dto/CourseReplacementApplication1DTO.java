package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * DTO 类
 * 课程替换申请
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseReplacementApplication1DTO {

    // 申请考生ID（外键）
    @NonNull
    private String studentName;

    // 被替换的旧课程代码（外键）
    @NonNull
    private String oldCourseName;

    // 替代的新课程代码（外键）
    @NonNull
    private String newCourseName;

    // 替换申请理由
    private String reason;
}
