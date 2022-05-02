FROM openjdk:16.0.1

ADD ./src/ /app/

WORKDIR /app

RUN mkdir classes

RUN javac -d classes main/java/*.java

RUN setenv DISPLAY :0.0

CMD ["java", "-cp", "./classes:./main/resources", "main.java.Main"]

