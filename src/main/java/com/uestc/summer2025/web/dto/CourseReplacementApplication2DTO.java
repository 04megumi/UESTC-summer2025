package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * DTO 类
 * 课程替换申请 - 管理员端
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseReplacementApplication2DTO {

    // 申请ID，必填，用于唯一定位要审批的申请
    @NonNull
    private Long applicationId;

    // 审核状态，必填，例如“待审核”、“通过”、“驳回”
    @NonNull
    private String status;

    // 审核管理员姓名（方便日志记录和权限校验，可选）
    private String adminName;

    // 审核意见或驳回原因
    private String reviewReason;
}
