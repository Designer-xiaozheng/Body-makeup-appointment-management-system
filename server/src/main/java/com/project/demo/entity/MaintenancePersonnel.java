package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 维修员：(MaintenancePersonnel)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MaintenancePersonnel")
public class MaintenancePersonnel implements Serializable {

    // MaintenancePersonnel编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenance_personnel_id")
    private Integer maintenance_personnel_id;

    // 维修员编号
    @Basic
    private String maintenance_personnel_number;
    // 维修员姓名
    @Basic
    private String name_of_maintenance_personnel;
    // 性别
    @Basic
    private String gender;












    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
