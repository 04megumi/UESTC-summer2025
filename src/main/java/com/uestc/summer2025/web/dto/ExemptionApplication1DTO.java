package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO 类
 * 免考申请 学生端
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExemptionApplication1DTO {

    private String studentName;

    private String courseName;

    private String ruleName;
}
