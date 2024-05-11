program ej5;

const
	tam = 20;
type
	camiones = record;
		patente : integer;
		añoFabri : integer;
		capacidadT : real;
		end;
	flota = array [1..tam] of camiones;
	
	viaje = record;
		CODviaje : integer;
		CODcamion : 1..tam;
		distancia : real;
		ciudadDes : string;
		añoVaije : integer;
		DNIchofer : integer;
		end;
		
	lista = ^nodo;
	nodo = record;
		elem : viaje;
		sig : lista;
		end;

procedure cargarCamiones (var c : camiones);
procedure cargarCamiones (var c : camiones);
procedure cargarFlota (var f : flota);
procedure cargarVaije (var x : viaje);

procedure agregarAtras (var l, var ult : lista, x : viaje)
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := nil;
	if(l = nil)then
		l := nuevo
	else
		ult^.sig := nuevo;
	ult := nuevo;
end;
		
procedure cargarLista (var l : lista);
var
	ult : lista;
	x : viaje:
begin
	cargarViaje(x);
	while(x.CODviaje <> -1)do begin
		agregarAtras(l,ult,x);
		cargarViajes(x);
	end;
end;

procedure +-kilomnetros (l : lista; f : flota; var max : integer; var min : integer; var Patmax : integer; var Patmin : integer); {1}
begin
	if(l^.distancia >= max)then begin
		max := l^.distancia;
		Patmax := f[l^.CODcamion].patente;
		end
	else if (l^.distancia <= min)then begin
		min := l^.distancia;
		Patmin := f[l^.CODcamion].patente;
	end;
end;

procedure cantViajes (l : lista; f : flota; var x : integer );
var
	
begin
	if(f[l^.CODcamion].capacidadT >= 30.5) and (f[l^.CODcamion].añoFabri - l^.añoVaije >= 5)then
		x := x + 1;
end;

procedure DNIimpar (l : lista);
var
	num : integer;
	condicion : boolean;
begin
	condicion := true;
	num := l^.DNIchofer;
	while(num <> 0) and (condicion)do begin
		if(num DIV 2 = 0)then
			condicion := false
		else
			num := num MOD 10;
	end;
	if(condicion)then
		writeln(l^.CODviaje);
end;

procedure recorrerLista (l : lista, f : flota);
var
	max, min : integer;
	Patmax, Patmin : integer;
	x : integer;
begin
	x := 0;
	min := 9999;
	max := -1;
	while(l <> nil)do begin
		+-kilometros(l,f,max,min,Patmax,Patmin);
		cantViajes(l,f,x);
		l := ;^.sig
	end;
	writeln(Patmax, Patmin);
	writeln(x);
end;


BEGIN
	
	
END.

