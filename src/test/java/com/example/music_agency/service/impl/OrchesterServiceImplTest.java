package com.example.music_agency.service.impl;

import com.example.music_agency.dto.OrchesterDto;
import com.example.music_agency.entity.OrchesterEntity;
import com.example.music_agency.repository.OrchesterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrchesterServiceImplTest {
    @Mock
    private OrchesterRepository orchesterRepositoryMock;

    @InjectMocks
    private OrchesterServiceImpl orchesterServiceImplTest;

    private OrchesterEntity orchesterEntityTest;

    private OrchesterDto orchesterDtoTest;

    @BeforeEach
    void setUp() {

        Integer testIdBefore = 1;

        // Инициализация сущности и DTO
        orchesterEntityTest = new OrchesterEntity();
        orchesterEntityTest.setOrchesterId(testIdBefore);

        orchesterDtoTest = new OrchesterDto();
        orchesterDtoTest.setOrchesterId(testIdBefore);
    }

    @Test
    void getOrchesterByIdTest() {
        Integer testId = 1;
        when(orchesterRepositoryMock.findById(testId)).thenReturn(Optional.of(orchesterEntityTest));

        OrchesterDto actualOrchesterDto = orchesterServiceImplTest.getOrchesterById(testId);
        assertNotNull(actualOrchesterDto);
        assertEquals(testId, orchesterDtoTest.getOrchesterId());
        assertEquals(orchesterDtoTest, actualOrchesterDto);
        verify(orchesterRepositoryMock).findById(testId);



    }
}