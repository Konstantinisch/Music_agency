package com.example.music_agency.service.impl;

import com.example.music_agency.dto.ManagerDto;
import com.example.music_agency.entity.ManagerEntity;
import com.example.music_agency.repository.ManagerRepository;
import com.example.music_agency.service.ManagerService;
import org.apache.catalina.Manager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ManagerServiceImplTest {

    @Mock
    private ManagerRepository managerRepository;

    @InjectMocks
    private ManagerServiceImpl managerService;

    public ManagerServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

//
//    @Test
//    void getAllManagers() {
//        ManagerEntity managerEntity = new ManagerEntity(1L, "Peter", 15);
//        ManagerEntity managerEntity2 = new ManagerEntity(2L, "Jack", 20);
//        List<ManagerEntity> managers = Arrays.asList(managerEntity, managerEntity2);
//        when(managerRepository.findAll()).thenReturn(managers);
//        List<ManagerDto> managerDto = managerService.getAllManagers();
//        assertNotNull(managerDto);
//        assertEquals(2, managerDto.size());
//        assertEquals("Peter", managerDto.get(0).getName());
//        assertEquals("Jack", managerDto.get(1).getName());
//        assertEquals(15, managerDto.get(0).getPercentOfGage());
//        assertEquals(20, managerDto.get(1).getPercentOfGage());
//        verify(managerRepository, times(1)).findAll();
//    }

//    @Test
//    void getAllManagers() {
//
//        ManagerEntity managerEntity1 = new ManagerEntity(1L, "Peter", 15);
//        ManagerEntity managerEntity2 = new ManagerEntity(2L, "Jack", 20);
//        List<ManagerEntity> managers = Arrays.asList(managerEntity1, managerEntity2);
//        when(managerRepository.findAll()).thenReturn(managers);
//        List<ManagerDto> managerDtos = managerService.getAllManagers();
//        assertNotNull(managerDtos, "Список менеджеров не должен быть null");
//        assertEquals(2, managerRepository.findAll().size(), "Размер списка должен быть 2");
//
//        assertEquals("Peter",  managers.get(0).getName(), "Имя первого менеджера должно быть 'Peter'");
//        assertEquals(15, managers.get(0).getPercentOfGage(), "Процент первого менеджера должен быть 15");
//
//        assertEquals("Jack", managers.get(1).getName(), "Имя второго менеджера должно быть 'Jack'");
//        assertEquals(20, managers.get(1).getPercentOfGage(), "Процент второго менеджера должен быть 20");
//        verify(managerRepository, times(1)).findAll();
//    }


//    @Test
//    void getAllManagers() {
//        // Создаем mock-данные
//        ManagerEntity managerEntity1 = new ManagerEntity(1L, "Peter", 15);
//        ManagerEntity managerEntity2 = new ManagerEntity(2L, "Jack", 20);
//        List<ManagerEntity> managers = Arrays.asList(managerEntity1, managerEntity2);
//
//        // Настраиваем mock для репозитория
//        when(managerRepository.findAll()).thenReturn(managers);
//
//        // Вызываем тестируемый метод
//        List<ManagerDto> managerDtos = managerService.getAllManagers();
//
//        // Проверяем результат
//        assertNotNull(managerDtos, "Список менеджеров не должен быть null");
//        assertEquals(2, managerDtos.size(), "Размер списка DTO должен быть 2");
//
//        // Проверяем содержимое DTO
//        assertEquals("Peter", managerDtos.get(0).getName(), "Имя первого менеджера должно быть 'Peter'");
//        assertEquals(15, managerDtos.get(0).getPercentOfGage(), "Процент первого менеджера должен быть 15");
//
//        assertEquals("Jack", managerDtos.get(1).getName(), "Имя второго менеджера должно быть 'Jack'");
//        assertEquals(20, managerDtos.get(1).getPercentOfGage(), "Процент второго менеджера должен быть 20");
//
//        // Убеждаемся, что метод findAll вызывался один раз
//        verify(managerRepository, times(1)).findAll();
//    }

    @Test
    void getAllManagers() {
        // Создаем mock-данные
        ManagerEntity managerEntity1 = new ManagerEntity(1L, "Peter", 15);
        ManagerEntity managerEntity2 = new ManagerEntity(2L, "Jack", 20);
        List<ManagerEntity> managers = Arrays.asList(managerEntity1, managerEntity2);

        // Настраиваем mock для репозитория
        when(managerRepository.findAll()).thenReturn(managers);

        // Вызываем метод
        List<ManagerDto> managerDtos = managerService.getAllManagers();

        // Отладка
        System.out.println("DTO List: " + managerDtos);

        // Проверки
        assertNotNull(managerDtos, "Список менеджеров не должен быть null");
        assertEquals(2, managerDtos.size(), "Размер списка DTO должен быть 2");

        assertEquals("Peter", managerDtos.get(0).getName(), "Имя первого менеджера должно быть 'Peter'");
        assertEquals(15, managerDtos.get(0).getPercentOfGage(), "Процент первого менеджера должен быть 15");

        assertEquals("Jack", managerDtos.get(1).getName(), "Имя второго менеджера должно быть 'Jack'");
        assertEquals(20, managerDtos.get(1).getPercentOfGage(), "Процент второго менеджера должен быть 20");

        verify(managerRepository, times(1)).findAll();
    }


    @Test
    void getManagerById() {
    }

    @Test
    void createManager() {
    }

    @Test
    void updateManager() {
    }

    @Test
    void deleteManager() {
    }
}