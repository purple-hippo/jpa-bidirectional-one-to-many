FROM postgres
ENV POSTGRES_PASSWORD=password

COPY ./create_db.sql /docker-entrypoint-initdb.d/

EXPOSE 5432

