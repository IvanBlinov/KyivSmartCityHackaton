package com.ksc.schedule.repository;

import com.ksc.schedule.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, String> {


}
