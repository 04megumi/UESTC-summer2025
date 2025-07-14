package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRegisterDTO {

    // 加密密码
    @NonNull
    private String password;

    // 管理员真实姓名
    @NonNull
    private String fullName;

    // 联系电话
    private String phone;

    // 邮箱
    private String email;

    // 州级考试院ID（外键）
    @NonNull
    private String examCenterName;
}
