package com.example.music_agency.repository;

import com.example.music_agency.entity.OrchesterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrchesterRepository extends JpaRepository<OrchesterEntity, Integer> {
    Optional<OrchesterEntity> findById(Integer id);
}
