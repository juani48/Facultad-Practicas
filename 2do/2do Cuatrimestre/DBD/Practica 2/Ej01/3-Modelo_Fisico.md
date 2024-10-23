*Tipos_De_Inmueble* = ( **nombre** )

*Inmuebles* = ( **cod_inmueble** , cant_baños , balcón , lavadero , cant_ambientes , calle , num , piso , depto , *FK_Inmuebles* )

*Clientes* = ( **DNI** , nombre , apellido , calle , num , depto , piso , sexo , num_pasaporte , nacionalidad )

*Empleados* = ( **DNI** , legajo , nombre , apellido , calle , num , depto , piso )

*Dueño* = ( **FK_Clientes , FK_Inmebles** )

*Trabaja* = ( **FK_Empleados , FK_Areas** , fecha_entrada , fechas_salida )

*Áreas* = ( **cod_area** , descripción , ubicación )

*Teléfonos* = ( **num_telefono** , *FK_Areas* )

*Alquileres* = ( precio , fecha_fin , **fecha_inicio , FK_Clientes** , *FK_Inmuebles* , *FK_Empleados* )

*Ventas* = ( comisión , precio , **fecha , hora , FK_Clientes** , *FK_Inmuebles* , *FK_Empleados* )
