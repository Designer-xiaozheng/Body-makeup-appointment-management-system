package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 公告管理：(AnnouncementManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AnnouncementManagement")
public class AnnouncementManagement implements Serializable {

    // AnnouncementManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_management_id")
    private Integer announcement_management_id;

    // 标题
    @Basic
    private String title;
    // 宿管编号
    @Basic
    private Integer housing_management_number;
    // 宿管姓名
    @Basic
    private String name_of_accommodation_manager;
    // 发布时间
    @Basic
    private Timestamp release_time;
    // 内容详情
    @Basic
    private String content_details;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
