program untitled;
CONST
	tam = 5;
TYPE
	cliente = record
		cod : integer;
		localidad : string;
		tipo : integer[1..tam];
		kW6meses : real;
	end;
	
	lista = ^nodo;
	nodo = record
		elem : cliente;
		sig : lista;
	end;
	
	vectorTipo = array [1..tam] of integer;

procedure cargarCliente (var l : lista); {se dispone}

procedure limpiar (var v : vactorTipo);
var
	i : integr;
begin
	for i = 1 to tam do
		v[i] := 0;
end;

procedure cantTipo (var v : vectorTipo; l : lista);
var
	
begin
	while(l <> nil)do begin
		v[l^.elem.tipo] := v[l^.elem.tipo] + 1;
		l := l^.sig;
	end;
end;

procedure localidadMayo (l : lista; var x : string);
var
	localidadACT : string;
	maxLocalidad : integer;
	z : integer;
begin
	maxLocalidad := -1;
	z := 0;
	while(l <> nil)do begin
		z := 0;
		maxLocalidad := l^.elem.localidad;
		while(l <> nil)and(l^.elem.localida = maxLocalidad)do begin
			z := z + 1;
			l : l^.sig;
		end;
		if(z > maxLocalidad)then begin
			maxLocalidad := z;
			x := l^.elem.localidad;
		end;
	end;
end;

procedure 

VAR
	v : vectorTipo;
BEGIN
	
	
END.

