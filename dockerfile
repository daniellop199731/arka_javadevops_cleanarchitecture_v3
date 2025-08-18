FROM quay.io/wildfly/wildfly:29.0.1.Final-jdk17

USER root

#Crear el directorio necesario
RUN mkdir -p /home/daniel/arka/properties  \
    mkdir -p /home/daniel/arka/config/NCSD/PROGRAMA  \
    touch /home/daniel/arka/properties.config  \

#Copiar los archivos de configuración
COPY /propertiesnexus.config /home/daniel/arka/properties
COPY arka_javadevops_cleanarchitecture_v3-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

#Añadir un usuario de administracion para la consola de WildFly
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent

#Exponer los puertos necesarios
EXPOSE 8080 9990

USER jboss

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]