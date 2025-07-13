package com.uestc.summer2025.data.web.controller;

import com.uestc.summer2025.data.web.dto.CourseReplacementDTO;
import com.uestc.summer2025.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course-replacement")
public class CourseReplacementController {

    /**
     * 课程替换相关接口
     * <p>
     * 接口URL: POST /course-replacement/add
     * <p>
     * 请求示例(JSON):
     * {
     *   "oldCourseName": "数学分析",
     *   "newCourseName": "高等数学",
     *   "majorName": "计算机科学与技术",
     *   "effectiveFrom": "2025-09-01",
     *   "effectiveTo": "2026-06-30"
     * }
     */
    @PostMapping("/add")
    public R<String> addReplacement(@RequestBody CourseReplacementDTO dto) {
        return R.success("Success");
    }

    /**
     * 课程替换相关接口
     * <p>
     * 接口URL: POST /course-replacement/delete
     * <p>
     * 请求示例(JSON):
     * {
     *   "oldCourseName": "数学分析",
     *   "newCourseName": "高等数学",
     *   "majorName": "计算机科学与技术",
     *   "effectiveFrom": "2025-09-01",
     *   "effectiveTo": "2026-06-30"
     * }
     */
    @PostMapping("/delete")
    public R<String> deleteReplacement(@RequestBody CourseReplacementDTO dto) {
        return R.success("Success");
    }
}
