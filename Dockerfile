# Установка базового образа
FROM eclipse-temurin:17-jdk

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копирование исходного кода проекта в контейнер
COPY . /app

# Копирование файла application.yaml
COPY src/main/resources/application.yaml /app/src/main/resources/application.yaml

# Копирование файла init.sql
COPY src/main/resources/sql/init.sql /docker-entrypoint-initdb.d/init.sql

# Копирование собранного JAR-файла
COPY build/libs/*.jar /app/application.jar

# Команда для запуска вашего приложения
CMD ["java", "-jar", "/app/application.jar"]