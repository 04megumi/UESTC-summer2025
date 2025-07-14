package com.uestc.summer2025.data.entity;

import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serial;

/**
 * 管理员信息表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@TableName("AdminInfo")
public class AdminInfo extends CommonBaseEntity<AdminInfo> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 管理员ID（UUID，主键）
    private String adminId;

    // 加密密码
    @NonNull
    private String password;

    // 管理员真实姓名
    @NonNull
    private String fullName;

    // 联系电话
    private String phone;

    // 邮箱
    private String email;

    // 州级考试院ID（外键）
    @NonNull
    private String examCenterName;

}