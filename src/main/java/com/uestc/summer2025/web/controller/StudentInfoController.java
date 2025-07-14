package com.uestc.summer2025.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uestc.summer2025.data.entity.StudentInfo;
import com.uestc.summer2025.data.mapper.ExemptionApplicationMapper;
import com.uestc.summer2025.data.mapper.StudentInfoMapper;
import com.uestc.summer2025.service.TransformService;
import com.uestc.summer2025.util.R;
import com.uestc.summer2025.web.dto.StudentInfoChange1DTO;
import com.uestc.summer2025.web.dto.StudentInfoChange2DTO;
import com.uestc.summer2025.web.dto.StudentPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 学生信息接口控制器
 * 提供根据不同字段查询考生信息的接口
 *
 * author: 魏子越
 * date: 2025/07/14
 */
@RestController
@RequestMapping("/student-info")
public class StudentInfoController {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Autowired
    private TransformService transformService;

    @Autowired
    private ExemptionApplicationMapper exemptionApplicationMapper;

    /**
     * 根据学生ID查询学生信息
     *
     * 接口 URL: POST /student-info/loadById
     * 请求参数: {"key": "学生ID"}
     * 返回值: 单个学生信息对象
     */
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

    /**
     * 根据身份证号查询学生信息
     *
     * 接口 URL: POST /student-info/loadByIdNumber
     * 请求参数: {"key": "身份证号"}
     * 返回值: 单个学生信息对象
     */
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

    /**
     * 根据学生姓名查询学生信息
     *
     * 接口 URL: POST /student-info/loadByName
     * 请求参数: {"key": "学生姓名"}
     * 返回值: 单个学生信息对象
     */
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

    /**
     * 根据专业名称分页查询学生列表
     *
     * 接口 URL: POST /student-info/pageByMajor
     * 请求参数:
     * {
     *   "key": "专业名称",
     *   "pageNum": 1,
     *   "pageSize": 10
     * }
     * 返回值: 分页的学生信息列表
     */
    @PostMapping("/pageByMajor")
    public R<Page<StudentInfo>> loadByMajor(@RequestBody StudentPageDTO params) {
        try {
            String major = params.getKey();
            String major_code = transformService.majorNameToId(major);
            int pageNum = params.getPageNum();
            int pageSize = params.getPageSize();

            Page<StudentInfo> page = new Page<>(pageNum, pageSize);
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("major_code", major_code).eq("is_deleted", 0);

            return R.success(studentInfoMapper.selectPage(page, queryWrapper));
        } catch (Exception e) {
            return R.failed("分页查询失败：" + e.getMessage());
        }
    }

    /**
     * 根据性别分页查询学生列表
     *
     * 接口 URL: POST /student-info/pageByGender
     * 请求参数:
     * {
     *   "key": "男" 或 "女",
     *   "pageNum": 1,
     *   "pageSize": 10
     * }
     * 返回值: 分页的学生信息列表
     */
    @PostMapping("/pageByGender")
    public R<Page<StudentInfo>> loadByGender(@RequestBody StudentPageDTO params) {
        try {
            String gender = params.getKey();
            int pageNum = params.getPageNum();
            int pageSize = params.getPageSize();

            Page<StudentInfo> page = new Page<>(pageNum, pageSize);
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("gender", gender).eq("is_deleted", 0);

            return R.success(studentInfoMapper.selectPage(page, queryWrapper));
        } catch (Exception e) {
            return R.failed("分页查询失败：" + e.getMessage());
        }
    }

    /**
     * 根据考试院名称分页查询学生列表
     *
     * 接口 URL: POST /student-info/pageByExamCenter
     * 请求参数:
     * {
     *   "key": "考试院名称",
     *   "pageNum": 1,
     *   "pageSize": 10
     * }
     * 返回值: 分页的学生信息列表
     */
    @PostMapping("/pageByExamCenter")
    public R<Page<StudentInfo>> loadByExamCenter(@RequestBody StudentPageDTO params) {
        try {
            String center = params.getKey();
            int pageNum = params.getPageNum();
            int pageSize = params.getPageSize();

            Page<StudentInfo> page = new Page<>(pageNum, pageSize);
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("exam_center_name", center).eq("is_deleted", 0);

            return R.success(studentInfoMapper.selectPage(page, queryWrapper));
        } catch (Exception e) {
            return R.failed("分页查询失败：" + e.getMessage());
        }
    }

    /**
     * 分页查询学生信息（可按姓名模糊搜索）
     *
     * 接口 URL: GET /student-info/page
     * 请求参数:
     *   - pageNum: 当前页码（从 1 开始）
     *   - pageSize: 每页条数
     *   - name: （可选）按学生姓名模糊查询
     *
     * 返回值: 分页后的学生信息列表
     */
    @GetMapping("/page")
    public R<Page<StudentInfo>> getStudentsByPage(@RequestParam(defaultValue = "1") int pageNum,
                                                  @RequestParam(defaultValue = "10") int pageSize,
                                                  @RequestParam(required = false) String name) {
        try {
            Page<StudentInfo> page = new Page<>(pageNum, pageSize);
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("is_deleted", 0);
            if (name != null && !name.isEmpty()) {
                queryWrapper.like("name", name);
            }
            Page<StudentInfo> result = studentInfoMapper.selectPage(page, queryWrapper);
            return R.success(result);
        } catch (Exception e) {
            return R.failed("分页查询失败：" + e.getMessage());
        }
    }

    /**
     * 分页查询所有学生信息（不支持模糊匹配）
     *
     * 接口 URL: GET /student-info/page-all
     * 请求参数:
     *   - pageNum: 当前页码（从 1 开始）
     *   - pageSize: 每页条数
     *
     * 返回值: 分页后的学生信息列表
     */
    @GetMapping("/page-all")
    public R<Page<StudentInfo>> getAllStudentsByPage(@RequestParam(defaultValue = "1") int pageNum,
                                                     @RequestParam(defaultValue = "10") int pageSize) {
        try {
            Page<StudentInfo> page = new Page<>(pageNum, pageSize);
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("is_deleted", 0);
            Page<StudentInfo> result = studentInfoMapper.selectPage(page, queryWrapper);
            return R.success(result);
        } catch (Exception e) {
            return R.failed("分页查询失败：" + e.getMessage());
        }
    }

    /**
     * 学生信息修改接口（仅限地址与电话）
     *
     * 请求方式：POST
     * 请求路径：/student-change
     *
     * 请求参数（JSON 格式）：
     * {
     *     "name": "学生姓名",
     *     "address": "新地址",
     *     "phone": "新手机号"
     * }
     *
     * 说明：
     * - 根据学生姓名查找对应记录；
     * - 更新其地址与电话信息；
     * - 若学生不存在，则返回失败响应。
     *
     * @param studentInfoChange1DTO 包含学生姓名、地址、电话的 DTO 对象
     * @return 操作结果的统一响应结构 R
     */
    @PostMapping("/student-change")
    public R<String> student0change(@RequestBody StudentInfoChange1DTO studentInfoChange1DTO) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", studentInfoChange1DTO.getName());
            StudentInfo studentInfo = studentInfoMapper.selectOne(queryWrapper);

            if (studentInfo == null) {
                return R.failed("该学生不存在，无法修改信息");
            }

            studentInfo.setAddress(studentInfoChange1DTO.getAddress());
            studentInfo.setPhone(studentInfoChange1DTO.getPhone());

            System.out.println(studentInfo);

            int rows = studentInfoMapper.updateById(studentInfo);
            if (rows > 0) {
                return R.success("信息修改成功");
            } else {
                return R.failed("信息修改失败");
            }
        } catch (Exception e) {
            return R.failed("信息修改出错：" + e.getMessage());
        }
    }

    /**
     * 学生信息修改接口（修改姓名、身份证号、冻结状态）
     *
     * 请求方式：POST
     * 请求路径：/student-info-update
     *
     * 请求参数（JSON 格式）：
     * {
     *     "name": "原姓名",
     *     "newName": "新姓名",
     *     "numberId": "新身份证号",
     *     "frozened": true,
     *     "isDeleted": true
     * }
     *
     * 说明：
     * - 根据原姓名查找学生；
     * - 修改其姓名、身份证号及是否冻结（frozened）字段；
     * - 若找不到学生，返回失败提示。
     *
     * @param dto 学生信息修改 DTO（含原姓名、新姓名、新身份证号、是否冻结）
     * @return 操作结果的统一响应结构 R
     */
    @PostMapping("/student-info-update")
    public R<String> updateStudentInfo(@RequestBody StudentInfoChange2DTO dto) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", dto.getName());
            StudentInfo studentInfo = studentInfoMapper.selectOne(queryWrapper);

            if (studentInfo == null) {
                return R.failed("该学生不存在，无法修改信息");
            }

            studentInfo.setName(dto.getNewName());
            studentInfo.setIdNumber(dto.getNumberId());
            studentInfo.setFrozened(dto.isFrozened());
            studentInfo.setIsDeleted(dto.isDeleted());

            int rows = studentInfoMapper.updateById(studentInfo);
            if (rows > 0) {
                return R.success("学生信息修改成功");
            } else {
                return R.failed("学生信息修改失败");
            }
        } catch (Exception e) {
            return R.failed("学生信息修改出错：" + e.getMessage());
        }
    }
}
