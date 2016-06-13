# ase2016
Air Quality Monitoring

* http://localhost:8080/airQualityMonitoring/index.html

* docker build -t ase -f Dockerfile .
* docker run --name as --volume /c/Users/DanielHofer/IdeaProjects/ase2016/src/main/resources:/app, /c/Users/DanielHofer/IdeaProjects/ase2016/src/main/resources:/usr/local/tomcat/logs -p 8080:8080 ase