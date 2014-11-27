# Sample Tableau portlet

This is a simple proof-of-concept showing how [Tableau Server](www.tableausoftware.com) and [Liferay](www.liferay.com) can be integrated in the form of a portlet. This portlet shows a specific view from the Tableau Server sample data set, for the specific user that is logged into Liferay. 

This portlet uses Tableau Server's REST API to get a "trusted ticket" for the current portal user. Using this trusted ticket, it shows the specific view using Tableau Server's Javascript API.

To run the portlet, first enable Tableau Server's REST API and Trusted Authentication:

```
tabadmin stop
tabadmin set api.server.enabled true
tabadmin configure
tabadmin set wgserver.trusted_hosts "<Liferay's IP address or hostname>"
tabadmin config 
tabadmin start
```

This portlet makes the following assumptions: 
* Liferay and Tableau Server share the same users (which can be achieved through e.g. LDAP), with Liferay's screen name being identical to Tableau's username. 
* Tableau Server can be reached using hostname "tableau.vm" (which can be achieved by editing your hosts file).

The portlet has been tested on Liferay 6.2 and Tableau Server 8.2.
