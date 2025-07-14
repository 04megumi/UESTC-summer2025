package com.uestc.summer2025.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * VO 类
 * 学生毕业信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraduateVO {

    private String studentName;

    private String studentId;

    private String studentIdNumber;

    private String gender;

    private String examCenterName;

    private String majorId;

    private String majorName;

    private String msg;

    private Integer numOfCourses;

    private Integer numOfCredits;

    private Integer averageScores;

    private List<String> coursesList;
}
