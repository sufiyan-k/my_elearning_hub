package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.pojos.SubTopic;

public interface SubtopicRepository extends JpaRepository<SubTopic, Long> {
	
	@Query(value="select s from SubTopic s where s.chapter.chapterId=?1",nativeQuery=false)
	List<SubTopic> getSubtopicsByChapterid(long chpid);
	
	

}
