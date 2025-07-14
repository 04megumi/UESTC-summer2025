package com.uestc.summer2025.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * VO 类
 * 课程替换申请记录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseReplacementApplicationVO {

    // 申请ID
    private Long applicationId;

    // 学生ID
    private String studentId;

    // 旧课程代码
    private String oldCourseCode;

    // 新课程代码
    private String newCourseCode;

    private String oldCourseName;

    private String newCourseName;

    // 申请理由
    private String reason;

    // 状态：待审核、通过、驳回
    private String status;

    // 审核意见
    private String reviewReason;

    // 管理员ID
    private String adminId;

    // 修改时间
    private LocalDateTime updateTime;
}