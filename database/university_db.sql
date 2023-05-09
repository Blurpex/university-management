DROP TABLE IF EXISTS classroom;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS section;
DROP TABLE IF EXISTS teaches;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS takes;
DROP TABLE IF EXISTS advisor;
DROP TABLE IF EXISTS prerequisite;
DROP TABLE IF EXISTS timeslot;

CREATE TABLE classroom
(
    building    VARCHAR(20),
    room_number VARCHAR(7),
    capacity    INT CHECK (capacity >= 0),
    PRIMARY KEY (building, room_number)
);

CREATE TABLE department
(
    dept_name VARCHAR(20),
    building  VARCHAR(20),
    budget    NUMERIC(12, 2) CHECK (budget > 0),
    PRIMARY KEY (dept_name)
);

CREATE TABLE course
(
    course_id VARCHAR(8),
    title     VARCHAR(50),
    dept_name VARCHAR(20),
    credits   INT CHECK (credits > 0),
    PRIMARY KEY (course_id),
    FOREIGN KEY (dept_name) REFERENCES department (dept_name) ON DELETE SET NULL
);

CREATE TABLE instructor
(
    id        INT AUTO_INCREMENT,
    name      VARCHAR(20) NOT NULL,
    dept_name VARCHAR(20),
    salary    NUMERIC(8, 2) CHECK (salary > 0),
    PRIMARY KEY (id),
    FOREIGN KEY (dept_name) REFERENCES department (dept_name) ON DELETE SET NULL
);

CREATE TABLE section
(
    course_id    VARCHAR(8),
    sec_id       INT,
    semester     VARCHAR(6) CHECK (semester IN ('FALL', 'WINTER', 'SPRING', 'SUMMER')),
    year         YEAR CHECK (year > 1855 and year < 2100),
    building     VARCHAR(20),
    room_number  VARCHAR(7),
    time_slot_id VARCHAR(4),
    PRIMARY KEY (course_id, sec_id, semester, year),
    FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE,
    FOREIGN KEY (building, room_number) REFERENCES classroom (building, room_number) ON DELETE SET NULL
);

CREATE TABLE teaches
(
    id        INT,
    course_id VARCHAR(8),
    sec_id    INT,
    semester  VARCHAR(6),
    year      YEAR,
    PRIMARY KEY (id, course_id, sec_id, semester, year),
    FOREIGN KEY (id) REFERENCES instructor (id) ON DELETE CASCADE,
    FOREIGN KEY (course_id, sec_id, semester, year) REFERENCES section (course_id, sec_id, semester, year) ON DELETE CASCADE
);

CREATE TABLE student
(
    id         INT AUTO_INCREMENT,
    name       VARCHAR(50) NOT NULL,
    dept_name  VARCHAR(20),
    total_cred INT CHECK (total_cred >= 0),
    PRIMARY KEY (id),
    FOREIGN KEY (dept_name) REFERENCES department (dept_name) ON DELETE SET NULL
);

CREATE TABLE takes
(
    id        INT,
    course_id VARCHAR(8),
    sec_id    INT,
    semester  VARCHAR(6),
    year      YEAR,
    grade     VARCHAR(2),
    PRIMARY KEY (id, course_id, sec_id, semester, year),
    FOREIGN KEY (course_id, sec_id, semester, year) REFERENCES section (course_id, sec_id, semester, year) ON DELETE CASCADE,
    FOREIGN KEY (id) REFERENCES student (id) ON DELETE CASCADE
);

CREATE TABLE advisor
(
    student_id    INT,
    instructor_id INT,
    PRIMARY KEY (student_id),
    FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE,
    FOREIGN KEY (instructor_id) REFERENCES instructor (id) ON DELETE SET NULL
);

CREATE TABLE prerequisite
(
    course_id       VARCHAR(8),
    prerequisite_id VARCHAR(8),
    PRIMARY KEY (course_id, prerequisite_id),
    FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE CASCADE,
    FOREIGN KEY (prerequisite_id) REFERENCES course (course_id)
);

CREATE TABLE timeslot
(
    time_slot_id VARCHAR(4),
    day          VARCHAR(1) CHECK (day IN ('M', 'T', 'W', 'R', 'F', 'S', 'U')),
    start_time   TIME,
    end_time     TIME,
    PRIMARY KEY (time_slot_id, day, start_time)
);

