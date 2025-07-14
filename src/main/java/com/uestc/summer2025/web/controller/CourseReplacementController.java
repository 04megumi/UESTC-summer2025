package com.uestc.summer2025.web.controller;

import com.uestc.summer2025.service.CourseReplacementService;
import com.uestc.summer2025.web.dto.CourseReplacementDTO;
import com.uestc.summer2025.web.vo.CourseReplacementVO;
import com.uestc.summer2025.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-replacement")
public class CourseReplacementController {

    @Autowired
    private CourseReplacementService courseReplacementService;

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
        try {
            return courseReplacementService.addCourseReplacement(dto) ? R.success() : R.failed();
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
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
        try {
            return courseReplacementService.deleteCourseReplacement(dto) ? R.success() : R.failed();
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 查询所有课程替换记录接口（无分页）
     * GET /course-replacement/list-all
     *
     * @return 返回所有课程替换信息列表
     */
    @GetMapping("/list-all")
    public R<List<CourseReplacementVO>> listAll() {
        try {
            return R.success(courseReplacementService.loadAllCourseReplacementVO());
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

}
