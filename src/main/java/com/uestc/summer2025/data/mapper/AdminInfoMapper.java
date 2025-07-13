package com.uestc.summer2025.data.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uestc.summer2025.data.entity.AdminInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员信息表 Mapper
 * 继承 MyBatis-Plus 的 BaseMapper 接口，自动获得 CRUD 操作
 *
 * author: 魏子越
 * date: 2025/07/13
 */
@Mapper
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {

}