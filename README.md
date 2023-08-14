# TextClient Project

This project provides a simple text-based client for testing REST endpoints by mapping the results to defined classes. This client is intended to assist external consultants in testing against various endpoints by allowing them to input the endpoint and the desired target class.

## Configuration

- Review the configuration files and classes in the project to customize the client to your needs.
- Ensure all necessary dependencies are included in `build.gradle` (for Gradle).

## Dependencies

This project uses the following dependencies:

- Spring Boot
- Lombok
- Reactor Core
- Spring WebClient

## Key Classes

- `TextClient`: The main class responsible for fetching data from endpoints and mapping them to classes.
- `RestUtil`: A utility class handling HTTP requests and error handling.


## How to Use the Client

1. Clone this project to your local machine.
2. Open the project in a suitable IDE.
3. Familiarize yourself with the `RestUtil` class, which contains the main logic for fetching data from REST endpoints and mapping them to classes.
4. Run the `TextClient` class either from your IDE or by building and running the project from the command line.


    private void fetchData() {
        restUtil.get(Kommune.class, "/felles/kodeverk/kommune")
        .doOnNext(l -> log.info(String.valueOf(l)))
        .doOnError(throwable -> restUtil.handleErrorResponse(throwable))
        .subscribe();
        }