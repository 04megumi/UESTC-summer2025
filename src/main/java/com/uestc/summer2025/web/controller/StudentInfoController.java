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

@RestController
@RequestMapping("/student-info")
public class StudentInfoController {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

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
