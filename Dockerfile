FROM ubuntu:16.04

LABEL "version"="1.0"
LABEL "maintainer"="1157790064@qq.com"

WORKDIR /dd-oj

RUN apt update && \
	apt install -y git && \
	apt install -y openjdk-8-jre && \
	apt install -y openjdk-8-jdk && \
	apt install -y maven && \
	apt install -y curl && \
	curl -sL https://deb.nodesource.com/setup_8.x | bash - && \
	apt install -y nodejs && \
	git clone https://github.com/zhengdayday/dd-oj-web.git && \
	git clone https://github.com/zhengdayday/dd-oj-api.git && \
	cd dd-oj-web && \
	npm install && \
	npm run build && \
	mv dist/* ../dd-oj-api/dd-oj-web/src/main/resources/public/ && \
	cd ../dd-oj-api && \
	mvn clean package && \
	mv dd-oj-web/target/dd-oj-web-1.0.jar /dd-oj && \
	cd /dd-oj && \
	apt clean && \
	rm -rf dd-oj-api && \
	rm -rf dd-oj-web && \
	apt remove -y git && \
	apt remove -y maven && \
	apt remove -y nodejs && \
	apt remove -y openjdk-8-jdk && \
	rm -rf /root/.m2 && \
	rm -rf /root/.npm

VOLUME ["/dd-oj/data"]

# ENV MYSQL_URL=localhost:3306 MYSQL_DATABASE=dd_oj MYSQL_USERNAME=root MYSQL_PASSWORD=2466040aa

CMD ["java", "-Dspring.profiles.active=prod", "-jar", "dd-oj-web-1.0.jar"]

EXPOSE 8080