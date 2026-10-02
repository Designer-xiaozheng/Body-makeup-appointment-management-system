package com.project.demo.controller;

import com.project.demo.entity.DormitoryManagement;
import com.project.demo.service.DormitoryManagementService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 宿舍管理：(DormitoryManagement)表控制层
 *
 */
@RestController
@RequestMapping("/dormitory_management")
public class DormitoryManagementController extends BaseController<DormitoryManagement, DormitoryManagementService> {

    /**
     * 宿舍管理对象
     */
    @Autowired
    public DormitoryManagementController(DormitoryManagementService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
