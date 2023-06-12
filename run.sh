#!/bin/sh

eval $(cat .env | sed 's/^/export /') && mvn spring-boot:run
