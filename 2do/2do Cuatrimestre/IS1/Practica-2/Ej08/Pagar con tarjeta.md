## ID: Pagar con tarjeta
### TITULO: Como usuario, quiero pagar con tarjeta, para obtener mi código de compra.
Reglas de Negocios: El pago se realiza con tarjetas de credito. La tarjeta debe tener fondos suficientes.

## Criterios de Aceptación (Pagar con tarjeta)

### Escenario 1: Autorización exitosa.
- Dado: Que la conexión con los servidores del banco es exitosa y que el código “1234”, que la fecha de vencimiento “12/26” y el código de seguridad “321” corresponden a una tarjeta de crédito con fondos suficientes.
- Cuando: El usuario ingrese el código “1234”, la fecha de vencimiento “12/26” y el código de seguridad “321” y presione “Pagar”.
- Entonces: El sistema envía los datos al servidor del banco, espera respuesta y retorna éxito.

### Escenario 2: Autorización fallida por código de tarjeta invalido.
- Dado: Que la conexión con los servidores del banco es exitosa y que el código “1234” no corresponde a una tarjeta de crédito, pero la fecha de vencimiento “12/26” y el código de seguridad “321” corresponden a una tarjeta de crédito con fondos suficientes.
- Cuando: El usuario ingrese el código “1234”, la fecha de vencimiento “12/26” y el código de seguridad “321” y presione “Pagar”.
- Entonces: El sistema envía los datos al servidor del banco, espera respuesta y retorna error por código de tarjeta inválido.

### Escenario 3: Autorización fallida por tarjeta vencida.
- Dado: Que la conexión con los servidores del banco es exitosa y que el código “1234”, que la fecha de vencimiento “10/12” y el código de seguridad “321” corresponden a una tarjeta de crédito con fondos suficientes
- Cuando: El usuario ingrese el código “1234”, la fecha de vencimiento “10/12” y el código de seguridad “321” y presione “Pagar”.
- Entonces: El sistema envía los datos al servidor del banco, espera respuesta y retorna error por fecha de vencimiento alcanzada.

### Escenario 4: Autorización fallida por código de seguridad invalido.
- Dado: Que la conexión con los servidores del banco es exitosa y que el código “1234”, la fecha de vencimiento “12/26” corresponden a una tarjeta de crédito y que el código de seguridad “321” no corresponde a una tarjeta de crédito.
- Cuando: El usuario ingrese el código “1234”, la fecha de vencimiento “12/26” y el código de seguridad “321” y presione “Pagar”.
- Entonces: El sistema envía los datos al servidor del banco, espera respuesta y retorna error por código de seguridad inválido.

## Escenario 5: Autorización fallida por fondos insuficientes.
- Dado: Que la conexión con los servidores del banco es exitosa y que el código “1234”, que la fecha de vencimiento “12/26” y el código de seguridad “321” corresponden a una tarjeta de crédito con fondos insuficientes.
- Cuando: El usuario ingrese el código “1234”, la fecha de vencimiento “12/26” y el código de seguridad “321” y presione “Pagar”.
- Entonces: El sistema envía los datos al servidor del banco, espera respuesta y retorna error por fondos insuficientes.

## Escenario 5: Autorización fallida por error de conexión.
- Dado: Que la conexión con los servidores del banco no es.
- Cuando: El usuario ingrese el código “1234”, la fecha de vencimiento “12/26” y el código de seguridad “321” y presione “Pagar”.
- Entonces: El sistema retorna error por error de conexión.

