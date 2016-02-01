#!/bin/bash

if [ $# -ne 2 ]; then
	echo "Usage: ./publish.sh <apikey> <version>"
	exit 1
fi

./pushToBintray.sh dragos $1 dragos typesafe-config-eclipse typesafe-config-eclipse $2 com.typesafe.hocon.updatesite/target/repository
