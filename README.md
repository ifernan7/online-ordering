# ordering-ordering
> This is an Online Retail Store themed Educational Spring Boot application made for DePaul University's SE-452 Object-Oriented Enterprise Computing Course. The following students worked on the application:
> - Ismael Fernandez
> - Sebastian Krawiec
> - Dilip Sai Reddy Mettu
> - Jay Kukadiya

## Milestone 1
### High-Level Requirements
The application should have the following functionality:
- Warehouse Functionality:
  - Since this is a school project, we only need a way to display and create warehouses.
  - Displaying and creating warehouse functionality would create enough tasks across the entire application.
  - There will be no updating or deleting warehouse functionality, as this would increase complexity and require much more work. If time allows, additional tasks can be created to implement this functionality.

- Maintain a Catalog of Products:
  - Page to Create a Product:
    - Products need to be stocked in the warehouse.
    - All product data must be entered into the system.
    - Each product should be unique.
  - Page to Update a Product:
    - You can't update information for an already existing product.
    - Updated information must be complete; no empty fields allowed.
  - Page to Delete a Product:
    - A confirmation is needed to confirm the deletion of a product.

- Order Products:
  - Page to Create an Order:
    - A limit should be set on the number of product quantities that can be ordered.
    - Products must be in stock in the warehouse before they can be ordered.
  - Page to Update an Order:
  - Page to Delete an Order:
    - If an order is deleted, we need to ensure that the product is returned to the warehouse.

### Contribution Summary
| Name                  | Contribution                                                                                          |
|-----------------------|-------------------------------------------------------------------------------------------------------|
| Ismael Fernandez      | Create Application base, implemented simple 3 layer architecture. Helped with High-Level Requirements.|
| Sebastian Krawiec     | Created High-Level Requirements.                                                                      |
| Dilip Sai Reddy Mettu | Helped with High-Level Requirements.                                                                  |
| Jay Kukadiya          | Nothing, has not responded to communications.                                                         |

## Milestone 2
### Architecture Agreement
The following team members agree to be graded on an INDIVIDUAL BASIS based on project structure refactoring.
- [X] Ismael Fernandez 
- [X] Sebastian Krawiec 
- [X] Dilip Sai Reddy Mettu 
- [ ] Jay Kukadiya

### Database Diagram
![Database Diagram](docs/images/database-diagram.png)

### GitHub Issues Sample
![GitHub Issues Sample](docs/images/github-issues-for-task-managment.png)

### Discussion of how our Design met the Requirements
~ temp ~

### Contribution Summary
| Name                  | Contribution                                                                                                                                                                                                                                                       |
|-----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Ismael Fernandez      | Refactored application architecture to lend itself to grading on an individual basis. Created Database ddl and seed scripts. Implemented basic User CRUD functionality. Also started to use GitHub issues for task management for all tasks for all group members. |
| Sebastian Krawiec     | Implemented CRUD functionality for the Product Repository allowing for the creation, selection, modification, and deletion of a product to the server's Database.                                                                                                  |
| Dilip Sai Reddy Mettu |                                                                                                                                                                                                                                                                    |
| Jay Kukadiya          |                                                                                                                                                                                                                                                                    |
