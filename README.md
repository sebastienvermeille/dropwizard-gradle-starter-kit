# Dropwizard starter kit with Gradle

Simply fork and play with ;)

Currently using dropwizard version: 1.3.0 and Java8


PR welcome if you want to contribute to this starter pack

## Build

**Gradlew variant (recommended) :**

Run: `./gradlew shadowJar`

**Gradle variant:**

Run: `gradle shadowJar`

## Run

Run `java -jar build/libs/dropwizard-starter-kit.jar server config.yml`

## Test

* [login anonymous](http://localhost:8080/hello-world)

* [login alfred](http://localhost:8080/hello-world?name=Alfred)

* [View metrics](http://localhost:8081/)