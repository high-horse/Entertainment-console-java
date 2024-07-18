# College Entertainment Console

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributors](#contributors)
- [License](#license)

## Introduction
The College Entertainment Console is a semester project developed in core Java. It aims to provide a centralized platform for students to access various entertainment options, including music, movies, and games. This console offers a user-friendly interface and integrates multiple entertainment services using a MySQL database.

## Features
- **Music Player**: Stream and play your favorite music.
- **Movie Library**: Browse and watch a collection of movies.
- **Game Zone**: Access and play a variety of games.
- **User Profiles**: Create and manage user profiles to personalize your entertainment experience.
- **Search Functionality**: Easily search for music, movies, and games.
- **Favorites**: Save your favorite music, movies, and games for quick access.
- **Offline Mode**: Enjoy your entertainment even without an internet connection.

## Installation
1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/college-entertainment-console.git
   ```
   
   
2. **Navigate to the Project Directory**
   ```bash
   cd college-entertainment-console
   ```
   
3. **Set Up the MySQL Database**
- Install MySQL if not already installed.
- Create a new database.
- Execute the SQL script provided in database/schema.sql to set up the necessary tables.
- Update the database connection details in the config.properties file.


4. **Clone the Repository**
   ```bash
   javac -cp .:mysql-connector-java-8.0.23.jar src/com/yourproject/*.java
   ``` 
   
   
4. **Run the Application**
   ```bash
   java -cp .:mysql-connector-java-8.0.23.jar com.yourproject.Main
   ``` 
   
