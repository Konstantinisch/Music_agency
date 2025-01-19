package com.example.music_agency.service.impl;

import com.example.music_agency.dto.ManagerDto;
import com.example.music_agency.entity.ManagerEntity;
import com.example.music_agency.exception.ManagerDoesntExistException;
import com.example.music_agency.repository.ManagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ManagerServiceImplTest {

    @Mock
    private ManagerRepository managerRepositoryMock;

    @InjectMocks
    private ManagerServiceImpl managerService;

    private ManagerEntity managerEntity1;
    private ManagerEntity managerEntity2;
    private ManagerDto managerDto1;
    private ManagerDto managerDto2;

    @BeforeEach
    void setUp() {
        managerEntity1 = new ManagerEntity(1, "Manager1", 10);
        managerEntity2 = new ManagerEntity(2, "Manager2", 15);

        managerDto1 = new ManagerDto(1, "Manager1", 10);
        managerDto2 = new ManagerDto(2, "Manager2", 15);
    }

    @Test
    void getAllManagersTest() {


        when(managerRepositoryMock.findAll()).thenReturn(List.of(managerEntity1, managerEntity2));

        List<ManagerEntity> managers = managerService.getAllManagers();

        for (ManagerEntity manager : managers) {
            System.out.println("Manager name: " + manager.getName());
        }
//        when(managerRepositoryMock.findAll()).thenReturn(List.of(managerEntity1, managerEntity2));
//
//        List<ManagerEntity> managers = managerService.getAllManagers();
//
//        System.out.println(managers.get(0).getName()+"Hallo");
//
//
//        assertNotNull(managers);
//        assertEquals(2, managers.size());
//        assertEquals(managerDto1.getName(), managers.get(0).getName());
//        assertEquals(managerDto2.getPercentOfGage(), managers.get(1).getPercentOfGage());
//
//        verify(managerRepositoryMock).findAll();
    }

    @Test
    void getManagerByIdTest() {
        when(managerRepositoryMock.findById(1)).thenReturn(Optional.of(managerEntity1));

        ManagerEntity manager = managerService.getManagerById(1);

        assertNotNull(manager);
        assertEquals(managerEntity1.getManagerId(), manager.getManagerId());
        assertEquals(managerEntity1.getName(), manager.getName());

        verify(managerRepositoryMock).findById(1);
    }


    @Test
    void createManagerTest() {
        when(managerRepositoryMock.save(any(ManagerEntity.class))).thenReturn(managerEntity1);

        ManagerDto createdManager = managerService.createManager(managerDto1);

        assertNotNull(createdManager);
        assertEquals(managerDto1.getName(), createdManager.getName());
        verify(managerRepositoryMock).save(any(ManagerEntity.class));
    }

    @Test
    void updateManagerTest() {
        when(managerRepositoryMock.save(any(ManagerEntity.class))).thenReturn(managerEntity1);

        ManagerDto updatedManager = managerService.updateManager(managerDto1);

        assertNotNull(updatedManager);
        assertEquals(managerDto1.getName(), updatedManager.getName());
        verify(managerRepositoryMock).save(any(ManagerEntity.class));
    }

    @Test
    void deleteManagerTest() {
        when(managerRepositoryMock.findById(1)).thenReturn(Optional.of(managerEntity1));

        managerService.deleteManager(1);

        verify(managerRepositoryMock).findById(1);
        verify(managerRepositoryMock).delete(managerEntity1);
    }

}