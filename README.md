# Basic Selenium Framework Design

This is a simple Java Selenium automation framework using TestNG and Maven.

## Project Structure
- `src/main/java` - Main source code (page objects, utilities, etc.)
- `src/test/java` - Test cases (if present)
- `testng.xml` - TestNG suite configuration
- `pom.xml` - Maven project file

## Prerequisites
- Java (JDK 8 or above)
- Maven


## How to Execute Tests
1. Open a terminal in the project root directory.
2. Run the following command to execute all tests:

    mvn clean test

This will execute all TestNG tests as defined in `testng.xml`.

## Tag-Based Execution
To run only specific groups of tests (using tags), use the `tagBasedExecution.xml` file. For example:

    mvn clean test -DsuiteXmlFile=tagBasedExecution.xml

Edit `tagBasedExecution.xml` to include or exclude the tags/groups you want to run.

## Reports
- Test execution reports are generated in the `test-output/` and `Extent-Reports/` folders after running the tests.

## GitHub Actions CI
A GitHub Actions workflow is included at `.github/workflows/manual-selenium-execution.yml`.

To run tests manually from GitHub:
1. Open the repository in GitHub.
2. Go to the `Actions` tab.
3. Choose `Manual Selenium Execution`.
4. Click `Run workflow`.
5. Optionally set `suiteXmlFile` and `browserFlag`.

After the workflow completes, download the generated report artifact named `selenium-reports-<run_id>`.

---
No test case creation rules are included in this README as per your request.
