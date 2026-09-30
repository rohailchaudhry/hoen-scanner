# Hoen Scanner microservice

Implementation for the Skyscanner Forage backend task, built on
https://github.com/vagabond-systems/hoen-scanner.

## Install these changes

Fork the starter repository. Copy the supplied `src` folder into the root of your
fork, replacing `HoenScannerApplication.java` and adding the other three classes.
Keep the starter's `pom.xml`, `config.yml`, `HoenScannerConfiguration.java`, and
the original `src/main/resources/hotels.json` and `rental_cars.json` files.
This update archive is not a standalone Maven project.

## Build and run

Use OpenJDK 19 as specified by the task and Maven. From the repository root:

```bash
mvn clean package
java -jar target/hoen-scanner-1.0-SNAPSHOT.jar server config.yml
```

The application loads both JSON resource files before registering `POST /search`.
It returns matching hotels and rental cars as a JSON array containing city, kind,
and title. Matching ignores letter case and surrounding spaces. An unknown city
returns an empty array. A missing, null, or blank city returns HTTP 400.

## Check the API

Leave the server running. In Postman select POST, use
`http://localhost:8080/search`, select Body -> raw -> JSON, and send:

```json
{"city":"petalborough"}
```

Repeat for `rustburg` and `shaleport`. Verify the returned city values and compare
the titles and kinds with both original resource files. Check `unknown-city`
returns `[]` and `{}` returns HTTP 400. Uppercase `PETALBOROUGH` should return the
same matches as lowercase.

Equivalent terminal request:

```bash
curl -i -X POST http://localhost:8080/search -H 'Content-Type: application/json' -d '{"city":"petalborough"}'
```

## Verification status

The source was reviewed against the starter's Dropwizard 4 scaffolding. Maven
compilation and live HTTP checks have not been executed in the preparation
environment. Run the checks above before claiming a tested submission.
