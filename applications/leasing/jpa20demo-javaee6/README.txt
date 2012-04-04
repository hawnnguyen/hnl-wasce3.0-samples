WebSphere Application Server Community Edition V3.0.0.1 Samples
(C) Copyright 2005,2012 IBM Corporation.  All rights reserved.
----------------------------------------------------------------------

This README uses the following aliases to describe directories.  These aliases should be replaced with your actual directory paths.
   %SAMPLE_HOME% refers to the root directory where WASCE samples are extracted.
   %WASCE_HOME% refers to the root directory where the WASCE server is installed.
   

BUILD
-----
Refer to %SAMPLE_HOME%/README.txt for build instructions. 


INSTALL
-------
This sample has been pre-built, so you can simply perform the following steps to install it.  

Start the WASCE server if it is not already running.

To use the deployer tool to install the application:
1.First create a db named: jpa20demodb via admin console "DB Manager" 
2. Execute these commands from a command prompt:
        cd %WASCE_HOME%/bin 
	deploy.[bat|sh] deploy %SAMPLE_HOME%/applications/javaee6/jpa20demo-javaee6/jpa20demo-javaee6-war/target/jpa20demo-javaee6-war-3.0.0.1.war
   

To use the admin console to install the application:
1. Under Applications -> Deploy new
   - Select the WAR file indicated above as your archive.
   - Leave the plan field empty.
   - Ensure the checkbox is selected to "start app after install".


RUN
---
1. Create a database named "jpa20demodb".
2. Open the following link in a web browser:
        http://localhost:8080/jpa20demo-javaee6/
3. Click Criteria API Demo to post and retrieve messages.

UNINSTALL
---------
To use the undeployer tool to uninstall the application:
1. Execute these commands from a command prompt:
        cd %WASCE_HOME%/bin
	deploy.[bat|sh] undeploy org.apache.geronimo.samples/jpa20demo-javaee6/3.0.0.1/car
        
To use hot undeployment to uninstall the application:
1. Delete the WAR file indicated above from %WASCE_HOME%/deploy

To use the admin console to uninstall the application:
1. Locate your sample's component under Applications -> Web App WARs
   - Select the "Uninstall" command link.
