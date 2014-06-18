#!/usr/bin/env bash

cd src
javac -d ../bin type/*.java
cd ../bin
java type.Type_master
