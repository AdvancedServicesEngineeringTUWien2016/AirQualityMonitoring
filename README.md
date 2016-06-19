# ase2016
Air Quality Monitoring

# Requirements

* JDK 8
* Maven 3
* MongoDB

# applications.properties

Change the following properties:

* MongoDB host and port (row 3, 4)
* Gmail credentials for mail notification (row 19, 20)
* https://websms.at/produkte/online-sms account webtoken for sms notification (row 28). Use simulation (row 27)
* London Air API simulation (row 13). If true: Specify location of air.json and health.json (row 14)

# Build

* Build with maven
* Deploy on Tomcat 8 (see Dockerfile) or start using spring-boot:start
* URL: http://localhost:8080/airQualityMonitoring/index.html
