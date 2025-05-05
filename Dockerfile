FROM amazoncorretto:17

WORKDIR /src

COPY ./build/libs/*.jar /src/source.jar

ENV DB_ENDPOINT="127.0.0.1" \
    DB_USER="root" \
    DB_PASSWORD="P@ssw0rd1224" \
    REDIS_HOST="127.0.0.1"

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /src/source.jar"]
