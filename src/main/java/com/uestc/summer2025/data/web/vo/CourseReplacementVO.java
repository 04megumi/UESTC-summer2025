package com.uestc.summer2025.data.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

/**
 * VO 类
 * 课程替换记录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseReplacementVO {

    @NonNull
    private String oldCourseName;

    @NonNull
    private String newCourseName;

    @NonNull
    private String oldCourseCode;

    @NonNull
    private String newCourseCode;

    @NonNull
    private String majorName;
}
