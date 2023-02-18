package com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
