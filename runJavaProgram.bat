@echo off
REM Delete all .class files in the directory
del /s /q *.class

REM Compile the Java files, including subdirectories
javac -d . *.java

REM Create the JAR file, including all .class files in subdirectories
"C:\Program Files\Java\jdk-21\bin\jar.exe" cfm Start.jar MANIFEST.MF -C . .

REM Run the JAR file
java -jar Start.jar

REM Pause to keep the command prompt open
pause
