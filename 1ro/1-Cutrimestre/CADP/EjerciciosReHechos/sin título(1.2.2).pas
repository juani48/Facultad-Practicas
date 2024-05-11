program untitled;
Const
	tam = 26;
Type	
	producto = record
		nombre : string;
		precioKilo : real;
		end;
	
	categorias = array [1..tam] of 	producto;

	compra = record
		DNI : integer;
		cat : 1..tam;
		cantKilos : real;
		end;

	lista = ^nodo;
	nodo = record
		elem : compra;
		sig : lista;
		end;

procedure carga (var p : producto; var x : integer);
begin
	readln(p.nombre);
	readln(p.precioKilo);
	readln(x);
end;

procedure cargarCat (var c : categorias);
var
	i,x : integer;
	p : producto;
begin
	fo i = 1 to tam do begin
		carga(p,x);
		c[x] := p;
	end;
end;

procedure limpiarC (var c2 : categorias);
var
	i : integer;
begin
	for i = 1 to tam do 
		c2[i].precioKilo := 0;
end;

procedure +compras (l : lista; var dni : integer; var max : integer; var maxDNI : integer; var x : integer); {B1}
var
	
begin
	if(l^.DNI = dni)then
		x := x + 1
	else begin
		if(x >= max)then begin
			max := x;
			maxDNI := dni
		end;
		dni := l^.DNI;
		x := 1;
	end;
end;

procedure totalCat (l : lista; c : categorias; var c2 : categorias) {B2}
var

begin
	c2[l^.cat].precioKilo := c2[l^.cat].precioKilo * c[l^.cat].precioKilo;
end;

procedure DNIpar (l : lista;p var totalPar : integer); {B3}
var
	x, par : integer;
begin
	par := 0;
	x := l^.DNI;
	while(x <> 0)do begin
		if(x DIV 2 = 0)then
			par := par + 1;
		x := x MOD 10;
	end;
	if(par >= 3)then
		totalPar := totalPar + 1;
end;

procedure recorrerLista (l : lista; c : categorias; var maxDNI; var c2 : categorias; var totalPar : integer);
var
	max , dni, x : integer;
begin
	x := 0;
	max := -1;
	dni := l^.DNI;
	+compras(l,dni,max,maxDNI,x);
	totalCat(l,c,c2);
	DNIpar(l,totalPar);
end;

VAR
	c, c2 : categorias;
	maxDNI, totalPar : integer;
BEGIN
	totalPar := 0;
	cargarCat(c);
	limpiarC(c2);
	recorrerLista(l,c,maxDNI,c2,totalPar);
END.

