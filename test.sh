#! /bin/sh

eval $(cat .env | sed 's/^/export /') && mvn verify && mvn test
