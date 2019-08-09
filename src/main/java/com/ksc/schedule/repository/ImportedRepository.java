package com.ksc.schedule.repository;

import com.ksc.schedule.entity.Imported;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportedRepository extends JpaRepository<Imported, String> {

}
