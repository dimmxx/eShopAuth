FROM mysql
ENV MYSQL_ROOT_PASSWORD=remote
ENV MYSQL_DATABASE eshopauth
EXPOSE 3306
COPY init.sql /docker-entrypoint-initdb.d/

#COPY ./sql-scripts/ /docker-entrypoint-initdb.d/
