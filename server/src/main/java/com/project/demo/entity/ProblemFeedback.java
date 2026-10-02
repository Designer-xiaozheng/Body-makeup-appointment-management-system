package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 问题反馈：(ProblemFeedback)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ProblemFeedback")
public class ProblemFeedback implements Serializable {

    // ProblemFeedback编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_feedback_id")
    private Integer problem_feedback_id;

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
    // 宿管编号
    @Basic
    private Integer housing_management_number;
    // 标题
    @Basic
    private String title;
    // 反馈时间
    @Basic
    private Timestamp feedback_time;
    // 问题描述
    @Basic
    private String problem_description;



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
