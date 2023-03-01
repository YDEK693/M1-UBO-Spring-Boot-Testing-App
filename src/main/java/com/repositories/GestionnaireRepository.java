package com.repositories;


import com.entities.TGestionnaireGst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionnaireRepository extends JpaRepository<TGestionnaireGst, Long> {
}
