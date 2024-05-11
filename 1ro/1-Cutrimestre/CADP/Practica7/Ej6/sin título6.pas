program untitled;
CONST
	tam = 7;
TYPE
	clasificacion = array [1..tam] of integer;

	objeto = record;
		CodObj : integer;
		Categoria : integer[1..tam];
		Nombre : string;
		Distancia : real;
		Descubridor : string;
		Año : integer;
		end;
		
	lista : ^nodo;
	nodo : record;
		elem : objeto;
		sig : lista;
		end;
	lista2 : ^nodo2;
	nodo2 : record;
		elem : string;
		sig : lista2;
		end;
{lectura de datodos}

procedure en0 (var c : clasificacion);
var
	i : integer;
begin
	for i = 1 to tam do
		c[i] := 0;
end;

procedure cargarObjeto (x : objeto);
begin
	readln(x.CodObj);
	readln(x.Categoria);
	readln(x.Nombre);
	readln(x.Distancia);
	readln(x.Descubridor);
	readln(x.Año);
end;

procedure agregarAtras (var l : lista; var ult : lista; x : objeto);
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := nil;
	if(l = nil)then
		l := nuevo;
	else
		ult^.sigl := nuevo;
	ult := nuevo;
end;

procedure cargarLista (var l : lista);
var
	ult : lista;
	x : objeto;
begin
	cargarObjeto(x)
	while(x.CodObj <> -1)do begin
		agregarAtras(l,ult,x);
		cargarObjeto(x);
	end;
end;

procedure agregarL2 (var l : lista2;var ult : lista2; x : string)
var
	nuevo : lista2;
begin
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := nil;
	if (l = nil)then
		l := nuevo;
	else
		ult^.sig := nuevo;
	ult := nuevo;
end;

{resolucion del problem}

procedure MasLejano (l : lista); {6B1}
var
	max1, max2 : real;
	cod1, cod2 : integer;
begin
	max1 := -1;
	max2 := -1;
	if(l^.elem.Distancia >= max1)then begin
		max2 := max1;
		cod2 := cod1;
		max1 := l^.elem.Distancia;
		cod1 := l^.elem.CodObj;
	end
	else if (l^.elem.Distancia >= max2)then begin
		max2 := l^.elem.Distancia;
		cod2 := l^.elem.CodObj;
	end;
	write(cod1,cod2);
end;

procedure GG (l : lista, var cant : integer); {6B2}
begin
	if(l^.elem.Descubridor = 'Galileo Galilei') and (l^.elem.Año < 1600)then
		cant := cant + 1;
end;

procedure CantC (l : lista, var c : clasificacion); {6B3}
begin
	c[l^.elem.categoria] := c[l^.elem.categoria] + 1;
end;

procedure NomEstrellas (l : lista; var l2 : lista2); {6B4}
var
	par, imp, x : integer
	ult : lista2
begin
	par := 0;
	imp := 0;
	x := l^.elem.CodObj;
	while(x <> 0)do begin
		if(x MOD 2 = 0)then
			par := par + 1;
		else
			imp := imp + 1;
	end:
	if(par > imp)then 
		agregarL2(l2,ult,l^.elem.Nombre);
end;	

procedure recorrerLista (l : lista; var c : clasificacion; var l2 : lista2);
var
	cant : integer
begin
	while(l <> nil)do begin
		MasLejano(l);
		GG(l,cant);
		CantC(l,c);
		NomEstrellas(l,l2);
		l := l^.sig;
	end;
	writeln(cant);
end;

{pp}
VAR
	l : lista
	l2 : lista2;
	c : clasificacion;
BEGIN
	en0(c);
	l := nil;
	l2 :+ nil;
	cargarLista(l);
	recorrerLista(l,c,l2);
END.

