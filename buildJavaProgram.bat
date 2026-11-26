@echo off
cd /d "%~dp0"
if not exist build mkdir build
javac -encoding UTF-8 -d build Start.java frames\*.java entities\*.java interfaces\*.java repositories\*.java
if errorlevel 1 goto failed
jar cfe Start.jar Start -C build .
if errorlevel 1 goto failed
echo Build successful.
pause
exit /b 0
:failed
echo Build failed. Verify your JDK is installed and on PATH.
pause
exit /b 1
