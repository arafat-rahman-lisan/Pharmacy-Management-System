#!/bin/sh
set -eu
cd "$(dirname "$0")"
mkdir -p build
javac -encoding UTF-8 -d build Start.java frames/*.java entities/*.java interfaces/*.java repositories/*.java
jar cfe Start.jar Start -C build .
