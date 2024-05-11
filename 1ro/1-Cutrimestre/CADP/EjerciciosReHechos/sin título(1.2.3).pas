program untitled;
Const
	tam = 23;
Type
	
	estancia = record
		cod : integer;
		localidad : string;
		codProv : 1..tam;
		cantCabe : integer;
		end;
		
	lista = ^nodo;
	nodo = record
		elem : estancia;
		sig : lista;
		end;
		
procedure cargarEstancia (e : estancia);
begin
	readln(e.cod);
	readln(e.localidad);
	readln(e.codProv);
	readln(e.cantCabe);
end;

procedure agragarAtras (var l : lista; var ult : lista; e : estancia);
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := e;
	nuevo^.sig := nil;
	if(l = nil)then
		l := nuevo;
	else
		ult^.sig := nuuevo;
	ult := nuevo;
end;

procedure cargarLista (var l : lista);
var
	ult : lista;
	e : estancia;
begin
	ult := nil;
	cargarEstancia(e);
	while(e.cod <> 0)do begin
		agragarAtras(l,ult,e);
		cargarEstancia(e);
	end
end;

procedure cod234 (l : lista; var esta : boolean); {2}
var

begin
	if(l^.cod = 234)then
		esta := true;
	else
		esta := false;
end;

procedure +ganado (l : lista; var max1 : integer; var max2 : integer; var maxCOD1 : integer; var maxCOD2 : integer);
var

begin
	if(l^.canCabe >= max1)then begin
		max2 := max1;
		maxCOD2 := maxCOD1;
		max1 := l^.canCabe;
		maxCOD1 := l^.codProv;
	end
	else if(l^.canCabe >= max2)then begin
		max2 := l^.canCabe;
		maxCOD2 := l^.codProv;
	end;	
end;

procedure recorrerLista (l : lista; var esta : boolean; var maxCOD1 : integer; var maxCOD2 : integer);
var
	max1, max2 : integer;
begin
	max1 := -1;
	max2 := -1;
	while(l <> nil)do begin
		cod234(l,esta);
		+ganado(l,max1,max2,maxCOD1,maxCOD2)
		l := ;^.sig;
	end;
end;

VAR
	l : lista;
	esta : boolean;
	maxCOD1, maxCOD2 : integer;
BEGIN
	maxCOD1 := 0;
	maxCOD2 := 0;
	l :=- nil
	cargarLista(l);
	recorrerLista(l,esta,maxCOD1,maxCOD2);
END.

