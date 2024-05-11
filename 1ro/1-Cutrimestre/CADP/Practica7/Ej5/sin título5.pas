program untitled;
CONST
	tam = 100;

TYPE
	camion = record;
		patente : char;
		fabricacion : integer; {año fabricacion}
		Toneladas : real;
		end;

	flota = array [1..tam] of camion;
	
	viaje = record;
		CodViaje : integer;
		CodCamion : integer[1..tam];
		KM : real;
		destino : string;
		año : integer; {año viaje}
		DNI : integer;
		end;
		
	lista = ^nodo;
	nodo = record;
		elem : viaje;
		sig : lista;
		end;

	lista2 = ^nodo2;
	nodo2 =record;
		elem : integer;
		sig : lista2;
		end;

procedure cargarCamion (var x : camion); {cargo el registro para el vector}
begin
	readln(x.patente);
	readln(x.fabricacion);
	readln(x.Toneladas);
end;

procedure cargarFlota (var f : flota); {vector} {llamo a cargar camion}
var
	i : integer;
	c : camion;
begin
	for i = 1 to tam do begin
		cargarCamion(c);
		f[i] := c;
	end;
end;

procedure cargarViaje (var x : viaje); {cargo registro para la lista } {llamo cargarFlota}
var
	f : flota;
begin
	cargarFlota(f);
	readln(x.CodViaje);
	readln(x.CodCamion);
	readln(x.KM);
	readln(x.destino);
	readln(x.año);
	readln(x.DNI);
end;

procedure AgregarAtras (var l : lista; var ult : lista; v : viaje);
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := v;
	nuevo^.sig := nil;
	if (l = nil)then
		l := nuevo;
	else
		ult^.sig := nuevo;
	ult := nuevo;
end;

procedure cargarLista (var l : lista); {llamo a cargarViaje}
var
	ult : lista;
	v : viaje;
begin
	cargarViaje(v);
	while (v.CodViaje <> -1)do begin
		AgregarAtras(l,ult,v);
		cargarViaje(v);
	end;
end;

procedure MaxMin (l : lista); {5a}
var
	max, min : real;
begin
	max := -1;
	min := 9999;
	if(l^.elem.KM >= max)then
		max := l^.elem.KM;
	if(l^.elem.KM <= min)then
		min := l^.elem.KM;
	writeln(max, min);
end;

procedure CantViajes (l : lista; f : flota; var cant : integer); {5b}
begin
	if(f[l^.elem.CodCamion].Tonleadas > 30.5) and (l^.elem.año - f[l^.elem.CodCamion].fabricacion] = 5) then
		cant := cant = 1;
end;

function Cod (l : lista): integer; {5c}
begin
	if(l^.elem.DNI DIV 2 = 0)then
		Cod := l^.elem.CodViaje;
end;

procedure dniPar (l : lista; var l2 : lista2); {5c}
var
	ult2 : lista2;
	nuevo : lista2;
begin
	new(nuevo);
	nuevo^.elem := Cod(l);
	nuevo^.sig := nil:
	if (l = nil)the
		l := nevo;
	else 
		ult^.sig := nuevo;
	ult := nuevo;
end;

procedure recorrerLista (l : lista; f : flota; l2 : lista2);
var
	cant : integer;
begin
	while (l <> nil)do begin
		MaxMin(l);
		CantViajes(l,f,cant);
		dniPar(l,l2);
	end;
	writeln(cant);
end;

{pp}
VAR
	l : lista;
	l2 : lista2;
	f : flota;
BEGIN
	l := nil;
	cargarFlota(f);
	cargarLista(l,f,l2);
END.

