package org.perscholas.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.perscholas.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IAdminRepoTest {

    IAdminRepo adminRepo;

    @Autowired
    public IAdminRepoTest(IAdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @BeforeAll
    void setUp() {
        log.info("Beginning IAdminRepo Tests");
    }

    @Test
    public void getByAdminIdTest() {

        Optional<Admin> ad = adminRepo.getByadminId(1L);

        if(adminRepo.getByadminId(ad.get().getAdminId()) != null) {
            Assertions.assertTrue(ad != null);
        }

    }

    /*@Test
    public void findByUsernameTest() {
        Optional<Admin> ad = adminRepo.findByusername("Adam");

        if(adminRepo.findByusername(ad.get().getUsername()).isEmpty()) {
            Assertions.assertFalse(ad == null);
        }
    }*/


    @AfterAll
    void tearDown() {
        log.info("Ending IAdminRepo Tests. Peace.");
    }
}