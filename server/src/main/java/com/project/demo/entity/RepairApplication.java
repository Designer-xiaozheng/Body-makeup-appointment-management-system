package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 报修申请：(RepairApplication)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RepairApplication")
public class RepairApplication implements Serializable {

    // RepairApplication编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_application_id")
    private Integer repair_application_id;

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
    // 上报时间
    @Basic
    private Timestamp reporting_time;
    // 故障描述
    @Basic
    private String fault_description;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
