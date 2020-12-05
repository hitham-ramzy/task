#!/bin/bash

echo Hello, Enter your MYSQL user.
read USER

echo Hello, Enter the PASSWORD.
read PASS

mysql -u${USER} -p${PASS} -e "CREATE DATABASE IF NOT EXISTS retail_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;"
