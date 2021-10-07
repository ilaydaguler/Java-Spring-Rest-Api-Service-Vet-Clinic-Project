package com.works.repositories;

import com.works.entities.NewCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<NewCase,Integer> {
}

