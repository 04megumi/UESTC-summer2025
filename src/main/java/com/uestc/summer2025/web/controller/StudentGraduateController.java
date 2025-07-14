package com.uestc.summer2025.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uestc.summer2025.data.entity.CourseInfo;
import com.uestc.summer2025.data.entity.MajorInfo;
import com.uestc.summer2025.data.entity.StudentCourse;
import com.uestc.summer2025.data.entity.StudentInfo;
import com.uestc.summer2025.data.mapper.CourseInfoMapper;
import com.uestc.summer2025.data.mapper.MajorInfoMapper;
import com.uestc.summer2025.data.mapper.StudentCourseMapper;
import com.uestc.summer2025.data.mapper.StudentInfoMapper;
import com.uestc.summer2025.service.TransformService;
import com.uestc.summer2025.util.R;
import com.uestc.summer2025.web.vo.GraduateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class StudentGraduateController {

    @Autowired
    private TransformService transformService;

    @Autowired
    StudentCourseMapper studentCourseMapper;

    @Autowired
    MajorInfoMapper majorInfoMapper;

    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Autowired
    CourseInfoMapper courseInfoMapper;

    /**
     * 学生毕业审核接口
     *
     * 请求方式：POST
     * 请求路径：/
     *
     * 请求参数（JSON 格式）：
     * {
     *     "name": "学生姓名"
     * }
     *
     * 说明：仅传入学生姓名（name），用于查询或处理该学生的毕业信息。
     *
     * @param params 包含学生姓名的 Map 参数，例如 {"name": "张三"}
     * @return 返回毕业信息封装对象 GraduateVO，包含统一响应结构 R
     */
    @PostMapping("/graduate")
    public R<GraduateVO> studentGraduate(@RequestBody Map<String, Object> params) {
        try {
            String studentName = params.get("name").toString();
            QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", studentName);
            StudentInfo studentInfo = studentInfoMapper.selectOne(queryWrapper);
            if (studentInfo == null) {
                return R.failed("该学生不存在");
            }

            String majorCode = studentInfo.getMajorCode();
            String majorName = transformService.majorIdToName(majorCode);

            QueryWrapper<MajorInfo> majorQueryWrapper = new QueryWrapper<>();
            majorQueryWrapper.eq("code", majorCode);
            MajorInfo majorInfo = majorInfoMapper.selectOne(majorQueryWrapper);
            if (majorInfo == null) {
                return R.failed("该专业已经取消");
            }

            Double majorGraduateCredit = majorInfo.getGraduateCredit();

            QueryWrapper<StudentCourse> studentCourseWrapper = new QueryWrapper<>();
            studentCourseWrapper.eq("student_id", studentInfo.getStudentId());
            List<StudentCourse> studentCourses = studentCourseMapper.selectList(studentCourseWrapper);

            GraduateVO graduateVO = new GraduateVO();
            graduateVO.setStudentId(studentInfo.getStudentId());
            graduateVO.setGender(studentInfo.getGender());
            graduateVO.setStudentName(studentInfo.getName());
            graduateVO.setStudentIdNumber(studentInfo.getIdNumber());
            graduateVO.setExamCenterName(studentInfo.getExamCenterName());
            graduateVO.setMajorId(studentInfo.getMajorCode());
            graduateVO.setMajorName(majorName);

            // 附加统计字段
            int numOfCourses = 0;
            int numOfCredits = 0;
            int totalScores = 0;
            List<String> coursesList = new ArrayList<>();

            for (StudentCourse studentCourse : studentCourses) {
                QueryWrapper<CourseInfo> courseInfoQueryWrapper = new QueryWrapper<>();
                courseInfoQueryWrapper.eq("course_code", studentCourse.getCourseCode());
                CourseInfo courseInfo = courseInfoMapper.selectOne(courseInfoQueryWrapper);

                numOfCourses += 1;
                numOfCredits += courseInfo.getCredit().intValue();
                coursesList.add(courseInfo.getName());
                totalScores += studentCourse.getScore().intValue();
            }

            int averageScores = numOfCourses == 0 ? 0 : totalScores / numOfCourses;

            graduateVO.setNumOfCourses(numOfCourses);
            graduateVO.setNumOfCredits(numOfCredits);
            graduateVO.setAverageScores(averageScores);

            if (numOfCredits >= majorGraduateCredit) {

                // 设置 msg 毕业寄语
                String msg;
                String examCenterName = studentInfo.getExamCenterName();
                String today = java.time.LocalDate.now().toString();

                if (averageScores >= 90) {
                    msg = String.format("恭喜你以优异成绩顺利毕业！%s 于 %s 祝你前程似锦，未来可期。", examCenterName, today);
                } else if (averageScores >= 75) {
                    msg = String.format("恭喜你毕业！%s 于 %s 向你表示祝贺，希望你继续保持良好状态，追求卓越。", examCenterName, today);
                } else if (averageScores >= 60) {
                    msg = String.format("你已顺利毕业，%s 于 %s 鼓励你不断进步，积跬步以至千里。", examCenterName, today);
                } else {
                    msg = String.format("虽然成绩略有不足，但你仍完成了全部课程。%s 于 %s 鼓励你继续努力，未完待续。", examCenterName, today);
                }

                graduateVO.setMsg(msg);
                graduateVO.setCoursesList(coursesList);

                return R.success(graduateVO);
            } else {
                String examCenterName = studentInfo.getExamCenterName();
                String today = java.time.LocalDate.now().toString();

                String msg = String.format("当前所修学分为 %d，未达到毕业要求的 %.1f 学分。%s 于 %s 鼓励你继续努力，争取早日毕业！",
                        numOfCredits, majorGraduateCredit, examCenterName, today);

                graduateVO.setMsg(msg);
                graduateVO.setCoursesList(coursesList);

                return R.success(graduateVO);
            }
        } catch (Exception e) {
            return R.failed("毕业信息生成失败：" + e.getMessage());
        }
    }
}
