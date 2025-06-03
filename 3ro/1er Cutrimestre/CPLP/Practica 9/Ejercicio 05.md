## La propagación de los errores, cuando no se encuentra ningún manejador asociado, no se implementa igual en todos los lenguajes. Realice la comparación entre el modelo de Java, Python y PL/1, respecto a este tema.

Java utiliza semántica de terminación. Cuando se lanza una excepción no manejada, el entorno de ejecución desenrolla la pila de llamadas hasta encontrar el manejador catch adecuado. Si ningún manejador captura la excepción, el hilo de ejecución se termina y se muestra un rastreo de pila. 

Similar a Java, Python usa semántica de terminación. Las excepciones no capturadas propagan hacia arriba en la pila. Si no hay un bloque except que las maneje, el intérprete Python termina la ejecución y muestra un traceback con detalles del error.

PL/I emplea semántica de reanudación. Al ocurrir un error (llamado "condición"), el sistema busca una unidad ON asociada. Si existe, vuelve al punto exacto del error después de ejecutar el manejador, permitiendo corregir el estado y continuar. Si no hay manejador, el comportamiento depende del entorno (ej. finalización o comportamiento indefinido)