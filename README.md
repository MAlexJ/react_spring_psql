# Documentation
*********************

Path to the documentation REST api: 
/documentation/swagger-ui.html

Note: Documentation is available only after authorization of the user

# Docker
********************************

1. docker images

2. docker search [product]

3. docker pull [product]:[version] 
    example: docker pull postgres:latest

4. docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
    EXAMPLE: docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=2687484a -d postgres

5. docker ps -a

6. docker exec -it [CONTAINER_ID] /bin/sh
    CMD: > psql
    psql: FATAL:  role "root" does not exist
    CMD >>> # psql -U postgres

7.  docker stop [OPTIONS] CONTAINER [CONTAINER...]

8.   docker rmi -f 978b82dc00dc

9.   docker rm -f 29dc15e2cac2


# Postgres
********************************

1. First connect/login as root
	$ psql

	// Create a schema called test in the default database called postgres
	postgres=# CREATE SCHEMA test;
	postgres=# CREATE DATABASE app;

	//Create a role (user) with password
	postgres=# CREATE USER xxx PASSWORD 'yyy';

	//Grant privileges (like the ability to create tables) on new schema to new role
	postgres=# GRANT ALL ON SCHEMA test TO xxx;

	//Grant privileges (like the ability to insert) to tables in the new schema to the new role
	postgres=# GRANT ALL ON ALL TABLES IN SCHEMA test TO xxx;

	// Disconnect
	postgres=# \q
	// Became a standard user.

2. Show shemas
	\dn

3. Create table;

	CREATE TABLE app.user (userId SERIAL PRIMARY KEY, firstName VARCHAR(20), lastName VARCHAR(20), bithData DATE, gender VARCHAR(6));
	INSERT INTO app.user (firstName, lastName, birthData, gender) VALUES('Alex', 'Maximov', '06/21/1985', 'MALE');
	
# REST API
********************************

GET: /user
GET: /user/{id}
PUT: /user
POST: /user/{id}
DELETE: /user/{id}
