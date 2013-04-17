package com.turkcellteknoloji.signupproject.repository;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_users")
public class AdminUser {

    @Basic
    @Column(length = 255, unique = true, insertable = true, nullable = false, updatable = false, name = "username")
    private String username;
    @Basic
    @Column(length = 255, unique = false, insertable = true, nullable = true, updatable = true, name = "name")
    private String name;
    @Basic
    @Column(length = 255, unique = false, insertable = true, nullable = true, updatable = true, name = "surname")
    private String surname;
    @Basic
    @Column(length = 255, unique = true, insertable = true, nullable = false, updatable = true, name = "email")
    private String email;
    @Basic
    @Column(length = 255, unique = false, insertable = true, nullable = false, updatable = true, name = "password")
    private String password;
    @Basic
    @Column(length = 255, unique = false, insertable = true, nullable = false, updatable = false, name = "organization")
    private String organization;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public AdminUser(String username, String name, String surname,
            String email, String password, String organization) {
        super();
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.organization = organization;
    }

    public AdminUser() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((organization == null) ? 0 : organization.hashCode());
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result
                + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AdminUser other = (AdminUser) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (organization == null) {
            if (other.organization != null) {
                return false;
            }
        } else if (!organization.equals(other.organization)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (surname == null) {
            if (other.surname != null) {
                return false;
            }
        } else if (!surname.equals(other.surname)) {
            return false;
        }
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdminUser [username=" + username + ", name=" + name
                + ", surname=" + surname + ", email=" + email + ", password="
                + password + ", organization=" + organization + "]";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
