CREATE DATABASE db_my_batis_homework002;

CREATE TABLE instructors (
    instructor_id SERIAL PRIMARY KEY ,
    instructor_name VARCHAR(50) NOT NULL ,
    email VARCHAR(250) NOT NULL
);

CREATE TABLE courses (
    course_id SERIAL PRIMARY KEY ,
    course_name VARCHAR(250) NOT NULL ,
    description TEXT,
    instructor_id INT REFERENCES instructors(instructor_id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE students (
    student_id SERIAL PRIMARY KEY ,
    student_name VARCHAR(50) NOT NULL ,
    email VARCHAR(250) NOT NULL ,
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE student_course (
    id SERIAL PRIMARY KEY ,
    student_id INT REFERENCES students(student_id) ON DELETE CASCADE NOT NULL ,
    course_id INT REFERENCES courses(course_id) ON DELETE CASCADE NOT NULL
);