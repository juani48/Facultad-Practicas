
program untitled;

Const
	tam = 5;
Type

	Zona = 1.. tam;

	propiedad = record
		cod : integer ;
		tipo : integer;
		zona : Zona;
		metros : real;
		precio : real;
		end;
		
	lista = ^nodo;
	nodo = record
		elem : propiedad;
		sig : lista;
		end;
	
	lista2 =^nodo2;
	nodo2 = record
		elem : integer;
		sig : lista2;
		end;
		
procedure cargarP (x : propiedad);
begin
	readln(x.precio);
	if(x.precio <> -1)then begin
		readln(x.cod);
		readln(x.tipo);
		readln(x.zona);
		readln(x.metros);
	end;

end;

procedure InsertarOrdenado (var l :lista ; x : propiedad);
var
	ant,act,nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := nil;
	
	act:= l;
	while(act <> nil)and(act^.elem.zona <>nuevo^.elem.zona)do begin
		ant := act;
		act := act^.sig;
	end;
	if(act^.elem.zona = nuevo^.elem.zona) then begin
		while(act <> nil)and(act^.elem.tipo > nuevo^.elem.tipo)do begin
			ant := act;
			act := act^.sig;
		end;	
	end;
	
	if(act = l)then begin
		nuevo^.sig := l;
		l := nuevo;
	end
	else begin
		ant^.sig := nuevo;
		nuevo^.sig := act;
	end;
end;

procedure cargarL (var l : lista);
var
	x:propiedad;
begin
	cargarP(x);
	while(x.precio <> -1)do begin
		InsertarOrdenado(l,x);
		cargarP(x);
	end;
end;

procedure B (l : lista ; Nzona : Zona ; tipoPorpiedad : integer ; var l2 : lista2);
var
	nuevo,ult : lista2;
begin
	l2 := nil;
	ult := nil;
	while(l<>nil)and(l^.elem.zona <> Nzona)do
		l:= l^.sig;
	while(l<>nil)and(l^.elem.zona=Nzona)and(l^.elem.tipo<>tipoPorpiedad)do
		l:= l^.sig;
	while(l<>nil)and(l^.elem.zona=Nzona)and(l^.elem.tipo=tipoPorpiedad)do begin
		new(nuevo);
		nuevo^.elem:=l^.elem.cod;
		nuevo^.sig := nil;
		
		if(l2 = nil)then
			l2 := nuevo
		else
			ult^.sig:=nuevo;
		ult:=nuevo;
	end;
end;

VAR
	l : lista;
	l2: lista2;
	x:Zona;
	z:integer;
BEGIN
	l:= nil;
	cargarL(l);
	readln(x);
	readln(z);
	B(l,x,z,l2); 
END.

