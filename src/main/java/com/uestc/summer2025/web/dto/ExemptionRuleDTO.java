package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * DTO 类
 * 免考规则
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExemptionRuleDTO {

    @NonNull
    private Long ruleId;

    @NonNull
    private String name;

    // 规则详细介绍
    private String description;

    // 可免考的课程代码（外键）
    @NonNull
    private String courseName;

}
