@echo off
cd /d "%~dp0"
where java >nul 2>nul
if errorlevel 1 (
  echo Java is not installed or not on PATH. Install Java 8 or newer.
  pause
  exit /b 1
)
java -jar Start.jar
if errorlevel 1 pause
