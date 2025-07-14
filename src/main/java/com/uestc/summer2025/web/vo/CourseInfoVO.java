package com.uestc.summer2025.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VO 类
 * 课程表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfoVO {

    private String courseId;

    private String courseName;
}
