<%@ page pageEncoding="UTF-8" %>

<jsp:directive.include file="../includes/top.jsp" />

<form:form method="post" id="fm1" cssClass="fm-v clearfix" commandName="adminUserForm" htmlEscape="true">
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
            <h2 class="title">Üye Ol</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae justo tortor, at suscipit purus.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae justo tortor, at suscipit purus.</p>
        </div>

        <div class="options">
            <form:errors path="*" cssClass="message result-error" element="div" htmlEscape="false" />
            <fieldset>
                <p class="name">
                    <form:input placeholder="Ad" cssClass="required" cssErrorClass="error" id="name" path="name" autocomplete="false" htmlEscape="true" />
                    <form:input placeholder="Soyad" cssClass="required" cssErrorClass="error" id="surname" path="surname" autocomplete="false" htmlEscape="true" />
                </p>
                <p class="email">
                    <form:input placeholder="E-posta" cssClass="required" cssErrorClass="error" id="email" path="email" autocomplete="false" htmlEscape="true" />
                </p>
                <p class="username">
                    <form:input placeholder="Kullanıcı Adı" cssClass="required" cssErrorClass="error" id="username" path="username" autocomplete="false" htmlEscape="true" />
                </p>
                <p class="password">
                    <form:password placeholder="Şifre" cssClass="required" cssErrorClass="error" id="password" path="password" autocomplete="false" htmlEscape="true" />
                </p>
                <p class="group">
                    <input class="button" name="submit" value="Üye Ol" type="submit" />
                </p>
            </fieldset>
        </div>
    </div>
</form:form>

<jsp:directive.include file="../includes/bottom.jsp" />