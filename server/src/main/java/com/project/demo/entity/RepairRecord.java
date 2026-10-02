package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 报修记录：(RepairRecord)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RepairRecord")
public class RepairRecord implements Serializable {

    // RepairRecord编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_record_id")
    private Integer repair_record_id;

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
    // 故障描述
    @Basic
    private String fault_description;
    // 维修员编号
    @Basic
    private Integer maintenance_personnel_number;
    // 维修员姓名
    @Basic
    private String name_of_maintenance_personnel;
    // 维修时间
    @Basic
    private Timestamp repair_time;
    // 维修情况
    @Basic
    private String maintenance_status;
    // 标注说明
    @Basic
    private String annotation_notes;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
