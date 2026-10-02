package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 申请换寝：(ApplyForAChangeOfBed)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ApplyForAChangeOfBed")
public class ApplyForAChangeOfBed implements Serializable {

    // ApplyForAChangeOfBed编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apply_for_a_change_of_bed_id")
    private Integer apply_for_a_change_of_bed_id;

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
    // 申请时间
    @Basic
    private Timestamp application_time;
    // 申请原因
    @Basic
    private String reason_for_application;



    // 审核状态
    @Basic
    private String examine_state;








    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
