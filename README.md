# UESTC-summer2025

## 项目名称: TODO
## 日期: 2025.07.11

## 项目说明:
**TODO**  @LZJ
该项目为 UESTC 2025 年暑期实践项目，旨在实现高效、可扩展的后台服务，使用现代化的技术栈（如 Spring Boot、MyBatis-Plus、Redis 和 MySQL）构建。具体任务将根据需求进行迭代与完善。  
项目核心目标是构建一个高性能、低延迟的数据存储与处理平台，并为后续的扩展和高并发场景做出技术准备。

## 项目结构

````bash
```
.
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── uestc
│   │   │           └── summer2025
│   │   │               ├── Summer2025Application.java
│   │   │               ├── base
│   │   │               │   ├── CommonBaseEntity.java
│   │   │               │   └── CommonBaseMapper.java
│   │   │               ├── config
│   │   │               │   ├── MybatisPlusConfig.java
│   │   │               │   ├── MybatisPlusObjectHandler.java
│   │   │               │   ├── RedisConfig.java
│   │   │               │   └── WebConfig.java
│   │   │               ├── constant
│   │   │               │   ├── RedisCacheKeys.java
│   │   │               │   └── StudentConst.java
│   │   │               ├── data
│   │   │               │   ├── entity
│   │   │               │   │   ├── AdminInfo.java
│   │   │               │   │   ├── CourseInfo.java
│   │   │               │   │   ├── CourseReplacement.java
│   │   │               │   │   ├── CourseReplacementApplication.java
│   │   │               │   │   ├── ExamCenter.java
│   │   │               │   │   ├── ExemptionApplication.java
│   │   │               │   │   ├── ExemptionRule.java
│   │   │               │   │   ├── MajorInfo.java
│   │   │               │   │   ├── MajorRequiredCourse.java
│   │   │               │   │   ├── StudentCourse.java
│   │   │               │   │   └── StudentInfo.java
│   │   │               │   ├── mapper
│   │   │               │   │   ├── AdminInfoMapper.java
│   │   │               │   │   ├── CourseInfoMapper.java
│   │   │               │   │   ├── CourseReplacementApplicationMapper.java
│   │   │               │   │   ├── CourseReplacementMapper.java
│   │   │               │   │   ├── ExamCenterMapper.java
│   │   │               │   │   ├── ExemptionApplicationMapper.java
│   │   │               │   │   ├── ExemptionRuleMapper.java
│   │   │               │   │   ├── MajorInfoMapper.java
│   │   │               │   │   ├── MajorRequiredCourseMapper.java
│   │   │               │   │   ├── StudentCourseMapper.java
│   │   │               │   │   └── StudentInfoMapper.java
│   │   │               │   └── repository
│   │   │               │       ├── CourseReplacementRepository.java
│   │   │               │       └── impl
│   │   │               │           └── CourseReplacementRepositoryImpl.java
│   │   │               ├── service
│   │   │               │   ├── CachePreheatService.java
│   │   │               │   ├── CacheService.java
│   │   │               │   ├── CourseReplacementService.java
│   │   │               │   └── TransformService.java
│   │   │               ├── util
│   │   │               │   └── R.java
│   │   │               └── web
│   │   │                   ├── controller
│   │   │                   │   ├── ApplicationController.java
│   │   │                   │   ├── BaseController.java
│   │   │                   │   ├── CommonController.java
│   │   │                   │   ├── CourseReplacementController.java
│   │   │                   │   ├── ExemptionRuleController.java
│   │   │                   │   ├── StudentGraduateController.java
│   │   │                   │   └── StudentInfoController.java
│   │   │                   ├── dto
│   │   │                   │   ├── AdminRegisterDTO.java
│   │   │                   │   ├── CourseReplacementApplication1DTO.java
│   │   │                   │   ├── CourseReplacementApplication2DTO.java
│   │   │                   │   ├── CourseReplacementDTO.java
│   │   │                   │   ├── ExemptionApplication1DTO.java
│   │   │                   │   ├── ExemptionApplication2DTO.java
│   │   │                   │   ├── ExemptionRuleDTO.java
│   │   │                   │   ├── LogInDTO.java
│   │   │                   │   ├── NameDTO.java
│   │   │                   │   ├── StudentInfoChange1DTO.java
│   │   │                   │   ├── StudentInfoChange2DTO.java
│   │   │                   │   ├── StudentInfoChange3DTO.java
│   │   │                   │   ├── StudentPageDTO.java
│   │   │                   │   └── StudentRegisterDTO.java
│   │   │                   └── vo
│   │   │                       ├── CourseInfoVO.java
│   │   │                       ├── CourseReplacementApplicationVO.java
│   │   │                       ├── CourseReplacementVO.java
│   │   │                       ├── ExemptionApplicationVO.java
│   │   │                       ├── ExemptionRuleVO.java
│   │   │                       ├── GraduateVO.java
│   │   │                       ├── GraduateVO2.java
│   │   │                       └── MajorInfoVO.java
│   └── resources
│       ├── application.yml
│       └── migration
│           ├── V10__create_student_course.sql
│           ├── V11__insert_student_course.sql
│           ├── V12__insert_student_info.sql
│           ├── V13__insert_admin_info.sql
│           ├── V14__insert_exemption_application.sql
│           ├── V15__insert_course_replacement_application.sql
│           ├── V1__create_exam_center.sql
│           ├── V2__create_admin_info.sql
│           ├── V3__create_major_info_table.sql
│           ├── V4__create_course_info_table.sql
│           ├── V5__create_student_info_table.sql
│           ├── V6__create_cource_replacement_table.sql
│           ├── V7__create_exemption_rule.sql
│           ├── V8__create_major_required_course_table.sql
│           └── V9__create_operationlog_table.sql
```
````

## 📦 Redis 缓存模块设计（CachePreheatService）

### ✅ 设计目的

为提升系统性能与响应速度，在系统启动时，将以下常用的静态数据预加载进 Redis 缓存中，避免频繁查询数据库。

通过统一的缓存 key 命名规范（见 `RedisCacheKeys` 常量类），实现缓存键值的集中管理与代码解耦。

---

### 🧠 核心类与职责

#### `RedisCacheKeys.java`

> 定义所有缓存 Key 的命名规范（全局静态常量），避免硬编码字符串。

| Key 名称 | 描述 |
|----------|------|
| `course:all` | 所有课程列表（`List<CourseInfo>`） |
| `course:name-to-code` | 课程名 → 课程代码映射（`Hash<String, String>`） |
| `major:all` | 所有专业列表（`List<MajorInfo>`） |
| `major:name-to-code` | 专业名 → 专业代码映射（`Hash<String, String>`） |
| `examCenter:all` | 所有考试院列表（`List<ExamCenter>`） |
| `examCenter:name-to-id` | 考试院名 → ID 映射（`Hash<String, Long>`） |
| `majorRequiredCourse:{majorCode}` | 某专业的必修课程列表（`List<MajorRequiredCourse>`） |

---

#### `CachePreheatService.java`

> 负责在系统启动后，将各类基础数据写入 Redis，作为全局缓存。

**方法：**

```java
@PostConstruct
public void preheatCache() {
    // 1. 缓存所有课程列表和课程名映射
    // 2. 缓存所有专业列表和专业名映射
    // 3. 缓存所有考试院列表和考试院名映射
    // 4. 缓存每个专业对应的必修课程列表（按 majorCode 分组）
}

## 开发环境

- **ORM**: MyBatis-Plus 3.5.5
- **缓存与队列**: Redis
- **Web 框架**: Spring MVC 3.2.4
- **数据库**: MySQL 8.0
- **开发环境**: MacOS
- **部署环境**: Ubuntu/CentOS
- 
## 开发进度与计划

- **第一阶段**: 基础架构搭建（完成）@WZY
- **第二阶段**: Spring配置类，与数据层基类开发 @WZY
- **第三阶段**: 数据模型设计与实现（进行中）@WZY
- **第四阶段**: 服务接口开发与集成（待启动）@WZY


## 使用说明

### 1. 克隆项目

首先，通过 Git 克隆该项目：

```bash
git clone https://github.com/04megumi/UESTC-summer2025.git
```

## 🗃️ 数据库表结构说明（summer2025_dev）

系统共有 **13 张业务表** + **1 张版本管理表（Flyway）**，用于支持学生课程替换、自学考试免考、毕业审核等核心功能。

| 表名 | 描述 |
|------|------|
| `AdminInfo` | 管理员信息表，记录各考试院/系统管理员账号数据 |
| `CourseInfo` | 课程信息表，记录课程名称、代码、学分等基础信息 |
| `CourseReplacement` | 课程顶替规则表，定义原课程与新课程的替换关系（可按专业区分） |
| `CourseReplacementApplication` | 学生提交的课程替换申请记录（待审核或已处理） |
| `ExamCenter` | 考试院信息表，用于区分各学生所属考试机构 |
| `ExemptionApplication` | 免考申请表，记录学生对某些课程的免修申请 |
| `ExemptionRule` | 免考规则表，定义可申请免考的条件（例如资格证书、课程） |
| `flyway_schema_history` | Flyway 自动生成的数据库迁移版本控制表 |
| `MajorInfo` | 专业信息表，记录所有专业的代码、名称等基础信息 |
| `MajorRequiredCourse` | 各专业的毕业必修课程表，用于毕业审核对比 |
| `OperationLog` | 操作日志表，记录所有用户操作记录（如申请、审批） |
| `StudentCourse` | 学生已修课程表，记录课程成绩、是否通过等 |
| `StudentInfo` | 学生信息表，记录学生基础数据（姓名、身份证、所属考试院等） |

---

### 🔄 数据表间关系概览

- 一名学生（`StudentInfo`）可能属于一个考试院（`ExamCenter`）
- 一名学生可提交多个：
    - 课程替换申请（`CourseReplacementApplication`）
    - 免考申请（`ExemptionApplication`）
- 每门课程（`CourseInfo`）可能被替换或作为替代课程（`CourseReplacement`）
- 专业（`MajorInfo`）与必修课程（`MajorRequiredCourse`）是一对多关系
- 所有操作写入 `OperationLog` 用于审计和回溯

---

> 🧠 后续可考虑用数据库 ER 图工具（如 dbdiagram.io / Navicat / PowerDesigner）生成关系图形化文档
> 
### 2. 安装所需软件

- **JDK**: 本项目需要 JDK 17 及以上版本。可以从 [Oracle 官方网站](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) 或者 [OpenJDK 官网](https://openjdk.java.net/) 获取。

- **MySQL**: 项目使用 MySQL 8.0。确保 MySQL 已正确安装并且运行。你可以通过 [MySQL 官方网站](https://dev.mysql.com/downloads/) 下载并安装。

- **Redis**: 项目需要 Redis。可以通过 [Redis 官网](https://redis.io/download) 获取 Redis。

### 3. 配置 `application.yml`

1. 打开项目目录中的 `src/main/resources/application.yml` 文件。

2. 修改数据库连接和 Redis 配置中的密码。例如：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/修改为你的数据库名称?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    password: your_database_password   # 修改为你的数据库密码
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
```

## 4. 启动 `Summer2025Application.java`

确保你已经完成了以下步骤：

1. **完成软件安装**：确保安装了 JDK 17 及以上版本、MySQL 8.0 和 Redis。
2. **修改配置文件**：完成了 `application.yml` 文件中的数据库和密码配置。

接下来，你可以启动 Spring Boot 项目：
