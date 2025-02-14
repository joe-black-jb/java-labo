FROM openjdk:17-jdk-alpine
WORKDIR /app

# Mavenのインストール
# RUN apk add --no-cache maven

# # ソースコードをマウントするためのVOLUME指定
# VOLUME /app/src
# VOLUME /app/target

# COPY /pom.xml /app
# RUN mvn clean install

# アプリケーションを起動するエントリーポイント
# ENTRYPOINT ["java", "-jar", "/app/target/spring-boot-dynamodb-0.0.1-SNAPSHOT.jar"]

## ビルド時に target/*.jar をコンテナ内の /app/app.jar にコピーする
## (docker-comose.yml で volumes を書いている場合、不要)
# COPY target/*.jar app.jar
## ARG で .jar ファイルのパスを指定する書き方 (COPY だけでも動く)
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar

# VOLUME /app
# ENTRYPOINT ["java","-jar","/app.jar"]
# ENTRYPOINT ["java","-jar","/app/app.jar"]