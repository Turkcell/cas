<!DOCTYPE html>
<%@ page session="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Turkcell Geleceği Yazanlar Giriş Sistemi</title>
    <meta name="viewport" content="width=device-width">

    <link rel="shortcut icon" href="<c:url value="/images/favicon.png" />">

    <link rel="stylesheet" href="<c:url value="/css/gy.css" />">

    <style>
        .site-header {
            height: 160px;
        }

        #content {
            width: 780px;
            margin: 100px auto;
        }

        #cboxContent {
            margin: 0;
        }

        .message h2,
        .modal-window h2:first-child {
            margin-top: 0;
        }

        input[type="checkbox"],
        input[type="submit"] {
            width: auto !important;
        }

        #name,
        #surname {
            width: 140px;
        }

        .welcome-security {
            font-style: italic;
            text-align: center;
            margin-top: 30px;
        }
    </style>

    <!--[if lt IE 9]>
    <script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
    <![endif]-->
</head>
<body class="front">

<div id="page" class="page">
    <header class="site-header">
        <div class="content-holder">
            <h1 class="site-headline site-title"><a href="#" title=""></a></h1>

            <nav id="page-navigation" class="primary-navigation group" role="navigation">
                <ul class="nav group">
                    <li class="first <c:out value='${signup ? "" : "active"}'/>"><a href="#" class="<c:out value='${signup ? "" : "active"}'/>">Giriş Yap</a></li>
                    <li class="last <c:out value='${signup ? "active" : ""}'/>"><a href="#" class="<c:out value='${signup ? "active" : ""}'/>">Kayıt Ol</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div id="content">
    <c:if test="${not pageContext.request.secure}">
        <div class="message result-error">
            <h2>Non-secure Connection</h2>
            <p>You are currently accessing CAS over a non-secure connection. Single Sign On WILL NOT WORK.  In order to have single sign on work, you MUST log in over HTTPS.</p>
        </div>
    </c:if>

    <div id="cboxContent">
        <div id="cboxLoadedContent">
            <div class="modal-window login-register login-modal group">