<%@ page pageEncoding="UTF-8" %>

<jsp:directive.include file="includes/top.jsp" />

<form:form method="post" id="fm1" commandName="${commandName}" htmlEscape="true">
    <div class="use-social-networks group">
        <div class="description">
            <h2 class="title">Hesaplarını Kullan</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae justo tortor, at suscipit purus.</p>
        </div>

        <div class="social-networks options">
            <a class="facebook" rel="nofollow" href="#"><img src="http://www.facebook.com/images/fbconnect/login-buttons/connect_light_medium_short.gif" alt=""></a>
            <a href="#" class="twitter" title="Twitter ile giriş yapın">Twitter</a>
            <a href="#google" class="google" title="Google ile giriş yapın">Google</a>
            <a href="#openid" class="openid" title="OpenID ile giriş yapın">OpenID</a>
            <a class="github" href="#">Login with GitHub</a>
        </div>
    </div>

    <div class="use-portal group">
        <div class="description">
            <h2 class="title">Üye Girişi Yap</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae justo tortor, at suscipit purus.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae justo tortor, at suscipit purus.</p>
        </div>

        <div class="options">
            <form:errors path="*" cssClass="message result-error" element="div" htmlEscape="false" />
            <fieldset>
                <p>
                    <input type="text" id="edit-openid-identifier" placeholder="OpenID kullanıcı adın" name="openid_identifier" class="form-text" style="display: none;">
                </p>
                <p class="email">
                <c:if test="${not empty sessionScope.openIdLocalId}">
                    <strong>${sessionScope.openIdLocalId}</strong>
                    <input type="hidden" id="username" name="username" value="${sessionScope.openIdLocalId}" />
                </c:if>
                <c:if test="${empty sessionScope.openIdLocalId}">
                    <spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
                    <form:input placeholder="Kullanıcı adı veya e-posta adresinizi girin" cssClass="required" cssErrorClass="error" id="username" size="25" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="off" htmlEscape="true" />
                </c:if>
                </p>
                <p class="password">
                    <spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
                    <form:password placeholder="Parolanızı girin" cssClass="required" cssErrorClass="error" id="password" size="25" tabindex="2" path="password" accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
                </p>
                <p class="group">
                    <label for="warn"><input id="warn" name="warn" value="true" tabindex="3" accesskey="<spring:message code="screen.welcome.label.warn.accesskey" />" type="checkbox"> <spring:message code="screen.welcome.label.warn" /></label>
                </p>
                <p class="group">
                    <input class="button" name="submit" accesskey="l" value="<spring:message code="screen.welcome.button.login" />" tabindex="4" type="submit" />
                    <a href="#" class="remind-password">Şifremi Unuttum</a>
                </p>
                <input type="hidden" name="lt" value="${loginTicket}" />
                <input type="hidden" name="execution" value="${flowExecutionKey}" />
                <input type="hidden" name="_eventId" value="submit" />
            </fieldset>
        </div>
    </div>

    <p class="welcome-security result-warn">
        <spring:message code="screen.welcome.security" />
    </p>
</form:form>

<jsp:directive.include file="includes/bottom.jsp" />