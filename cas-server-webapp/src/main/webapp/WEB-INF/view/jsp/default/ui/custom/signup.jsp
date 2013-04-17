<jsp:directive.include file="../includes/top.jsp" />
<c:if test="${not pageContext.request.secure}">
    <div id="msg" class="errors">
        <h2>Non-secure Connection</h2>
        <p>You are currently accessing CAS over a non-secure connection.  Single Sign On WILL NOT WORK.  In order to have single sign on work, you MUST log in over HTTPS.</p>
    </div>
</c:if>
<form:form method="post" id="fm1" cssClass="fm-v clearfix" commandName="adminUserForm" htmlEscape="true">
    <form:errors path="*" id="msg" cssClass="errors" element="div" />
    <fieldset>
        <legend>New User - Sign Up</legend>
        <table cellspacing="0">
            <tr>
                <th><label for="name">Name:</label></th>
                <td><form:input cssClass="required" cssErrorClass="error" id="name" size="255" tabindex="1"  path="name" autocomplete="false" htmlEscape="true" /></td>
            </tr>
            <tr>
                <th><label for="surname">Surname:</label></th>
                <td><form:input cssClass="required" cssErrorClass="error" id="surname" size="255" tabindex="1"  path="surname" autocomplete="false" htmlEscape="true" /></td>
            </tr>
            <tr>
                <th><label for="email">E-mail:</label></th>
                <td><form:input cssClass="required" cssErrorClass="error" id="email" size="255" tabindex="1"  path="email" autocomplete="false" htmlEscape="true" /></td>
            </tr>
            <tr>
                <th><label for="password">Password:</label></th>
                <td><form:password cssClass="required" cssErrorClass="error" id="password" size="255" tabindex="1"  path="password" autocomplete="false" htmlEscape="true" /></td>
            </tr>
            <tr>
                <th><label for="username">Username:</label></th>
                <td><form:input cssClass="required" cssErrorClass="error" id="username" size="255" tabindex="1"  path="username" autocomplete="false" htmlEscape="true" /></td>
            </tr>
            <tr>
                <th></th>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </fieldset>
</form:form>
<jsp:directive.include file="../includes/bottom.jsp" />
