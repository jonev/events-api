#!/bin/bash
./gradlew bootJar

sudo docker build -t jonev/home-hosting:events-api .
sudo docker push jonev/home-hosting:events-api