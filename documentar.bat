::
::  Nombre: documentar.bat
::  Descripción: Script que crea el JavaDoc del juego
::  Organización: Universidad de Burgos
::  @author: Enrique Saiz
::  @author: Mario Alonso
::  @date: 15/11/2024
::  @version: 1.0
::  @license: MIT
::

:: Documentar el juego
javadoc -encoding UTF-8 -link https://docs.oracle.com/en/java/javase/22/docs/api/ -sourcepath ./src -author -d doc -subpackages noventagrados

:: Pausar la consola para poder ver los resultados.
pause