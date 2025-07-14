package com.uestc.summer2025.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uestc.summer2025.data.entity.*;
import com.uestc.summer2025.data.mapper.*;
import com.uestc.summer2025.util.R;
import com.uestc.summer2025.web.dto.AdminRegisterDTO;
import com.uestc.summer2025.web.dto.LogInDTO;
import com.uestc.summer2025.web.dto.StudentRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

/**
 * 通用登录与注册控制器
 * 提供管理员与考生的登录与注册接口
 *
 * author: 魏子越
 * date: 2025/07/14
 */
@RestController
@RequestMapping("/")
public class CommonController {

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Autowired
    AdminInfoMapper adminInfoMapper;

    @Autowired
    MajorInfoMapper majorInfoMapper;

    @Autowired
    CourseInfoMapper courseInfoMapper;

    @Autowired
    ExamCenterMapper examCenterMapper;

    /**
     * 用户登录接口（支持考生与管理员）
     * <p>
     * 接口 URL: POST /login
     * 请求体示例:
     * {
     *   "name": "用户名",
     *   "password": "密码"
     * }
     * </p>
     * 返回值:
     * - 登录成功: "学生" 或 "管理员"
     * - 登录失败: 错误信息
     */
    @PostMapping("/login")
    public R<Object> logIn(@RequestBody LogInDTO dto) {
        String name = dto.getName(), password = dto.getPassword();
        QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        StudentInfo studentInfo = studentInfoMapper.selectOne(queryWrapper);
        QueryWrapper<AdminInfo> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("full_name",name);
        AdminInfo adminInfo = adminInfoMapper.selectOne(queryWrapper1);
        if (studentInfo!=null) {
            return Objects.equals(studentInfo.getPassword(), password) ? R.success("学生") : R.failed("密码错误");
        } else if (adminInfo!=null) {
            return Objects.equals(adminInfo.getPassword(), password) ? R.success("管理员") : R.failed("密码错误");
        }  else {
            return R.failed("该用户不存在");
        }
    }

    /**
     * 学生注册接口
     * <p>
     * 接口 URL: POST /register-student
     * 请求体参数见 {@link StudentRegisterDTO}
     * 返回值:
     * - 注册成功: "学生注册成功"
     * - 注册失败: 错误提示（如考试院/专业不存在）
     * </p>
     */
    @PostMapping("/register-student")
    public R<Object> registerStudent(@RequestBody StudentRegisterDTO studentRegisterDTO) {
        try {
            // 生成学生ID，假设使用 UUID 生成学生唯一ID
            String studentId = UUID.randomUUID().toString();
            // 创建 StudentInfo 实体并填充数据
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStudentId(studentId);
            studentInfo.setName(studentRegisterDTO.getName());
            studentInfo.setIdNumber(studentRegisterDTO.getIdNumber());
            studentInfo.setPassword(studentRegisterDTO.getPassword());  // 注意：此处密码应该加密保存，真实生产环境中不要直接保存明文密码
            studentInfo.setMajorCode(studentRegisterDTO.getMajorCode());
            studentInfo.setExamCenterName(studentRegisterDTO.getExamCenterName());
            studentInfo.setGender(studentRegisterDTO.getGender());
            studentInfo.setBirthDate(studentRegisterDTO.getBirthDate());
            studentInfo.setPhone(studentRegisterDTO.getPhone());
            studentInfo.setAddress(studentRegisterDTO.getAddress());
            // 调用 service 层保存数据
            int result = studentInfoMapper.insert(studentInfo);
            // 根据保存结果返回成功或失败的响应
            if (result>0) {
                return R.success("学生注册成功");
            } else {
                return R.failed("学生重复注册");
            }
        } catch (Exception e) {
            return R.failed("检查考试院，专业信息");
        }
    }


    /**
     * 管理员注册接口
     * <p>
     * 接口 URL: POST /register-admin
     * 请求体参数见 {@link AdminRegisterDTO}
     * 返回值:
     * - 注册成功: "管理员注册成功"
     * - 注册失败: 错误提示（如考试院信息错误）
     * </p>
     */
    @PostMapping("/register-admin")
    public R<Object> registerAdmin(@RequestBody AdminRegisterDTO adminRegisterDTO) {
        try {
            // 生成管理员ID，假设使用 UUID 生成唯一管理员ID
            String adminId = UUID.randomUUID().toString();
            // 创建 AdminInfo 实体并填充数据
            AdminInfo adminInfo = new AdminInfo();
            adminInfo.setAdminId(adminId);
            adminInfo.setPassword(adminRegisterDTO.getPassword()); // 注意：密码应进行加密存储，生产环境中不能存储明文密码
            adminInfo.setFullName(adminRegisterDTO.getFullName());
            adminInfo.setPhone(adminRegisterDTO.getPhone());
            adminInfo.setEmail(adminRegisterDTO.getEmail());
            adminInfo.setExamCenterName(adminRegisterDTO.getExamCenterName());
            // 调用 Mapper 层保存数据
            int result = adminInfoMapper.insert(adminInfo);
            // 根据保存结果返回成功或失败的响应
            if (result > 0) {
                return R.success("管理员注册成功");
            } else {
                return R.failed("管理员注册失败");
            }
        } catch (Exception e) {
            return R.failed("检查考试院信息");
        }
    }

    /**
     * 获取专业数量（未被逻辑删除）
     *
     * 接口路径：GET /numOfMajor
     * 请求方式：GET
     * 响应示例：
     * {
     *   "code": 100000,
     *   "msg": "success",
     *   "data": 15
     * }
     *
     * @return 专业数量
     */
    @GetMapping("/numOfMajor")
    public R<Integer> numOfMajors() {
        try {
            QueryWrapper<MajorInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("is_deleted", 0);
            int count = majorInfoMapper.selectCount(wrapper);
            return R.success(count);
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 获取课程数量（未被逻辑删除）
     *
     * 接口路径：GET /numOfCourse
     * 请求方式：GET
     * 响应示例：
     * {
     *   "code": 100000,
     *   "msg": "success",
     *   "data": 120
     * }
     *
     * @return 课程数量
     */
    @GetMapping("/numOfCourse")
    public R<Integer> numOfCourse() {
        try {
            QueryWrapper<CourseInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("is_deleted", 0);
            int count = courseInfoMapper.selectCount(wrapper);
            return R.success(count);
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 获取考试院数量（未被逻辑删除）
     *
     * 接口路径：GET /numOfExamCenters
     * 请求方式：GET
     * 响应示例：
     * {
     *   "code": 100000,
     *   "msg": "success",
     *   "data": 8
     * }
     *
     * @return 考试院数量
     */
    @GetMapping("/numOfExamCenters")
    public R<Integer> numOfExamCenters() {
        try {
            QueryWrapper<ExamCenter> wrapper = new QueryWrapper<>();
            wrapper.eq("is_deleted", 0);
            int count = examCenterMapper.selectCount(wrapper);
            return R.success(count);
        } catch (Exception e) {
            return R.failed(e.getMessage());
        }
    }

    /**
     * 查询学生总数
     *
     * 接口 URL: GET /student-info/countStudent
     * 返回值: 学生总数量
     */
    @GetMapping("/countStudent")
    public R<Integer> countStudents() {
        try {
            QueryWrapper<StudentInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("is_deleted", 0);
            int count = studentInfoMapper.selectCount(wrapper);
            return R.success(count);
        } catch (Exception e) {
            return R.failed("查询学生总数失败：" + e.getMessage());
        }
    }

    /**
     * 查询男生数量
     *
     * 接口 URL: GET /student-info/count-male
     * 返回值: 男生数量
     */
    @GetMapping("/count-male")
    public R<Integer> countMaleStudents() {
        try {
            QueryWrapper<StudentInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("is_deleted", 0).eq("gender", "男");
            int count = studentInfoMapper.selectCount(wrapper);
            return R.success(count);
        } catch (Exception e) {
            return R.failed("查询男生数量失败：" + e.getMessage());
        }
    }

    /**
     * 查询管理员总数
     *
     * 接口 URL: GET /admin-info/count
     * 返回值: 管理员总数量
     */
    @GetMapping("/admin-info/count")
    public R<Integer> countAdmins() {
        try {
            QueryWrapper<AdminInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("is_deleted", 0);
            int count = adminInfoMapper.selectCount(wrapper);
            return R.success(count);
        } catch (Exception e) {
            return R.failed("查询管理员总数失败：" + e.getMessage());
        }
    }
}
