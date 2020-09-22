#!/bin/bash

find . -name *.java > sources.txt
javac  @sources.txt
java launcher.Stimulator $1 