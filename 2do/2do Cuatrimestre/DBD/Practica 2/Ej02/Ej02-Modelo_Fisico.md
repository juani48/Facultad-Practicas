*Clientes* = ( **DNI** , CUIL , apellido , calle , num , piso , depto , mail )

*Telefonos* = ( **num** , *FK_Clientes* )

*Proveedores* = ( **num_proveedor** , DNI , razón_social , nombre , apellido )

*Precios_Unitarios* = ( **precio** )

*Zonas* = ( **num_zona** )

*Tiene2* = ( **FK_Pedidos , FK_Precios_Unitarios** )

*Pedidos* = ( precio_total , activo , hora_entrega , fecha_entrega , **fecha_llamada , hora_llamada , FK_Clientes** , *FK_Zonas* )

*Contiene* = ( **FK_Pedidos , FK_Platos** )

*Platos* = ( **cod_plato** , precio , descripción )

*Formado* = ( **FK_Platos , FK_Productos** )

*Productos* = ( **cod_producto** , descripción , precio , stock , cant_min )

*Se1* = ( **FK_Productos , FK_Compras** )

*Compras* = ( **fecha , hora , FK_Proveedor** )

*Tiene3* = ( **FK_Compras , FK_Precios_Unitarios** )
