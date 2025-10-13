## Dados los siguientes esquemas
COMPRA(#compra, fecha, monto_total)
COMPRA_PRODUCTO(#compra, cantidad, #producto)
PRODUCTO(#producto, nombre, precio)
### Indique qué formato (conjunto de atributos) tiene el resultado de aplicar la siguiente operación.

$$
COMPRA_PRODUCTO\ \%\ ∏_{\#producto}PRODUCTO
$$

[ ] (#compra, cantidad)
[x] (#compra, cantidad, #producto)
[ ] (#compra)