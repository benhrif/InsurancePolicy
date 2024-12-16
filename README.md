Overview

This repository contains the Insurance Policy Management API, which allows users to manage insurance policies.
This guide will help you set up and run the application using Docker Compose with a PostgreSQL database.

Prerequisites

Before you begin, ensure you have the following installed:

•	Docker

Steps to Run the Application via Docker Compose

1.	Clone the Repository
2.	Navigate to the Project Directory
4.	Run Docker Compose Use the following command to start the application:  docker-compose up --build
This command will build the Docker images and start the containers defined in the docker-compose.yml file.
5.	Access the API Once the containers are up and running, you can access the API at:  http://localhost:9090/api/policies
