program untitled;
Type
	anos = 2010..2018;

	auto = record
		patente : integer;
		ano : anos;
		marca : string;
		modelo : integer;
		end;
		
	{punto a 1}
	
	arbol = ^nodo;
	nodo = record
		elem : auto;
		HD : arbol;
		HI : arbol;
		end;
	
	{punto a 2}
	
	lista = ^nodo3; {lista de autos por marca}
	nodo3 = record
		elem : auto;
		sig : lista;
		end;
	
	arbol2 = ^nodo2; {arbo ordenado por marca}
	nodo2 = record
		elem : lista;
		marca : string;
		HD : arbol2;
		HI : arbol2;
		end;

procedure cargaAuto (var x : auto);
begin
	readln(x.patente);
	if(x.patente <> -1)then begin
		readln(x.ano);
		readln(x.marca);
		readln(x.modelo);
	end;
end;

procedure agregarArbol1 (var arb : arbol; a : auto); {agregar del arbol por patente a1}
begin
	if(arb = nil)then begin
		new(arb);
		arb^.elem := a;
		arb^.HD := nil;
		arb^.HI := nil;
	end
	else
		if(a.patente > arb^.elem.patente)then
			agregarArbol1(arb^.HD,a)
		else
			agregarArbol1(arb^.HI,a);
end;

procedure AgregarAdelante (var l : lista; x : auto);
var
	nuevo : lista;	
begin
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := l;
	l := nuevo;
end;

procedure agregarArbol2 (var arb : arbol2; a : auto);
begin
	if(arb = nil)then begin
		new(arb);
		arb^.marca := a.marca;
		
		arb^.HD := nil;
		arb^.HI := nil;
		
		new(arb^.elem); {new de la lista del nodo del arbol}
		arb^.elem^.elem:=a;
		arb^.elem^.sig := nil;
	end
	else
		if(arb^.elem^.elem.marca = a.marca)then
			AgregarAdelante(arb^.elem,a) {se agregar elemto en la lista de autos}
		else
			if(a.marca > arb^.elem^.elem.marca)then
				agregarArbol2(arb^.HD,a)
			else
				agregarArbol2(arb^.HI,a);
end;

procedure cargarStock (var arb1 : arbol; var arb2 : arbol2);
var
	a : auto;
begin
	arb1 := nil;
	arb2 := nil;
	
	cargaAuto(a);
	while(a.patente <> -1)do begin
		agregarArbol1(arb1,a);
		agregarArbol2(arb2,a);
		cargaAuto(a);
	end;
end;

function RecorrerAbol1(arb : arbol; x : string): integer;
begin
	if(arb <> nil)then begin
		if(arb^.elem.marca = x)then
			RecorrerAbol1:= RecorrerAbol1(arb^.HD,x)+RecorrerAbol1(arb^.HI,x)+1
		else
			RecorrerAbol1:= RecorrerAbol1(arb^.HD,x)+RecorrerAbol1(arb^.HI,x);
	end
	else
		RecorrerAbol1:= 0;
end;

function recorrerLista (l : lista): integer;
begin
	if(l <> nil)then
		recorrerLista := 1 + recorrerLista(l^.sig)
	else
		recorrerLista := 0;
end;

function RecorrerArbol2 (arb : arbol2; x : string): integer;
begin
	if(arb <> nil)then begin
		if(arb^.marca = x)then
			RecorrerArbol2:=recorrerLista(arb^.elem)
		else
			if(x > arb^.marca)then
				RecorrerArbol2:=RecorrerArbol2(arb^.HD,x)
			else
				RecorrerArbol2:=RecorrerArbol2(arb^.HI,x);
	end
	else
		RecorrerArbol2:= 0;
end;

VAR
	arb1 : arbol;
	arb2 : arbol2;
	marcaBusqueda : string;
BEGIN
	arb1 := nil;
	arb2 := nil;
	cargarStock(arb1,arb2);
	
	readln(marcaBusqueda);
	RecorrerAbol1(arb1,marcaBusqueda);
	RecorrerArbol2(arb2,marcaBusqueda);
END.

