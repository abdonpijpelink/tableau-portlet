<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="nl.abdon.tableauportlet.Tableau"%>

<script type="text/javascript" src="http://tableau.vm/javascripts/api/viz_v1.js"></script> 
<object class="tableauViz" width="100%" height="800" style="display:none;"> 
    <param name="name" value="Sales/2013SalesGrowth" /> 
    <param name="ticket" value="<%= Tableau.getTrustedTicket(PortalUtil.getUser(request).getScreenName()) %>" /> 
</object> 
