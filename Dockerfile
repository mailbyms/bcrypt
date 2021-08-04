### phase 1
FROM tomcat:9-jdk8

ARG PROJECT=bcrypt

ADD target/${PROJECT}.war /target/${PROJECT}.war

RUN cd /target \
    && unzip ${PROJECT}.war -d ${PROJECT} \
    && rm -f ${PROJECT}.war

### phase 2
FROM tomcat:9-jdk8

ARG TOMCAT_WEBAPPS_DIR=/usr/local/tomcat/webapps

COPY --from=0  /target ${TOMCAT_WEBAPPS_DIR}/

EXPOSE 8080