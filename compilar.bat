::
::  Nombre: compilar.bat
::  Descripción: Script para compilar el juego
::  Organización: Universidad de Burgos
::  @author: Enrique Saiz
::  @author: Mario Alonso
::  @date: 15/11/2024
::  @version: 1.0
::  @license: MIT
::

:: Crear la carpeta si no existe
if not exist "bin" mkdir bin

javac -classpath .\bin;.\lib\* ^
-encoding UTF-8 ^
-d bin ^
-sourcepath .\src ^
.\src\noventagrados\control\*.java ^
.\src\noventagrados\control\undo\*.java ^
.\src\noventagrados\modelo\*.java ^
.\src\noventagrados\textui\*.java ^
.\src\noventagrados\textui\excepcion\*.java ^
.\src\noventagrados\util\*.java 


:: Pausar la consola para poder ver los resultados.
pause