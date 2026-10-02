package com.project.demo.controller;

import com.project.demo.entity.LackOfBedRegistration;
import com.project.demo.service.LackOfBedRegistrationService;
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
 * 缺寝登记：(LackOfBedRegistration)表控制层
 *
 */
@RestController
@RequestMapping("/lack_of_bed_registration")
public class LackOfBedRegistrationController extends BaseController<LackOfBedRegistration, LackOfBedRegistrationService> {

    /**
     * 缺寝登记对象
     */
    @Autowired
    public LackOfBedRegistrationController(LackOfBedRegistrationService service) {
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
