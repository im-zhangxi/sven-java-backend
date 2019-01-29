package com.sven.repository;

import com.sven.entity.District;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DistrictRepository extends JpaRepository<District, Integer>
{
    List<District> findByLevel(Integer level);

    List<District> findByLevelAndParentId(Integer level, UUID parentId);
}
