# CelebrityProblem

This project was built by using Spring Boot, using gradle as the project builder. The exercise is proposed as a REST service, using a Controller class as an entry point.

Dependency Injection can be seen when an Orchestator class is injected into that Controller. Orchestator class handles the exercise resolution,
as it has a public access method called execute, given in an IOrchestator interface. This execute method invokes two private methods: readInputFile method, which is in charge of reading from a txt file, and returns a matrix which represents the people who is going to be asked about the celebrity.

Once the matrix is returned, the execute method invokes the second private method called findTheCelebrity, which evaluates the matrix by using a list.
The idea into this method is discarding people once pair ones are chosen until one person on the list is remaining, this person is represented with
an integer. Then, the matrix values are compared with the celebrityId obtained from the discarding operations. The conditions of 
anyone does know the celebrity and the celebrity does not know anyone are reviewed in here.

There are Test class for Controller and Orchestator classes.

    