package com.turkcellteknoloji.signupproject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Controller;

import com.turkcellteknoloji.signupproject.repository.AdminUser;
import com.turkcellteknoloji.signupproject.repository.AdminUserDAO;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends SimpleFormController {

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap();
        map.put("signup", true);
        return map;
    }
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        AdminUser adminUser = (AdminUser) command;
        logger.info("adminUser is {}", adminUser);
        if (adminUser.getOrganization() == null) {
            adminUser.setOrganization(adminUser.getUsername());
        }
        userDao.addAdminUser(adminUser);
        createUsergridUser(adminUser);
    }

    public HomeController() {
        setCommandClass(AdminUser.class);
        setCommandName("adminUserForm");
    }
    private AdminUserDAO userDao;

    public AdminUserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(AdminUserDAO userDao) {
        this.userDao = userDao;
    }

    public String getUserGridHost() {
        return userGridHost;
    }

    public void setUserGridHost(String userGridHost) {
        this.userGridHost = userGridHost;
    }
    private String userGridHost;

    private void createUsergridUser(AdminUser adminUser) throws IllegalArgumentException, IOException {

        PostMethod post = new PostMethod(userGridHost + "management/organizations");
        JsonFactory jf = new JsonFactory();

        ObjectMapper om = new ObjectMapper();
        final String jsonBody = om.writeValueAsString(adminUser);
        logger.info("json body is {}", jsonBody);
        RequestEntity entity = new StringRequestEntity(jsonBody, "application/json", "UTF-8");
        post.setRequestEntity(entity);
        HttpClient client = new HttpClient();
        client.executeMethod(post);
        String response = post.getResponseBodyAsString();
        post.releaseConnection();
        logger.info("response: {}", response);
    }
}
