CREATE USER 'truplat_user'@'localhost' IDENTIFIED BY 'truplat123';
CREATE DATABASE truplat;
GRANT ALL PRIVILEGES ON truplat.* TO 'truplat_user'@'localhost';