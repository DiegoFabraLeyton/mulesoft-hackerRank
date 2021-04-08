# mulesoft-hackerRank
RPT - Command Processor

Implementación de ejercicio de HackerRank

El proyecto está basado sobre Clean Architecture. Tiene un folder con los casos de uso para este ejercicio
que son

 1 . mkdir -> Crear Folder
 2 . touch -> Crear Archivo
 3 . pwd   -> Obtener el path al Folder actual
 4 . ls    -> Listar todos los archivos
 5 . cd    -> Cambiar de Folder
 
 Desafios.
 
 Estructura para manejar el cambio de folder. La estructura esta hecha con el patrón composite, 
 pero me falto colocar alguna referencia hacia el padre de cada noda.
 Al seguir con esa idea se me dificultó  hacer el cambio de folder hacia adelante y hacia atras.
 
 Falto implementar inyección de dependencias para trabajar solo con las interfaces, pero en la clase Main quedaron inicializados
 
 Falto implementar unit-test, falta de tiempo
 
 
