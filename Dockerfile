# Установка базового образа
FROM adoptopenjdk:17-jdk-hotspot

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копирование исходного кода проекта в контейнер
COPY . /app

# Копирование файла application.properties
COPY src/main/resources/application.properties /app/src/main/resources/application.properties

# Копирование скрипта базы данных
COPY src/main/resources/sql/init.sql /app/src/main/resources/sql/init.sql

# Копирование собранного JAR-файла
COPY build/libs/*.jar /app/application.jar

# Команда для запуска вашего приложения
CMD ["java", "-jar", "/app/application.jar"]