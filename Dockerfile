FROM amazoncorretto:21 as gradle-builder

WORKDIR /fp-builder
COPY gradlew build.gradle settings.gradle /fp-builder/
RUN ./gradlew build -x test --parallel --continue > /dev/null 2>&1 || true

COPY . /fp-builder/
RUN ./gradlew :api:bootJar --no-daemon --stacktrace
RUN cp api/build/libs/api-0.0.1.jar app.jar

FROM amazoncorretto:21

ARG SPRING_PROFILE_ACTIVE

WORKDIR /fp-was
COPY --from=gradle-builder /fp-builder/app.jar .

EXPOSE 8080
ENV TZ="Asia/Seoul"

ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILE_ACTIVE}

CMD java \
    -Dcom.amazonaws.sdk.disableEc2Metadata=true \
    -jar app.jar
