package com.uestc.summer2025.data.entity;

import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.Serial;
import java.time.LocalDate;

/**
 * 考生信息表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("StudentInfo")
public class StudentInfo extends CommonBaseEntity<StudentInfo> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 考籍号（主键）
    @NonNull
    private String studentId;

    // 姓名
    @NonNull
    private String name;

    // 身份证号（唯一）
    @NonNull
    private String idNumber;

    // 加密后的密码
    @NonNull
    private String password;

    // 报考专业代码（外键）
    @NonNull
    private String majorCode;

    // 州级考试院ID（外键）
    private String examCenterName;

    // 性别
    private String gender = "男";  // 默认值为“男”

    // 出生日期
    private LocalDate birthDate;

    // 联系电话
    private String phone;

    // 通讯地址
    private String address;
}