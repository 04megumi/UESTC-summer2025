package com.uestc.summer2025.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO 类
 * 登陆信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPageDTO {

    private String key;

    private Integer pageNum;

    private Integer pageSize;
}
