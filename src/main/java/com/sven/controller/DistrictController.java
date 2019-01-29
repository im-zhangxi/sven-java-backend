package com.sven.controller;

import com.sven.entity.District;
import com.sven.exception.BaseException;
import com.sven.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping(value = "districts", produces = "application/json")
    public List<District> getDistrictsAction(HttpServletRequest request) throws Exception
    {
        String level = request.getParameter("level");
        String parentId = request.getParameter("parent_id");
        if (level == null || level.isEmpty()) {
            throw new BaseException("level 不能为空");
        }

        return districtService.getDistrictsAction(level, parentId);
    }
}
