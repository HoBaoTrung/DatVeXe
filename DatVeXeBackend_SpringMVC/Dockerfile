# Sử dụng image của Maven để build ứng dụng
# Bước 1: Build ứng dụng bằng Maven và JDK 14
FROM maven:3.6.3-jdk-14 AS build

# Đặt thư mục làm việc là /app
WORKDIR /app

# Sao chép file pom.xml vào container và download dependencies (tăng tốc độ build lần sau)
COPY pom.xml .
RUN mvn dependency:go-offline

# Sao chép toàn bộ mã nguồn vào container
COPY src ./src

# Build ứng dụng, kết quả sẽ nằm trong thư mục target/
RUN mvn clean package -DskipTests

# Bước 2: Deploy ứng dụng lên Tomcat
FROM tomcat:9.0-jdk14-openjdk-slim

# Xóa các ứng dụng mặc định của Tomcat (như trang chủ mặc định)
RUN rm -rf /usr/local/tomcat/webapps/*

# Sao chép file .war đã build từ bước build vào thư mục webapps của Tomcat
COPY --from=build /app/target/DatVeXeBackend-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 để truy cập ứng dụng
EXPOSE 8080

# Khởi động Tomcat
CMD ["catalina.sh", "run"]
