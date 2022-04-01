# LenioTech
In this repository you can find the implementation of the technical test. Specifically the implementation of Automation point part 1 and part 2.
## Tech Notes
This implementation contains:
* URLs and Authentication info read it from a properties file
* Allure reporter added. You can run it with "allure serve"
* Soft assertions to validate several asserts
* JSON Schema validation
* Implementation of framework to HTTP requests to BE tests.
* Suite implementation to run all challeneg at once.
* POM pattern applied to FE tests.

## Run
1. open a terminal and execute "mvn clean install"
2. Execute "mvn test"
3. To see reporting "allure serve"

