package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 学生信息：(StudentInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "StudentInformation")
public class StudentInformation implements Serializable {

    // StudentInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_information_id")
    private Integer student_information_id;

    // 学生编号
    @Basic
    private Integer student_no;
    // 学生姓名
    @Basic
    private String student_name;
    // 性别
    @Basic
    private String gender;
    // 班级名称
    @Basic
    private String class_name;
    // 寝室名称
    @Basic
    private String name_of_dormitory;
    // 所在楼宇
    @Basic
    private String located_in_the_building;
    // 宿管编号
    @Basic
    private Integer housing_management_number;
    // 宿管姓名
    @Basic
    private String name_of_accommodation_manager;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
