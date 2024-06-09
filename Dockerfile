# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM ibmjava:jre
ARG JAR_FILE=target/basic-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} course-project.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/course-project.jar"]