program untitled;

Const

Type
	socio = record
		num : integer;
		nombre : string;
		edad : integer;
		end;
	
	arbol = ^nodo;
	nodo = record
		elem : socio;
		HI : arbol;
		HD : arbol;
		end;

procedure cargarSocio (var x : socio);
begin
	readln(x.num)
	if(x.num <> 0)then begin
		readln(x.nombre);
		readln(x.edad);
	end;
end;

procedure nuevoNodo(var arb : arbol, x : socio);
begin
	new(arb);
	arb^.elem := x;
	arb^.HI := null;
	arb^.HD := null;
end;

procedure agregar(var arb ; arbol, x : socio);
begin
	if(arb = null)then
		nuevoNodo(arb,x);
	else begin
		if(x.num < arb^.elem.num)then
			agregar(arb^.HI,x)
		else
			agregar(arb^.HI,x);
	end;
end;

procedure cargarArbol(var arb : arbol);
var
	x : socio;
begin
	cargarSocio(x);
	while(x.num <> 0)do begin
		agregar(arb,x);
		cargarSocio(x);
	end;
end;

function maxNum(arb : arbol):integer;
begin
	if(arb^.HD <> null)then
		maxNum := maxNum(arb^.HD)
	else
		maxNum := arb^.elem.num;
end;

function minNum(arb : arbol):integer;
begin
	if(arb^.HI <> null)then
		maxNum := maxNum(arb^.HD)
	else
		maxNum := arb^.elem.num;
end;

function maxEdad(arb : arbol): integer;
var
	HD, HI, max : integer;
begin
	HD := 0; HI := 0;
	
	if(arb^.HI <> null)then
		HI := maxEdad(arb^.HI);
	if(arb^.HD <> null)then
		HD := maxEdad(arb^.HD);
		
	if(HD < HI)then
		max := HI
	else
		max := HD;
		
	if(max > arb^.elem.edad)then
		maxEdad := max
	else
		maxEdad := arb^.elem.edad;
end;

procedure aumentoEdad (var arb : arbol);
begin
	arb^.elem.edad := arb^.elem.edad + 1;
	if(arb^.HI <> null)then
		aumentoEdad(arb^.HI);
	if(arb^.HD <> null)then
		aumentoEdad(arb^.HD);
end;

function boolean busquedaNombre(arb : arbol, nombre : string);
var
	ok : boolean;
begin
	ok := false;
	if(nombre = arb^.elem.nombre)then
		ok := true
	else
		if(arb^.HI <> null)then
			ok := busquedaNombre(arb^.HI,nombre);
		if(arb^.HD <> null)then
			ok := busquedaNombre(arb^.HD,nombre); 

	busquedaNombre := ok;
end;

function boolean busquedaValor(arb : arbol, valor : integer);
begin
	if(arb^.elem.num = valor)then
		busquedaValor := true
	else
		if(valor < arb^.elem.num)then begin
			if(arb^.HI <> null)then
				busquedaValor := busquedaValor(arb^.HI,valor)
			else
				bisquedaValor := false;
		end
		else
			if(arb^.HD <> null)then
				busquedaValor := busquedaValor(arb^.HD,valor)
			else
				bisquedaValor := false;
end;

BEGIN
	
	
END.

