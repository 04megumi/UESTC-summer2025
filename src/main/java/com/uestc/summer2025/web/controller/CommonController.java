package com.uestc.summer2025.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uestc.summer2025.data.entity.AdminInfo;
import com.uestc.summer2025.data.entity.StudentInfo;
import com.uestc.summer2025.data.mapper.AdminInfoMapper;
import com.uestc.summer2025.data.mapper.StudentInfoMapper;
import com.uestc.summer2025.util.R;
import com.uestc.summer2025.web.dto.AdminRegisterDTO;
import com.uestc.summer2025.web.dto.LogInDTO;
import com.uestc.summer2025.web.dto.StudentRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class CommonController {

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Autowired
    AdminInfoMapper adminInfoMapper;

    /**
     * DTO 类
     * 登录信息
     * <p>
     * 前端发送的请求体格式如下：
     * {
     *   "name": "用户名",    // 用户名
     *   "password": "密码"   // 密码
     * }
     * </p>
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
     *  参数定义见 web/dto
     *
     * @param studentRegisterDTO
     * @return R<Object>
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
     *  参数定义见 web/dto
     *
     * @param adminRegisterDTO
     * @return R<Object></Object>
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

}
