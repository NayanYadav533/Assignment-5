# Assignment-5
Rest API using spring framework with dockerization<br>

# ABOUT
We have implemented customer order record web service with JSON database, in which there are 4 API endpoints as below:<br>
1. customers/ - This API returns all the customer details present in the database.<br>
2. customers/{customerId} - This API returns details of customer belongs to customerId. It will display customer infromation like name, address, email address, mobile number and number of orders placed by customer. <br>
3. customers/{customerId}/orders  - This API returns order details of a customer id. It will display order id, total amount, purchase date.<br>
4. customers/{customerId}/orders/{orderId} - This API returns specific order details of a particular order id. It displays order id, total amount, purchase date and all item details.<br>

# Prerequisite 
Maven, Docker<br>

# How to Build and Run 
Step 1 -  Clone repository in your local system.<br>
Step 2 - Open command prompt into project folder path.<br>
Step 3 - Run the command "mvn clean install". This command will build the project.<br>
Step 4 - Run the command "docker build -t springio/customer-order". This will create an image of web service.<br>
Step 5 - Run the command "docker run -p 8080:8080 springio/customer-order". This will run the image into an container and will expose it on 8080 port.<br>
Step 6 - Open your browser and run the link "http://localhost:8080". Now you will be able to access the web service.<br>
