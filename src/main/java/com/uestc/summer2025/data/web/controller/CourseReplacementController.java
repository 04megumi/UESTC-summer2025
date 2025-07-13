package com.uestc.summer2025.data.web.controller;

import com.uestc.summer2025.data.web.dto.CourseReplacementDTO;
import com.uestc.summer2025.data.web.vo.CourseReplacementVO;
import com.uestc.summer2025.util.R;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 查询所有课程替换记录接口（无分页）
     * GET /course-replacement/list-all
     *
     * @return 返回所有课程替换信息列表
     */
    @GetMapping("/list-all")
    public R<List<CourseReplacementVO>> listAll() {
        List<CourseReplacementVO> courseReplacementVOS = new ArrayList<>();
        return R.success(courseReplacementVOS);
    }

    /**
     * 分页查询课程替换记录接口
     * GET /course-replacement/list
     *
     * 请求参数：
     *  - pageNum (必填) 当前页码，从1开始
     *  - pageSize (必填) 每页记录数
     *
     * 示例：
     * /course-replacement/list?pageNum=1&pageSize=10
     *
     * @param pageNum 当前页码
     * @param pageSize 每页大小
     * @return 返回分页的课程替换信息列表
     */
    @GetMapping("/list")
    public R<List<CourseReplacementVO>> listByPage(@RequestParam int pageNum,
                                                   @RequestParam int pageSize) {
        List<CourseReplacementVO> courseReplacementVOS = new ArrayList<>();
        return R.success(courseReplacementVOS);
    }
}
