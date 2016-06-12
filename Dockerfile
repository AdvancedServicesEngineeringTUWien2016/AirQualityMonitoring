FROM tomcat:8.5
MAINTAINER hoferd

ADD target/airQualityMonitoring.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]