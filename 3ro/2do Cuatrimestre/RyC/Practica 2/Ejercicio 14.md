## Utilizando curl, acceda al sitio www.redes.unlp.edu.ar/restringido/index.php y siga las instrucciones y las pistas que vaya recibiendo hasta obtener la respuesta final. Será de utilidad para resolver este ejercicio poder analizar tanto el contenido de cada página como los encabezados.

Pasos:
1. Solicitud: 
```bash
curl www.redes.unlp.edu.ar/restringido/index.php
```
  - Respuestra: 
```html
<h1>Acceso restringido</h1>
<p>Para acceder al contenido es necesario autenticarse. Para obtener los datos de acceso seguir las instrucciones detalladas en www.redes.unlp.edu.ar/obtener-usuario.php</p>
```
2. Solicitud:
```bash
curl www.redes.unlp.edu.ar/obtener-usuario.php
```
  - Respuesta:
```html
<p>Para obtener el usuario y la contraseña haga un requerimiento a esta página seteando el encabezado 'Usuario-Redes' con el v alor 'obtener '</p>
```
3. Solicitud:
```bash
curl -H "Usuario-Redes: obtener" www.redes.unlp.edu.ar/obtener-usuario.php
```
  - Respuesta:
```html
<p>Bien hecho! Los datos para ingresar son: 
Usuario: redes 
Contraseña: RYC 

Ahora vuelva a acceder a la página inicial con los datos anteriores. 

PISTA: Investigue el uso del encabezado Authorization para el método Basic. El comando base64 puede ser de ayuda!</p>
```



> La cabecera de petición `Authorization` contiene las credenciales para autenticar a un usuario en un servidor, usualmente luego de que el servidor haya respondido con un estado `401 Unauthorized` y en la cabecera `WWW-Authenticate`.
> <tipo> -> Tipo de Autenticación. Un tipo común es `Basic`. 
> <credenciales> -> Si se utiliza el esquema de la autenticación `Basic`, las credenciales son construidas de esta forma: El usuario y la contraseña se combinan con dos puntos (`aladdin:opensesame`). El string resultante está basado en la codificación base64 (`YWxhZGRpbjpvcGVuc2VzYW1l`)
> Ejemplo: `Authorization: Basic YWxhZGRpbjpvcGVuc2VzYW1lW`

> redes:RYC * base64 -> cmVkZXM6UllD

4. Solicitud: 
```bash
url -H "Authorization: Basic cmVkZXM6UllD" www.redes.unlp.edu.ar/restringido/index.php
```
  - Respuesta:
```html
<h1>Excelente!</h1>
<p>Para terminar el ejercicio deberás agregar en la entrega los datos que se muestran en la siguiente página.</p> 

<p>ACLARACIÓN: la URL de la siguiente página está contenida en esta misma respuesta.</p>
```
5. Solicitud:
```bash
curl -I -H "Authorization: Basic cmVkZXM6UllD" www.redes.unlp.edu.ar/restringido/index.php
```
  - Respuesta:
```bash
HTTP/1.1 302 Found
Date: Wed, 03 Sep 2025 21:43:46 GMT
Server: Apache/2.4.56 (Unix)
X-Powered-By: PHP/7.4.33
Location: http://www.redes.unlp.edu.ar/restringido/the-end.php
Content-Type: text/html; charset=UTF-8
```
6. Solicitud:
```bash
curl -H "Authorization: Basic cmVkZXM6UllD" www.redes.unlp.edu.ar/restringido/the-end.php 
```
  - Respuesta:
```
¡Felicitaciones, llegaste al final del ejercicio!
Fecha: 2025-09-03 21:44:13
Verificación: 55015da38b1374b26fdf67bef81e2f3add1f3b87c674ba1a510758de25db061d
```