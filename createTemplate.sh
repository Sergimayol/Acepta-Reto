#! /bin/bash

# This script is used to generate a java template
# It takes the the name of the file and the output
# and the output of it

# Check if the user has entered the correct number of arguments
if [ $# -ne 2 ]; then
  echo "Usage: $0 <filename> <output>"
  exit 1
fi

# Check if the file exists
if [ -f $1 ]; then
  echo "File already exists"
  exit 1
fi

# Check if the output directory exists
if [ ! -d $2 ]; then
  echo "Output directory does not exist"
  exit 1
fi

# Copy the template of templates/FastReader.java to the output directory
cp templates/FastReader.java $2/$1.java

# Replace the name of the class with the name of the file
sed -i "s/FastReader/$1/g" $2/$1.java

# Replace the name of the package with the name of the file
sed -i "s/package Templates;/package $1;/g" $2/$1.java
