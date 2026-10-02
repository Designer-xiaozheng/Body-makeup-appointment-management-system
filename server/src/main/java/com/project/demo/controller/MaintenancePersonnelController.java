package com.project.demo.controller;

import com.project.demo.entity.MaintenancePersonnel;
import com.project.demo.service.MaintenancePersonnelService;
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
 * 维修员：(MaintenancePersonnel)表控制层
 *
 */
@RestController
@RequestMapping("/maintenance_personnel")
public class MaintenancePersonnelController extends BaseController<MaintenancePersonnel, MaintenancePersonnelService> {

    /**
     * 维修员对象
     */
    @Autowired
    public MaintenancePersonnelController(MaintenancePersonnelService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapmaintenance_personnel_number = new HashMap<>();
        mapmaintenance_personnel_number.put("maintenance_personnel_number",String.valueOf(paramMap.get("maintenance_personnel_number")));
        List listmaintenance_personnel_number = service.select(mapmaintenance_personnel_number, new HashMap<>()).getResultList();
        if (listmaintenance_personnel_number.size()>0){
            return error(30000, "字段维修员编号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
