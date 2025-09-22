### Esquema
SUSCRIPCION (#suscripcion, email, nombre_usuario, #plan, nombre_plan, texto_condiciones, precio, email_adicional, nombre_adicional, #contenido, titulo, sinopsis, duracion, fecha_adicional)

### Donde:
- Cada suscripción es realizada por un único usuario (identificado por el email) y un plan, pero además hay usuarios adicionales que la utilizan (email_adicional). De cada usuario adicional que se suma a la suscripción, se guarda la fecha.
- Un plan de suscripción tiene un nombre (que no puede garantizarse que sea único en el sistema), condiciones, y un precio mensual.
- Cada contenido tiene un título, sinopsis y duración. El #contenido es único en el sistema, pero del título no puede garantizarse que lo sea.
- De cada suscripción se sabe qué contenidos fueron reproducidos, sin distinción sobre qué usuario (titular o adicionales) reprodujo cada uno.

df:
- df1: #suscripcion -> email, #plan
- df2: email -> nombre_usuario
- df3: #plan -> nombre_plan, text_condicional, precio
- df4: email_adicional -> nombre_adicional
- df5: #contenido -> titulo, sinopsis, duracion
- df6: #suscripcion, email_adicional -> fecha_adicional

cc(#suscripcion, #contenido, email_adicional)

### Normalizar
El esquema no esta en BCNF porque dada la df2 se cumple al menos que {email} no es superclave

- S1(email, nombre_usuario)
- S2(#suscripcion, email, #plan, nombre_plan, texto_condiciones, precio, email_adicional, nombre_adicional, #contenido, titulo, sinopsis, duracion, fecha_adicional)

No se pierde informacion porque S1 inteseccion S2 es superclave en S1 y no se pierden df porque dada df2 se cumple en S1 y dado df1, df3, df4, df5 y df6 se cumple en S2 

S1 se encuentra en BCFN poque dada la df2 se cumple que {email} es superclave

S2 no se encuentra en BCNF porque dada la df4 se cumple al menos que {email_adicional} no es supercalve

- S1(email, nombre_usuario)
- S3(email_adicional, nombre_adicional)
- S4(#suscripcion, email, #plan, nombre_plan, texto_condiciones, precio, email_adicional, #contenido, titulo, sinopsis, duracion, fecha_adicional)

No se pierde informacion porque S3 interseccion S4 es supercalve en S3 y no se pierden df porque dada df4 se cumple em S3 y dado df1, df3, df5 y df6 se cumple en S4.

S3 se encuentra en BCNF porque dada la df4 se cumple que {email_adicional} es superclave.

S4 no se encuentra en BCNF porque dada la df3 se cumple al menos que {#plan} no es superclave

- S1(email, nombre_usuario)
- S3(email_adicional, nombre_adicional)
- S5(#plan, nombre_plan, texto_condiciones, precio)
- S6(#suscripcion, email, #plan, email_adicional, #contenido, titulo, sinopsis, duracion, fecha_adicional)

No se pierde informacion porque dada S5 intersecion S6 es superclave en S5 y no se pierden df porque dada df3 se cumple en S5 y dada df1, df5 y df6 se cimple en S6

S5 se encuentra en BCNF porque dada df3 se cumple que {#plan} es superclave.

S6 no se encuentra en BCNF porque dada la df5 se cumple al menos que {#contenido} no es superclave.

- S1(email, nombre_usuario)
- S3(email_adicional, nombre_adicional)
- S5(#plan, nombre_plan, texto_condiciones, precio)
- S7(#contenido, titulo, sinopsis, duracion)
- S8(#suscripcion, email, #plan, email_adicional, #contenido, fecha_adicional)

No se pierde informacion porque S7 interseccion S8 es superclave en S7 y no se pierden df porque dada df5 se cumple en S7 y dadas df1 y df6 se cumplen en S8

S7 se encuentra en BCNF porque dada df5 se cumple que {#contenido} es superclave

S8 no se encuentra en BCNF porque dada la df6 se cumple al menos que {#suscripcion, email_adicional} no es superclave

- S1(email, nombre_usuario)
- S3(email_adicional, nombre_adicional)
- S5(#plan, nombre_plan, texto_condiciones, precio)
- S7(#contenido, titulo, sinopsis, duracion)
- S9(#suscripcion, email_adicional, fecha_adicional)
- S10(#suscripcion, email, #plan, email_adicional, #contenido)

No se pierde infomracion porque S9 interseccion S10 es superclave en S9 y no se pierden df porque dad df6 se cumple en S9 y dada df1 se cumple en S10

S9 se encuentra en BCNF porque dada df6 se cumple que {#suscripcion, email_adicional} es superclava

S10 no se encuentra en BCNF porque dada la df1 {#suscripcion} no es superclave.

- S1(email, nombre_usuario)
- S3(email_adicional, nombre_adicional)
- S5(#plan, nombre_plan, texto_condiciones, precio)
- S7(#contenido, titulo, sinopsis, duracion)
- S9(#suscripcion, email_adicional, fecha_adicional)
- S11(#suscripcion, email, #plan)
- S12(#suscripcion, email_adicional, #contenido)

No se pierde informacion porque S11 interseccion S12 es superclave en S11 y no se pierden df porque dada la df1 se cumple en S11.

S11 se encuentra en BCNF porque dada df1 se cumple que {#suscripcion} es superclave.

S12 se encuentra en BCNF porque todas las df en esta particion son triviales.

Las particiones S1, S3, S5, S7, S9 y S11 se ecuentran en 4FN porque no presentan dependencias multivaluadas

En S12 se encuentran dos dependecias mutivaluadas:
- dm1: #suscripcion ->> email_adicional
- dm2: #suscripcion ->> #contenido

S12 no se encuentra en 4FN porque dada dm1 se cumple al menos que {#suscripcion} multidetermina {email_adicional} y no es trivial

- S13(#suscripcion, email_adicional)
- S14(#suscripcion, #contenido)

S13 se encuentra en 4FN porque dada dm1 se cumple que {#suscripcion} multidetermina {email_adicional} y es trivual

S13 se encuentra en 4FN porque dada dm2 se cumple que {#suscripcion} multidetermina {#contenido} y es trivual
 
### Esquema final
S1(email, nombre_usuario)
- S3(email_adicional, nombre_adicional)
- S5(#plan, nombre_plan, texto_condiciones, precio)
- S7(#contenido, titulo, sinopsis, duracion)
- S9(#suscripcion, email_adicional, fecha_adicional)
- S11(#suscripcion, email, #plan)
- S13(#suscripcion, email_adicional)
- S14(#suscripcion, #contenido)
