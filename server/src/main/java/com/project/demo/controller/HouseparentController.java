package com.project.demo.controller;

import com.project.demo.entity.Houseparent;
import com.project.demo.service.HouseparentService;
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
 * 宿管员：(Houseparent)表控制层
 *
 */
@RestController
@RequestMapping("/houseparent")
public class HouseparentController extends BaseController<Houseparent, HouseparentService> {

    /**
     * 宿管员对象
     */
    @Autowired
    public HouseparentController(HouseparentService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> maphousing_management_number = new HashMap<>();
        maphousing_management_number.put("housing_management_number",String.valueOf(paramMap.get("housing_management_number")));
        List listhousing_management_number = service.select(maphousing_management_number, new HashMap<>()).getResultList();
        if (listhousing_management_number.size()>0){
            return error(30000, "字段宿管编号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
