package com.example.music_agency.repository;

import com.example.music_agency.entity.PianistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PianistRepository extends JpaRepository<PianistEntity, Integer> {
    Optional<PianistEntity> findById(Integer id);
}
