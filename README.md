Dynamic Blog Platform

Overview
- The Dynamic Blog Platform is a web application that allows users to create, edit, and delete blog posts. It features a backend built with Spring Boot 
  and a frontend developed using HTML, CSS, and JavaScript. The project uses a MySQL database for data storage.

Features
 - Create Blog Post**: Users can submit a new blog post through a form.
 - Delete Blog Post**: Users can delete blog posts.
 - All blog posts are displayed on the main page.

Technologies used 
 - Backend : Spring Boot
 - Frontend : HTML, CSS, Javascript
 - Database : MySQL

Prerequisites
 - Java 11 or higher
 - MySQL Server
 - Spring Boot

Database Setup
- The project uses MySQL as its database. Here are the details:
 - Database Name:  blog_platform
 - Table Name: blog_data

Spring Boot Application Configuration
 - spring.datasource.url=jdbc:mysql://localhost:3306/blog_platform
 - spring.datasource.username=your_username
 - spring.datasource.password=your_password
 - spring.jpa.hibernate.ddl-auto=update

As the ports are different for spring boot application and frontend site. I have CORS
i.e. Cross-Origin Resource Sharing 

Ensure that MySQL server is running and accessible with the provided credentials.
