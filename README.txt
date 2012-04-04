HNL WASCE TEST

For the WASCE Sample Application, it uses JSF (MyFaces) and JPA.  The Websphere Application Server Community Server (WASCE) 3.0 ships with OpenJPA which is the default.

If you wish to use hibernate on Websphere Application Server Community Edition, you would need to add the hibernate jars (download from jboss) <HIBERNATE>/lib/required and the jpa/.  Added it to the WASCE repository in the server.  You can use the WASCE console Repository to do so. It will convert the .jar file into Bundiles.  WASCE is also an OSGi enabled container via Apache Geronimo.
