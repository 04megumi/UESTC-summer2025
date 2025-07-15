package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO 类
 * 修改学生成绩
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseDTO {

    String studentName;

    String courseName;

    BigDecimal score;
}
