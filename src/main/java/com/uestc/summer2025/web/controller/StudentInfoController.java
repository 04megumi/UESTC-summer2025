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

@RestController
@RequestMapping("/student-info")
public class StudentInfoController {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @PostMapping("/loadByIdNumber")
    public R<StudentInfo> loadByIdNumber(@RequestBody String idNumber) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id_number", idNumber)
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectOne(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    @PostMapping("/loadByName")
    public R<StudentInfo> loadByName(@RequestBody String name) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", name)
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectOne(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    @PostMapping("/loadByMajor")
    public R<List<StudentInfo>> loadByMajor(@RequestBody String major) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("major", major)
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectList(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    @PostMapping("/loadByGender")
    public R<List<StudentInfo>> loadByGender(@RequestBody String gender) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("gender", gender)
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectList(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    @PostMapping("/loadByExamCenterName")
    public R<List<StudentInfo>> loadByExam(@RequestBody String examCenterName) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("exam_center_name", examCenterName)
                    .eq("is_deleted", 0);
            return R.success(studentInfoMapper.selectList(queryWrapper));
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }
}
