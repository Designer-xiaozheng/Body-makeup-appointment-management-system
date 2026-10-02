package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 迁出记录：(MigrationRecords)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MigrationRecords")
public class MigrationRecords implements Serializable {

    // MigrationRecords编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "migration_records_id")
    private Integer migration_records_id;

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
    // 迁出时间
    @Basic
    private Timestamp relocation_time;
    // 迁出原因
    @Basic
    private String reason_for_moving_out;
    // 迁往详情
    @Basic
    private String relocation_details;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
