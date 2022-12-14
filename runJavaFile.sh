#! /bin/bash

# This script is used to run a java file
# It takes the name of the java file as an argument
# It compiles the java file and runs it

# Check if the argument is given
if [ $# -eq 0 ]; then
    echo "No argument supplied to the script\n Usage: ./runJavaFile.sh <java file name>"
    exit 1
fi

# Check if the file exists
if [ ! -f $1 ]; then
    echo "File $1 does not exist"
    exit 1
fi

# Check if the file is a java file
if [[ $1 != *.java ]]; then
    echo "File $1 is not a java file"
    exit 1
fi

# Compile the java file
javac $1

# Run the java file
java ${1%.*}

# Remove the class file
rm ${1%.*}.class

# Remove other class files
# Get the path of the java file
path=$(dirname $1)

# Remove the class files
rm $path/*.class
