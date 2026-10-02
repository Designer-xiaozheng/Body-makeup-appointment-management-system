package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 楼宇管理：(BuildingManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "BuildingManagement")
public class BuildingManagement implements Serializable {

    // BuildingManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_management_id")
    private Integer building_management_id;

    // 楼宇名称
    @Basic
    private String building_name;
    // 楼宇类型
    @Basic
    private String building_type;
    // 所在位置
    @Basic
    private String location;
    // 负责宿管
    @Basic
    private Integer responsible_for_dormitory_management;
    // 宿管姓名
    @Basic
    private String name_of_accommodation_manager;
    // 楼宇介绍
    @Basic
    private String building_introduction;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
