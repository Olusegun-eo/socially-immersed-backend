package com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Webinar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebinarRepository extends JpaRepository<Webinar, Long> {

    List<Webinar> findByHashtagsHashtag(String hashtag);
}
