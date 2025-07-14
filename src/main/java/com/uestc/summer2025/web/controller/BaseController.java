package com.uestc.summer2025.web.controller;

import com.uestc.summer2025.data.entity.CourseInfo;
import com.uestc.summer2025.data.entity.ExamCenter;
import com.uestc.summer2025.data.entity.MajorInfo;
import com.uestc.summer2025.service.CacheService;
import com.uestc.summer2025.util.R;
import com.uestc.summer2025.web.vo.CourseInfoVO;
import com.uestc.summer2025.web.vo.MajorInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BaseController {

    @Autowired
    CacheService cacheService;

    public MajorInfoVO majorToVO(MajorInfo majorInfo) {
        MajorInfoVO majorInfoVO = new MajorInfoVO();
        majorInfoVO.setMajorCode(majorInfo.getCode());
        majorInfoVO.setMajorName(majorInfo.getName());
        return majorInfoVO;
    }

    public CourseInfoVO courseToVO(CourseInfo courseInfo) {
        CourseInfoVO courseInfoVO = new CourseInfoVO();
        courseInfoVO.setCourseId(courseInfo.getCourseCode());
        courseInfoVO.setCourseName(courseInfo.getName());
        return courseInfoVO;
    }

    /**
     * 获取所有课程信息（VO 格式）
     * 接口 URL: GET /get-courses
     * 描述：
     * 从 Redis 缓存中获取所有课程的基本信息，并转换为 CourseInfoVO 列表返回前端。
     * 返回值示例：
     * {
     *   "code": 100000,
     *   "msg": null,
     *   "data": [
     *     {
     *       "courseId": "CS101",
     *       "courseName": "数据结构"
     *     },
     *     ...
     *   ]
     * }
     */
    @GetMapping("/get-courses")
    public R<List<CourseInfoVO>> courseListToVO() {
        try {
            List<CourseInfo> courseInfos = cacheService.getAllCourses();
            List<CourseInfoVO> courseInfoVOList = courseInfos.stream().map(this::courseToVO).toList();
            return R.success(courseInfoVOList);
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 获取所有专业信息（VO 格式）
     * 接口 URL: GET /get-majors
     * 描述：
     * 从 Redis 缓存中获取所有专业的基本信息，并转换为 MajorInfoVO 列表返回前端。
     * 返回值示例：
     * {
     *   "code": 100000,
     *   "msg": null,
     *   "data": [
     *     {
     *       "majorCode": "CS001",
     *       "majorName": "计算机科学与技术"
     *     },
     *     ...
     *   ]
     * }
     */
    @GetMapping("/get-majors")
    public R<List<MajorInfoVO>> majorListToVO() {
        try {
            List<MajorInfo> majorInfos = cacheService.getAllMajors(); // 从缓存获取所有专业信息
            List<MajorInfoVO> majorInfoVOList = majorInfos.stream()
                    .map(this::majorToVO)
                    .toList();
            return R.success(majorInfoVOList);
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 获取所有考试院名称列表
     * 接口 URL: GET /get-examCenters
     * 功能说明:
     * 从缓存中获取所有考试院实体，并提取其名称字段，返回考试院名称列表。
     * 常用于下拉框等前端展示用途。
     *
     * 返回示例:
     * {
     *   "code": 100000,
     *   "msg": null,
     *   "data": [
     *     "四川省教育考试院",
     *     "成都市招考办",
     *     "自贡市招生办公室"
     *   ]
     * }
     *
     * @return R<List<String>> 考试院名称列表的响应包装类
     */
    @GetMapping("/get-examCenters")
    public R<List<String>> examCentersToVO() {
        try {
            List<ExamCenter> examCenters = cacheService.getAllExamCenters();
            List<String> examCenterNames = examCenters.stream().map(ExamCenter::getExamCenterName).toList();
            return R.success(examCenterNames);
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }
}
