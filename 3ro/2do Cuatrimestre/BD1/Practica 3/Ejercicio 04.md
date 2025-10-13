## Dado el siguiente esquema:
- PASAJERO (#pasajero, nombre, dni, puntaje)
- PASAJERO_RESERVA (#pasajero, #reserva)
- RESERVA (#reserva, #vuelo, fecha_reserva, monto, #asiento)
- VUELO (#vuelo, aeropuerto_salida, aeropuerto_destino, fecha_vuelo)

## Indicar si las siguientes consultas obtienen el resultado correcto (sin tener en cuenta la optimización).

### A -​ Obtener los pasajeros que tengan reservas sobre vuelos del próximo año, listando #pasajero, #vuelo y #asiento.
$$
VUELOS\_PROX\_AÑO\ ←\ σ_{(fecha_vuelo\ >=\ 1/1/2026)\ AND\ (fecha_vuelo\ <=\ 31/12/2026)} VUELO
\\
RES\ ←\ Π_{\#pasajero,\#vuelo,\#asiento} ( VUELOS\_PROX\_AÑO\ |X|\ RESERVA\ |X|\ PASAJERO_RESERVA)
$$

Si, se obtienen los pasajeros que tengan reservas sobre vuelos del próximo año.

### B - Obtener el listado de montos de reservas realizadas para vuelos efectuados el pasado Agosto desde Buenos Aires a Córdoba.
$$
VUELOS\_BUE\_CBA\ ←\ σ_{(ciudad\_salida\ =\ “Buenos\ Aires”)\ AND\ (ciudad\_destino\ =\ “Córdoba”)} VUELO
\\
RESERV\_AGO\ ←\ (σ_{(fecha\_reserva\ >=\ 1/8/2025)\ AND\ (fecha\_reserva\ <=\ 31/8/2025)} RESERVA)\ |X|\ VUELOS\_BUE\_CBA
\\
RES\ ←\ Π_{monto} RESERV\_AGO
$$

Si, se obtiene el listado de montos.

### C - Obtener el/los pasajeros que solo hayan reservado vuelos cuyo aeropuerto de salida sea el aeropuerto “Ministro Pistarini”. Listar el nombre y dni de los pasajeros.

$$
VUELOS\_PISTARINI\ ←\ Π_{\#vuelo} (σ_{aeropuerto\_salida\ =\ “Ministro\ Pistarini”} VUELO )
\\
RESERVA\_PISTARINI\ ←\ Π_{\#pasajero} (VUELOS\_PISTARINI\ |X|\ RESERVA)
\\
PASAJEROS\_PISTARINI\ ←\ Π_{nombre,dni} (RESERVA\_PISTARINI\ |X|\ PASAJERO)
$$

No, no se obtienen los pasajeros que solo hayan reservado vuelos cuyo aeropuerto de salida sea el aeropuerto “Ministro Pistarini”.

### D - Obtener el/los id/s de los pasajeros que hayan realizado reservas por un monto superior a $99000
$$
RESERVAS\_MAS\_99000\ ←\ Π_{#\pasajero} (σ_{monto\ <\ 99000} RESERVA )
$$

No, no se obtienen los id de los pasajeros que hayan realizado reservas por un monto superior a $99000.