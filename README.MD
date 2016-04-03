Triangle Analyzer
=================
This little app analyzes a triad of console inputs, each one representing a triangle side, 
then print which kind of triangle was inputted.

### Disclaimer:
- There is some known issues in floating points comparisons that this app would not be designed to deal with.
- This app deliberately deals with system In/Out java objects. Some issues could be warned by code analysis tools!

## Design choices
This app was constructed using two layers:

1- A simple console interface, capable to interact with terminal user, collect and validate 
entries, call a core component for triangle analysis, then translates core response 
as a human readable response in console.

The in/out dependency of console component should be passed in the constructor.
In order to start in/out streams consumption, a blocker startConsole() method should be called. This design decision allows the console componente to be fully tested, mocking InputStream and PrintoutStream objects.

2- A core triangle analyzer component, designed as a util class, with no public constructor and 
a single static method for triangle analysis.

# Running

## Requirements
  Maven 2 for compile, tests and assembly of a jar file.

## Run
Direct from maven console
mvn exec:java

As a fat jar:
mvn install
java -jar target/triangle-analyzer-1.0-jar-with-dependencies.jar 

## Tests & Coverage
**Running tests**
  mvn test
    
**Generating Coverage**
  mvn cobertura:cobertura
  open target/site/cobertura/index.html
