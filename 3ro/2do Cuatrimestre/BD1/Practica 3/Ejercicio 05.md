## Choferes
- DUEÑO ( id_dueño, nombre, teléfono, dirección, dni )
- CHOFER ( id_chofer, nombre, teléfono, dirección, fecha_licencia_desde, fecha_licencia_hasta, dni )
- AUTO ( patente, id_dueño, id_chofer, marca, modelo, año )
- VIAJE ( patente, hora_desde, hora_hasta, origen, destino, tarifa, metraje )

### A - Listar el dni, nombre y teléfono de todos los dueños que NO son choferes
$$
DUEÑO\_CHOFER\ ←\ Π_{id_dueño}(DUEÑO \ |X|_{DUEÑO.dni\ ==\ CHOFER.dni}\ CHOFER)
\\
DUEÑO\_NO\_CHOFER\ ←\ Π_{id_dueño}(Π_{id_dueño}(DUEÑO)\ -\ DUEÑO\_CHOFER)
\\
RES\ ←\ Π_{dni,nombre,telefono}(DUEÑO\ |X|\ DUEÑO\_NO\_CHOFER)
$$

### B - Listar la patente y el id_chofer de todos los autos a cuyos choferes les caduca la licencia el $01/01/2026$
$$
CHOFER\_CADUCA\_LICENCIA\ ←\ Π_{id_chofer}(σ_{fecha\_licencia\_hasta\ >=\ 01/01/2026}CHOFER)
\\
RES\ ←\ Π_{AUTO.patente,AUTO.id_chofer}(AUTO\ |X|\ CHOFER\_CADUCA\_LICENCIA)
$$