package com.turkcellteknoloji.signupproject.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AdminUserJPA implements AdminUserDAO {

    private EntityManager entityManager;

    @Override
    public void addAdminUser(AdminUser adminUser) {
        entityManager.persist(adminUser);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public AdminUser getAdminUser(String userName) {
        TypedQuery<AdminUser> query = entityManager.createQuery("SELECT au FROM AdminUser au WHERE au.username=:userName", AdminUser.class);
        query.setParameter("userName", userName);
        return query.getSingleResult();

    }
}
