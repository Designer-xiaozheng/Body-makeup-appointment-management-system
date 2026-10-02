package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 宿舍管理：(DormitoryManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DormitoryManagement")
public class DormitoryManagement implements Serializable {

    // DormitoryManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dormitory_management_id")
    private Integer dormitory_management_id;

    // 宿舍名称
    @Basic
    private String dormitory_name;
    // 宿舍类型
    @Basic
    private String dormitory_type;
    // 床位数量
    @Basic
    private Integer number_of_beds;
    // 所在楼宇
    @Basic
    private String located_in_the_building;
    // 配套设备
    @Basic
    private String supporting_equipment;
    // 负责宿管
    @Basic
    private Integer responsible_for_dormitory_management;
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
