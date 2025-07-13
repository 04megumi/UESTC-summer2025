package com.uestc.summer2025.data.entity;

import com.uestc.summer2025.base.CommonBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import java.io.Serial;

/**
 * 专业信息表实体类
 * 继承基础实体类 CommonBaseEntity，自动包含乐观锁、创建时间等通用字段
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("MajorInfo")
public class MajorInfo extends CommonBaseEntity<MajorInfo> {

    @Serial
    private static final long serialVersionUID = 1L;

    // 专业代码（主键）
    @NonNull
    private String code;

    // 专业名称
    @NonNull
    private String name;

    // 毕业所需学分
    private Double graduateCredit;

}