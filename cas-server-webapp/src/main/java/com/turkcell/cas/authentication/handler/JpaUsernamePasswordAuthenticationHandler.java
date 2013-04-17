/*
 * Copyright 2013 Jasig.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.turkcell.cas.authentication.handler;

import com.turkcellteknoloji.signupproject.repository.AdminUserDAO;
import javax.persistence.NoResultException;
import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;

/**
 *
 * @author capacman
 */
public class JpaUsernamePasswordAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    private AdminUserDAO dao;

    public AdminUserDAO getDao() {
        return dao;
    }

    public void setDao(AdminUserDAO dao) {
        this.dao = dao;
    }

    @Override
    protected boolean authenticateUsernamePasswordInternal(UsernamePasswordCredentials credentials) throws AuthenticationException {
        final String username = getPrincipalNameTransformer().transform(credentials.getUsername());
        final String password = credentials.getPassword();
        final String encryptedPassword = this.getPasswordEncoder().encode(
                password);

        try {
            final String dbPassword = dao.getAdminUser(username).getPassword();
            return dbPassword.equals(encryptedPassword);
        } catch (final NoResultException e) {
            // this means the username was not found.
            return false;
        }
    }
}
