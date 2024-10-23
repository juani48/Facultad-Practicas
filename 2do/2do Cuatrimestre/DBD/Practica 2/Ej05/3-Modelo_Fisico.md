
*Usuarios* = ( (usuario)<sub>CP</sub> , clave, nombre, apellido, telefono, calle, num, depto, piso)

*Tiene_correos* = ( { (usuario)<sub>CF=Usurios</sub> , (correo)<sub>CF=Correos</sub> }<sub>CP</sub> )

*Correos* = ( (correo)<sub>CP</sub> )

*Vinculos* = ( (fecha , hora)<sub>CP</sub>, tipo, lugar, (usuario)<sub>CF=Usuarios</sub> , (usuario)<sub>CF=Usuarios</sub> ) 

*Imagenes* = ( (titulo , (usuario)<sub>CF=Usuarios</sub> )<sub>CP</sub> , nombre_archivo, fecha, hora, (nombre)<sub>CF=Tematicas</sub> )

*Tiene_palabras* = ( ( (titulo , usuario)<sub>CF=Imagenes</sub> ,(palabra)<sub>CF=Palabras_claves</sub> )<sub>CP</sub> )

*Palabras_claves* = ( (palabra)<sub>CP</sub> )

*Tematicas* = ( (nombre)<sub>CP</sub> , descripcion )

*Comentarios* = ( ( fecha , hora , (usuario)<sub>CF=Usuarios</sub> )<sub>CP</sub> , text ) 

*Comento* = ( ( (fecha , hora , usuario)<sub>CF=Comentarios</sub> , (titulo , usuario)<sub>CF=Imagenes</sub> )<sub>CP</sub> )

*Respondio* = ( (  (fecha , hora , usuario)<sub>CF=Comentarios</sub> , (fecha , hora , usuario)<sub>CF=Comentarios</sub> )<sub>CP</sub> )

*Interactua* = (  )
