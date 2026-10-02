package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 缺寝登记：(LackOfBedRegistration)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "LackOfBedRegistration")
public class LackOfBedRegistration implements Serializable {

    // LackOfBedRegistration编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lack_of_bed_registration_id")
    private Integer lack_of_bed_registration_id;

    // 学生编号
    @Basic
    private Integer student_no;
    // 学生姓名
    @Basic
    private String student_name;
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
    // 缺寝时间
    @Basic
    private Timestamp lack_of_sleep_time;
    // 缺寝原因
    @Basic
    private String reasons_for_lack_of_sleep;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
