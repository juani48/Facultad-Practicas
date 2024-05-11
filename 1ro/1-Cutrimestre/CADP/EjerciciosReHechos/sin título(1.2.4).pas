program untitled;
Const
	tam = 5;
Type
	premios = array [1..tam] of real;
	
	empleado = record
		DNI : integer;
		apellido : string;
		nombre : string;
		categoria : 'A'..'E';
		sueldo : real;
		montos : premios;
		antiguedad : integer;
		end;

	lista = ^nodo;
	nodo = record
		elem : empleado;
		sig : lista;
		end;

procedure cargarPremios (var p : premios)
var 
	i : integer;
begin
	for i = 1 to tamb do 
		readln(p[i]);
end;

procedure cargarEmpleado (var e : empleado);
var
	x : premios;
begin
	readln(e.DNI);
	readln(e.apellido);
	readln(e.nombre);
	readln(e.categoria);
	readln(e.sueldo);
	cargarPremios(x);
	e.montos := x;
	readln(antiguedad);
end;

procedure insertarOrdenado (var l : lista; e : empleado);
var
	nuevo, act, ant : lista;
begin
	new(nuevo);
	nuevo^.elem := e;
	nuevo^.sig := nil;
	act := l;
	ant := l;
	while(act <> nil) and (e.DNI > act^.elem.DNI)do begin
		ant := act;
		act := act^.sig;
	end;
	if(act = ant)then
		l := nuevo;
	else
		ant^.elem := nuevo;
	nuevo^.sig := act;
end;

procedure cargarLista (var l : lista);
var
	x : empleado;
begin
	cargarEmpleado(x);
	while(x.DNI <> -1)do begin
		insertarOrdenado(l,x);
		cargarEmpleado(x);
	end;
end;

procedure limpiarPremios (x : premios);
var
	i : integer;
begin
	for i = 1 to tam do
		x[i] := 0;
end;	

function totalPremios (p : premios): integer;
var
	i,x : integer;
begin
	x := 0;
	for i = 1 to tam do begin
		x := x + p[i];
	end;
	totalPremios := x;
end;

procedure Liqui (l : lista; var l2 : lista);
var
	x : empleado;
begin
	if(l^.elem.categoria = 'A') or (l^.elem.categoria = 'B') or (l^.elem.categoria = 'C')then begin
		x.DNI := l^.elem.DNI;
		x.sueldo := totalPremios(l^.elem.montos) + l^.elem.sueldo;
		insertarOrdenado(l2,x);
	end;
	else begin
		x.DNI := l^.elem.DNI;
		x.sueldo := totalPremios(l^.elem.montos) + l^.elem.sueldo + 1000 * l^.elem.antiguedad;
		insertarOrdenado(l2,x);
	end;
		
end;

procedure totalCategorias (l : lista; var x : premios);
var

begin
	if(l^.elem.categoria = 'A')then
		x[1] := x[1] + 1;
	else if(l^.elem.categoria = 'B')then
		x[2] := x[2] + 1;
	else if(l^.elem.categoria = 'C')then
		x[3] := x[3] + 1;
	else if(l^.elem.categoria = 'D')then
		x[4] := x[4] + 1;
	else if(l^.elem.categoria = 'E')then
		x[5] := x[5] + 1;
end;

procedure recorrerLista (l : lista; var l2 : lista);
var
	x : premios;
begin
	limpiarPremios(x);
	while(l <> nil)do begin
		Liqui(l,l2);
		
		l := l^.sig;
	end;	
end;

VAR
	l, liquidaciones : lista;
BEGIN
	
	
END.

