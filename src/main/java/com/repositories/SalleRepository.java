package com.repositories;


import com.entities.Salle;
import com.entities.TSallesal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<TSallesal, Long> {
}
