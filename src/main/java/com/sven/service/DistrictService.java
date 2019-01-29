package com.sven.service;

import com.sven.entity.District;
import com.sven.exception.BaseException;
import com.sven.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DistrictService {
    @Autowired
    private DistrictRepository repository;

    public List<District> getDistrictsAction(String levelStr, String parentIdStr)
    {
        int level = Integer.parseInt(levelStr);
        if (parentIdStr != null) {
            UUID parentId = UUID.fromString(parentIdStr);
            return repository.findByLevelAndParentId(level, parentId);
        }

        return repository.findByLevel(level);
    }
}
