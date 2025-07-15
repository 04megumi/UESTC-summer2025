package com.uestc.summer2025.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * VO 类
 * 学生所修课程
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseVO {

    String courseName;

    String courseCode;

    BigDecimal courseScore;
}
