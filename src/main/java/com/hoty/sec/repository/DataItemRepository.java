package com.hoty.sec.repository;

import com.hoty.sec.model.DataItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataItemRepository extends JpaRepository<DataItem, Long> { }

