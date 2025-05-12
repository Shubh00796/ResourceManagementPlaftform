package com.Reposiotry;

import com.Domian.BorrowRequestEntity;
import com.Domian.ResourceEntity;
import com.Domian.UserEntity;
import com.Domian.Enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRequestRepository extends JpaRepository<BorrowRequestEntity, Long> {


    List<BorrowRequestEntity> findByBorrowerId(Long borrowerId); // ✅ correct


}