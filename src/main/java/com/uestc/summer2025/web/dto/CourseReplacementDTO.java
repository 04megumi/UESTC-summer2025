package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

/**
 * DTO 类
 * 课程替换信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseReplacementDTO {

    private String oldCourseName;

    private String newCourseName;

    private String majorName;

    private LocalDate effectiveFrom;

    private LocalDate effectiveTo;
}
