

<%@ page import="uk.co.assetmap.Asset" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'asset.label', default: 'Asset')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${assetInstance}">
            <div class="errors">
                <g:renderErrors bean="${assetInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${assetInstance?.id}" />
                <g:hiddenField name="version" value="${assetInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="asset.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: assetInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" maxlength="100" value="${assetInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="postcode"><g:message code="asset.postcode.label" default="Postcode" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: assetInstance, field: 'postcode', 'errors')}">
                                    
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="description"><g:message code="asset.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: assetInstance, field: 'description', 'errors')}">
                                    <g:textArea name="description" cols="40" rows="5" value="${assetInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="assetGroup"><g:message code="asset.assetGroup.label" default="Asset Group" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: assetInstance, field: 'assetGroup', 'errors')}">
                                    <g:select name="assetGroup.id" from="${uk.co.assetmap.AssetGroup.list()}" optionKey="id" value="${assetInstance?.assetGroup?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
