package com.ohgirap.section01.entity;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class MemberTests {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");

    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManmager() {
        entityManager.close();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    void 멤버_복합키_롤타입_테이블_매핑_테스트(){
        //given
        Member member = new Member();
        member.setMemberNum(1);
        member.setMemberName("매핑귀신");
        member.setMemberNickName("테이블귀신");
        member.setMemberRole(RoleType.MEMBER);
        member.setPhone("010-2424-2030");
        member.setPostalCode("11032");
        member.setAddress("경기도 김포시");
        member.setDetailedAddress("하이미디어 7층 강의실");
        member.setModifyDate(new Date());
        member.setRegistrationDate(new Date());
        member.setState("Y");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(member);
        transaction.commit();

        Member findMember = entityManager.find(Member.class, 1);
        System.out.println(findMember);
        Assertions.assertEquals(member , findMember);

    }

}
