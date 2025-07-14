package com.uestc.summer2025.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uestc.summer2025.data.entity.StudentInfo;
import com.uestc.summer2025.data.mapper.StudentInfoMapper;
import com.uestc.summer2025.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 学生信息接口控制器
 * 提供根据不同字段查询考生信息的接口
 *
 * author: 魏子越
 * date: 2025/07/14
 */
@RestController
@RequestMapping("/student-info")
public class StudentInfoController {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    /**
     * 根据学生ID查询学生信息
     *
     * 接口 URL: POST /student-info/loadById
     * 请求参数: {"key": "学生ID"}
     * 返回值: 单个学生信息对象
     */
    @PostMapping("/loadById")
    public R<StudentInfo> loadById(@RequestBody Map<String, Object> params) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("student_id", params.get("key"))
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectOne(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 根据身份证号查询学生信息
     *
     * 接口 URL: POST /student-info/loadByIdNumber
     * 请求参数: {"key": "身份证号"}
     * 返回值: 单个学生信息对象
     */
    @PostMapping("/loadByIdNumber")
    public R<StudentInfo> loadByIdNumber(@RequestBody Map<String, Object> params) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id_number", params.get("key"))
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectOne(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 根据学生姓名查询学生信息
     *
     * 接口 URL: POST /student-info/loadByName
     * 请求参数: {"key": "学生姓名"}
     * 返回值: 单个学生信息对象
     */
    @PostMapping("/loadByName")
    public R<StudentInfo> loadByName(@RequestBody Map<String, Object> params) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", params.get("key"))
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectOne(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 根据专业代码查询学生列表
     *
     * 接口 URL: POST /student-info/loadByMajor
     * 请求参数: {"key": "专业代码"}
     * 返回值: 学生信息列表
     */
    @PostMapping("/loadByMajor")
    public R<List<StudentInfo>> loadByMajor(@RequestBody Map<String, Object> params) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("major", params.get("key"))
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectList(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 根据性别查询学生列表
     *
     * 接口 URL: POST /student-info/loadByGender
     * 请求参数: {"key": "性别"} // "男" 或 "女"
     * 返回值: 学生信息列表
     */
    @PostMapping("/loadByGender")
    public R<List<StudentInfo>> loadByGender(@RequestBody Map<String, Object> params) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("gender", params.get("key"))
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectList(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 根据考试院名称查询学生列表
     *
     * 接口 URL: POST /student-info/loadByExamCenterName
     * 请求参数: {"key": "考试院名称"}
     * 返回值: 学生信息列表
     */
    @PostMapping("/loadByExamCenterName")
    public R<List<StudentInfo>> loadByExam(@RequestBody Map<String, Object> params) {
        try {
            System.out.println(params);
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("exam_center_name", params.get("key"))
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectList(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }
}
