program untitled;
Const
	error = -1;
Type
	producto = record
		cod : integer;
		nombre : string;
		precio : double;
		stockACT : integer;
		stockMIN : integer;
		end;
		
	venta = record
		cod : integer;
		unidades : integer;
		end;

	maestro = file of producto;
	detalle = file of venta;
	
procedure Leer (var det : detalle; var ven : venta);
begin
	if(not eof(det))then
		read(det,ven)
	else
		ven.cod := error;
end;

procedure Modificar(var _maestro : maestro; var _detalle : detalle);
var
	_producto : producto;
	_venta : venta;
begin
	reset(_detalle);
	reset(_maestro);
	
	Leer(_detalle, _venta);
	
	while(_venta.cod <> error)do begin
		read(_maestro, _producto);
		
		while(_venta.cod <> _producto.cod)do //buscar el registro maestro a actualizar
			read(_maestro, _producto);
			
		while(_venta.cod = _producto.cod)do begin //buscar todos los archivos detalles que modifican
			_producto.stockACT := _producto.stockACT - _venta.unidades;
			Leer(_detalle, _venta);
		end;
		seek(_maestro, filePos(_maestro)-1);
		write(_maestro,_producto);
	end;
end;

procedure Exportar(var _maestro : maestro; var txt : Text);
var
	_producto : producto;
begin
	reset(_maestro); rewrite(txt);
	while(not eof(_maestro))do begin
		read(_maestro,_producto);
		if(_producto.stockMIN > _producto.stockDIS)then begin
			writeln(txt, _producto.cod, ' ',_producto.precio,' ',_producto.nombre);
			writeln(txt, _producto.stockDIS, ' ',_producto.stockMIN);
		end;
	end;
	close(_maestro);
	close(txt);
end;

VAR
	_maestro : maestro;
	_detalle : detalle;
	txt : Text
BEGIN
	assign(_maestro, 'maestro.dat');
	assign(_detalle, 'detalle.dat');
	assign(txt, 'stock_minimo.txt');	
END.

