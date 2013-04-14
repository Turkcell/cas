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
package org.jasig.cas.web.flow;

import com.turkcell.cas.web.model.AcceptEula;
import javax.sql.DataSource;
import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.support.oauth.authentication.principal.OAuthCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.webflow.scope.FlowScope;

/**
 *
 * @author capacman
 */
public class CheckOauthCredentials {

    private static final Logger logger = LoggerFactory.getLogger(CheckOauthCredentials.class);
    private JdbcTemplate jdbcTemplate;

    public final boolean checkForFirstLogin(final Credentials credentials) throws Exception {
        logger.info("checkForFirstLogin credentials {}", credentials.getClass().getName());
        if (credentials instanceof OAuthCredentials) {
            logger.info("oauthLogin");
            OAuthCredentials oAuthCredentials = (OAuthCredentials) credentials;
            String oauthId = oAuthCredentials.getUserProfile().getTypedId();
            try {
                jdbcTemplate.queryForObject("select oauth_id from admin_users where oauth_id=?", String.class, oauthId);
                return false;
            } catch (EmptyResultDataAccessException e) {
                logger.info("initial oauth login");
                return true;
            }
        }
        return false;
    }

    public final String checkEula(AcceptEula eula, Credentials credentials) {
        logger.info("inside checkEula");
        String returnValue = "rejected";
        if (eula.isAcceptEula()) {
            returnValue = "accepted";
        }
        logger.info("returnValue {}", returnValue);
        return returnValue;
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
