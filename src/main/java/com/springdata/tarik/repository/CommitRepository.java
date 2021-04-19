package com.springdata.tarik.repository;

import com.springdata.tarik.model.Commit;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CommitRepository extends CrudRepository<Commit, Long> {
    
    
      List<Commit>   findByDayBetweenOrderByUserAscDayDesc(Date start, Date end);
}
