package com.uestc.summer2025.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * VO 类
 * 免修申请记录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExemptionApplicationVO {

    // 申请id
    private Long applicationId;

    private String studentId;

    private String adminId;

    private String courseCode;

    private String courseName;

    private Long ruleId;

    private String status;

    // 审核意见或驳回原因
    private String reviewReason;

    private LocalDateTime updateTime;
}
