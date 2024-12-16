package com.example.music_agency.repository;

import com.example.music_agency.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, Integer> {
    Optional<ManagerEntity> findById(Integer id);
}
