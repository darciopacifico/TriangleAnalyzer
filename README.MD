Triangle Analyzer
=================
### Disclaimer:
This little app analyzes a triad of console inputs, each one representing a triangle side, 
then print which kind of triangle that inputted.

## Design choices
This app was constructed using two layers:

A simple console interface, capable to interact with terminal user, collect and validate 
entries, call a core component for triangle analysis, then translates core response 
as a human readable response in console.

The in/out dependency of console component should be passed in the constructor.
In order to start in/out streams consumption, a blocker startConsole() method should be called. This design decision allows the console componente to be fully tested, mocking InputStream and PrintoutStream objects.

A core triangle analyzer component, designed as a util class, with no public constructor and 
a single static method for triangle analysis.

# Running

## Requirements
Maven 2 for compile, tests and assembly of a jar file.

## Run
  mvn exec:java  -> direct from maven console
  
  mvn install, then 

## Tests & Coverage
**Running tests**

    
**Generating Coverage**

