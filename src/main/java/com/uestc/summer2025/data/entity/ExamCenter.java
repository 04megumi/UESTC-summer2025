package com.uestc.summer2025.data.entity;

import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import java.io.Serial;

/**
 * 州级考试院信息表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ExamCenter")
public class ExamCenter extends CommonBaseEntity<ExamCenter> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 考试院ID（UUID，主键）
    private String examCenterId;

    // 考试院名称
    @NonNull
    private String examCenterName;

    // 所属省的代码
    @NonNull
    private String stateCode;

    // 所属省的名称
    @NonNull
    private String stateName;

    // 考试院地址
    private String address;

    // 联系电话
    private String phone;

    // 电子邮箱
    private String email;

}