FROM openjdk:17
EXPOSE 8080
COPY target/loan-repayment-springboot-images.jar loan-repayment-springboot-images.jar
ENTRYPOINT ["java","-jar","/loan-repayment-springboot-images.jar"]