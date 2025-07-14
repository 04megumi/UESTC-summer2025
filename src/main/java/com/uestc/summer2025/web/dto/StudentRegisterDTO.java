package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

/**
 * 学生注册DTO类
 * 用于接收学生注册时所需的字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegisterDTO {

    // 姓名
    @NonNull
    private String name;

    // 身份证号（唯一）
    @NonNull
    private String idNumber;

    // 加密后的密码
    @NonNull
    private String password;

    // 报考专业代码（外键）
    @NonNull
    private String majorCode;

    // 州级考试院ID（外键）
    @NonNull
    private String examCenterName;

    // 性别
    private String gender = "男";  // 默认值为“男”

    // 出生日期
    private LocalDate birthDate;

    // 联系电话
    private String phone;

    // 通讯地址
    private String address;

}
