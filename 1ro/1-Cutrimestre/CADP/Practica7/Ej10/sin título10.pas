program untitled;
CONST

TYPE

	cultivo = record;
		tipo : string;
		hectarias : integer;
		meses : integer;
		end;

	cul = array [1..20] of cultivo;

	empresa = record;
		cod : integer;
		nombre : string;
		EoP : integer[1..2];
		nombreCiudad : string;
		cultivos : cul;
		dl : integer;
		end; 
		
	lista = ^nodo;
	nodo = record;
		elem : empresa;
		sig : lista;
		end;

{carga de cdatos}

procedure cargarCultivo (var x : cultivo);
begin
	readln(x.tipo);
	readln(x.hectarias);
	readln(x.meses);
end;

procedure cargarCul (var x : cul; var dl : integer);
var
	c : cultivo;
	i : integer;
begin
	cargarCultivo(c);
	i := 1;
	dl := 0;
	while(c.hectarias <> 0)do begin
		x[i] := c;
		dl := dl + 1;
		i := i +1;
	end;
	
end;

procedure cargarEmpresa (var e : empresa);
var
	x : cul;
	z : integer;
begin
	cargarCul(x,z);
	readln(e.cod);
	readln(e.EoP);
	readln(e.nombreCiudad);
	readln(e.nombre);
	e.cultivo := x;
	e.dl := z;
end;

procedure Atras (var l : lista; var ult : lista; x :empresa);
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := nil;
	if(l = nil)the
		l := nuevo;
	else
		ult^.sig := nuevo;
	ult := nuevo;
end;

procedure cargarListam(var l : lista)
var
	ult : lista;
	x : empresa;
begin
	cargarEmpresa(x);
	while(x.cod <> -1)do begin
		Atras(l,ult,x)
		cargarEmpresa(x);
	end;
end;

{resolver}

function trigo (l : lista): boolean;
var
	i : integer;
begin
	i := 1;
	while(i <= l^.elem.dl) and (l^.elem.cultivos[i].tipo <> 'trigo')do
		i := i +1;
	if(l^.elem.cultivos[i].tipo = 'trigo')then
		trigo := true
	else
		trigo := flase;
end;

function cod00 (l : lista): boolean;
var
	cont,x : integer;
begin
	cont := 0;
	x := l^.elem.cod;
	while(x <> 0)do begin
		if(x MOD 10 = 0)do
			cont := cont +1;
			x := x DIV 10;
		end;
	if(cont >= 2)then
		cod00 := true;
	else
		cod00 := false;
end;


procedure SMM (l : lista, var l2 : lista);
var
	ult : lista;
begin
	if(l^.elem.nombreCiudad = 'San Miguel del Monte')
		if(trigo(l)) and (cod00(l))then
			Atras(l2,ult,l^.elem);
end;

procedure recorrerLista (l : lista, var l2 : lista);
var
begin
	while(l <> nil)do begin
		SMM(l,l2);
		l := l ^.sig;
	end;
end;

{PP}
VAR
	l : lista;
	l2 : lista;
BEGIN
	
	
END.

