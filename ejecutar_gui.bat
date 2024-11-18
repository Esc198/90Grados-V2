::
::  Nombre: ejecutar_gui.bat
::  Descripción: Script para poder jugar al juego a través de la interfaz gráfica 
::  Organización: Universidad de Burgos
::  @author: Enrique Saiz
::  @author: Mario Alonso
::  @date: 15/11/2024
::  @version: 1.0
::  @license: MIT
::

:: Ejecución del juego con la interfaz gráfica 
java -cp ./bin;./lib/noventagrados-gui-lib-2.0.0.jar noventagrados.gui.NoventaGrados arbitros

:: Pausar la consola para poder ver los resultados.
pause
