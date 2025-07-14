package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO 类
 * 学生信息修改
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfoChange1DTO {

    private String name;

    private String phone;

    private String address;
}
