package com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

}
