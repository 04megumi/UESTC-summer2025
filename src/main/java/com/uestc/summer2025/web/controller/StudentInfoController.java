package com.uestc.summer2025.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uestc.summer2025.data.entity.StudentCourse;
import com.uestc.summer2025.data.entity.StudentInfo;
import com.uestc.summer2025.data.mapper.StudentCourseMapper;
import com.uestc.summer2025.data.mapper.StudentInfoMapper;
import com.uestc.summer2025.service.TransformService;
import com.uestc.summer2025.util.R;
import com.uestc.summer2025.web.dto.*;
import com.uestc.summer2025.web.vo.StudentCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private StudentCourseMapper studentCourseMapper;


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

    /**
     * 学生信息修改接口（修改姓名、身份证号、冻结状态）
     *
     * 请求方式：POST
     * 请求路径：/student-examCenter-update
     *
     * 请求参数（JSON 格式）：
     * {
     *     "name": "原姓名",
     *     "examCenterName": "考试院名称"
     * }
     *
     * @param dto 学生信息修改 DTO（含原姓名、新姓名、新身份证号、是否冻结）
     * @return 操作结果的统一响应结构 R
     */
    @PostMapping("/student-examCenter-update")
    public R<String> updateStudentExamCenter(@RequestBody StudentInfoChange3DTO dto) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", dto.getName());
            StudentInfo studentInfo = studentInfoMapper.selectOne(queryWrapper);

            if (studentInfo == null) {
                return R.failed("该学生不存在，无法修改信息");
            }

            studentInfo.setExamCenterName(dto.getExamCenterName());

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

    /**
     * 根据学生姓名查询其所修课程信息
     *
     * 请求方式：POST
     * 请求路径：/student-courses
     *
     * 请求参数（JSON）：
     * {
     *     "name": "学生姓名"
     * }
     *
     * 返回值：
     * - 成功：返回该学生的课程列表（List<StudentCourseVO>），每个元素包含课程代码、课程名称、学分等信息。
     * - 失败：返回错误信息，例如找不到该学生或查询异常。
     *
     * 注意事项：
     * - 若学生姓名不存在于系统中，将抛出异常。
     * - 接口使用名称唯一查找学生信息，确保数据库中姓名不重复。
     */
    @PostMapping("/student-courses")
    public R<List<StudentCourseVO>> getStudentCourses(@RequestBody NameDTO nameDTO) {
        try {
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", nameDTO.getName());
            StudentInfo studentInfo = studentInfoMapper.selectOne(queryWrapper);
            String studentId = studentInfo.getStudentId();
            QueryWrapper<StudentCourse> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("student_id", studentId);
            List<StudentCourse> studentCourses = studentCourseMapper.selectList(queryWrapper1);
            List<StudentCourseVO> studentCourseVOList = new ArrayList<>();
            studentCourses.forEach(studentCourse -> studentCourseVOList.add(toVO(studentCourse)));
            return R.success(studentCourseVOList);
        } catch (Exception e) {
            return R.failed("学生成绩查询错误：" + e.getMessage());
        }
    }

    private StudentCourseVO toVO(StudentCourse studentCourse) {
        StudentCourseVO studentCourseVO = new StudentCourseVO();
        studentCourseVO.setCourseCode(studentCourse.getCourseCode());
        studentCourseVO.setCourseScore(studentCourse.getScore());
        studentCourseVO.setCourseName(transformService.courseIdToName(studentCourse.getCourseCode()));
        return studentCourseVO;
    }

    /**
     * 更新学生课程成绩接口
     *
     * 接口路径: POST /update-course
     *
     * 请求参数:
     * - @RequestBody StudentCourseDTO studentCourseDTO
     *   - studentName：学生姓名（用于查询 studentId）
     *   - courseName：课程名称（用于转换为 courseCode）
     *   - score：课程成绩（用于新增或更新成绩）
     *
     * 处理逻辑:
     * 1. 通过学生姓名从 StudentInfo 表中获取 studentId；
     * 2. 使用 transformService 将 courseName 转换为 courseCode；
     * 3. 在 StudentCourse 表中查询是否已有该 studentId + courseCode 的记录；
     *    - 若存在：更新该课程的成绩；
     *    - 若不存在：新增该学生该课程的成绩记录；
     *
     * 返回:
     * - R.success：表示成绩更新或插入成功；
     * - R.failed：若发生异常或学生信息未找到，返回错误提示信息。
     */
    @PostMapping("update-course")
    public R<String> updateStudentCourse(@RequestBody StudentCourseDTO studentCourseDTO) {
        try {
            // 1. 根据学生姓名查找学生信息
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", studentCourseDTO.getStudentName());
            StudentInfo studentInfo = studentInfoMapper.selectOne(queryWrapper);

            if (studentInfo == null) {
                return R.failed("未找到该学生信息");
            }

            String studentId = studentInfo.getStudentId();

            // 2. 课程名称转为课程代码
            String courseCode = transformService.courseNameToId(studentCourseDTO.getCourseName());

            // 3. 查找该学生该课程是否已有成绩记录
            QueryWrapper<StudentCourse> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("student_id", studentId)
                    .eq("course_code", courseCode);

            StudentCourse studentCourse = studentCourseMapper.selectOne(queryWrapper1);

            if (studentCourse == null) {
                // 如果没有，新增一条
                StudentCourse studentCourse1 = new StudentCourse();
                studentCourse1.setStudentId(studentId);
                studentCourse1.setCourseCode(courseCode);
                studentCourse1.setScore(studentCourseDTO.getScore());

                studentCourseMapper.insert(studentCourse1);
            } else {
                // 如果已有，更新成绩
                studentCourse.setScore(studentCourseDTO.getScore());
                studentCourseMapper.updateById(studentCourse);
            }

            return R.success("修改成绩成功");
        } catch (Exception e) {
            return R.failed("学生成绩更新错误：" + e.getMessage());
        }
    }

}
