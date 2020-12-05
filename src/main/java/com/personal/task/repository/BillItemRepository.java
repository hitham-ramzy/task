package com.personal.task.repository;

import com.personal.task.domain.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BillItemRepository extends JpaRepository<BillItem, Long>, JpaSpecificationExecutor<BillItem> {
}
