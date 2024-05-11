program untitled;
Const
	tam = 7;
	
Type
	caregorias = array [1..tam] of integer;
	
	objeto = record
		COD : integer;
		categoria : 1..tam;
		nombre : string;
		distancia : real;
		descubridor : string;
		anoDescu : integer;
		end;
		
		lista = ^nodo;
		nodo = record
			elem : objeto;
			sig : lista;
			end;
			
		lejos = array [1..2] of integer;
		
procedure cargarObjeto (x : objeto);
begin
	readln(x.COD);
	readln(x.categoria);
	readln(x.nombre);
	readln(x.descubridor);
	readln(x.distancia);
	readln(x.anoDescu);
end;

procedure agregarAtras (var l : lista; var ult : lista; o : objeto);
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := o;
	nuevo^.sig := nil;
	if(l = nil)then
		l := nuevo
	else
		ult^.sig := nuevo;
	ult:= nuevo;
end;

procedure cargarLista (var l : lista);
var
	ult : lista;
	x : objeto;
begin
	ult := nil;
	cargarObjeto(x);
	while(x.COD <> -1)do begin
		agregarAtras(l,ult,x);
		cargarObjeto(x);
	end;
end;

procedure LimpiarCat (var c : categorias);
var
	i : integer;
begin
	for i = 1 to tam do
		c[i] := 0;
end;

procedure +lejos (l : lista;var max1 : integer; var max2 : integer; var x : lejos);
var
	
begin
	if(l^.distancia >= max1)then begin
		max2 := max1;
		x[2] := x[1];
		max1 := l^.distancia;
		x[1] := l^.COD;
	end
	else begin
		max2 := l^.distancia;
		x[2] := l^.COD;
	end;
end;

procedure GG (l : lista; var num : integer);
begin
	if(l^.descubridor = 'Galileo Galilei') and (l^.anoDescu < 1600)then
		num := num +1;
end;

procedure totalObj (l : lista; var c : categorias);
begin
	c[l^.categoria] := c[l^.categoria] + 1;
end;

function condicion (l : lista): boolean;
var
	x,par,imp : integer;
begin
	par := 0;
	imp := 0;
	x := l^.COD;
	while(x <> 0)do begin
		if(x DIV 2 = 0)then
			par := par + 1;
		else
			imp := imp + 1;
		x := x MOD 10;
	end;
	if(par > imp)then
		condicion := true;
	else
		condicion := false;
end;

procedure estrellas (l : lista; var l2 : lista);
var
	ult : lista;
begin
	ult : - nil;
	if(condicion(l)) and (l^.categoria = 1)then
		agregarAtras(l2,ult,l^.elem);
end;

procedure recorrerLista (l : lista; var x : lejos; var num : integer; var c : categorias; var l2 : lista);
var
	max1, max2 : integer;
begin
	max1 := -1;
	max2 := max1;
	while(l <> nil)do begin
		+lejos(l,max1,max2,l);
		GG(l,num);
		totalObj(l,c);
		
		l := l^.sig;
	end;
end;

{PP}
VAR
	l : lista;
	x : lejos;
	num : integer;
	c : categoriar;
	l2 : lista;
BEGIN
	num := 0;
	l := nil;
	LimpiarCat(c);
	l2 := nil;
	cargarLista(l,x,num,c,l2);
END.

