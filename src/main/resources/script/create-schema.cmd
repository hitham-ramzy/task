#!/bin/bash

echo Hello, Enter your MYSQL user.
read USER

echo Hello, Enter the PASSWORD.
read PASS

mysql -u${USER} -p${PASS} -p retail_db < retail_db.sql
