# Application Architecture
> How the application has been structured . . .

## Application "Layers"
In this context the term "Layer" means unique part of the application. You can think of a layer as a directory within the source code that contains code that corresponds to functionality that has been delegated to that layer to handle. For example our online ordering application has the following 3 layer architecture:
 - Repository:
   - This layer is responsible for all data access code. All SQL queries, Stored Procedure calls and any calls to an external persistence mechanism need to happen here in this layer.
 - Service:
   - This layer is for implementing business rules and data processing. This communicates to the Repository layer to get data to process.
 - Presentation

