## ¿Cuál es la diferencia entre un protocolo binario y uno basado en texto? ¿De qué tipo de protocolo se trata HTTP/1.0, HTTP/1.1 y HTTP/2?

Un protocolo binario comunica informacion entre un emisor y receptor medainte bits, normalmente de a bytes. En cambio un protocolo basado en texto utiliza caracteres legibles, utilizando ASCII.

HTTP/1.0 y HTTP/1.1 son protocolos basados en texto y utilizan caracteres ASCII para las cabeceras (headers) y los metodos (GET, POST, etc.).

HTTP/2, en cambio, no está basado en texto, sino que es un protocolo binario. Introduciendo frames binarios para encapsular mensajes, cabeceras y datos. Mejorando la eficiencia y reduce la sobrecarga en comparación con el formato textual de HTTP/1.0 y HTTP/1.1
