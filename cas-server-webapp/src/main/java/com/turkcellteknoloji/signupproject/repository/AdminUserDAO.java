package com.turkcellteknoloji.signupproject.repository;

public interface AdminUserDAO {

    public void addAdminUser(AdminUser adminUser);

    public AdminUser getAdminUser(String userName);
}
