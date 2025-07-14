package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * DTO 类
 * 免考申请 管理端
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExemptionApplication2DTO {

    @NonNull
    private Long applicationId;

    @NonNull
    private String status;

    private String adminName;

    private String reviewReason;
}
