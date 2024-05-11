
program untitled;
CONST

TYPE
	avion = record
		cod : integer;
		marca : string;
		modelo : string;
		asientos : integer;
	end;
	
	lista = ^nodo;
	nodo = record
		elem : avion;
		sig : lista;
	end;
	
procedure insertarOrdenado (var l : lista; a : avion);
var
	act, ant, nuevo : lista;
begin
	act := l;
	ant := l;
	while(act <> nil)and(act^.elem.marca < a.marca)do begin
		ant := act;
		act := act^.sig;
	end;
	new(nuevo);
	nuevo^.elem := a;
	nuevo^.sig := nil;
	if(act = l)then
		l := nuevo;
	else
		ant^.sig := nuevo;
	nuevo^.sig := act;
end;

procedur cargarAvion (var a : avion);
begin
	readln(a.asiento);
	if(a.asientos <> -1)then begin
		readln(a.cod);
		readln(a.marca);
		readln(a.modelo);
	end;
end;

procedure cargarLstas (var l : lista);
var
	a : avion;
begin
	cargarAvion(a);
	while(a.asientos <> -1)do begin
		insertarOrdenado(l,a);
		cargarAvion(a);
	end;
end;

procedure insertarAvion (var l : lista;a : avion); {B}
var
	ant, act, nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := a;
	nuevo^.sig := nil;
	act := l;	
	while(act <> nil)and(act^.elem.marca <> a.marca)do begin
		ant := act;
		act := act^.sig;
	end;
	if(act = l)then
		l := nuevo;
	else
		ant^sig := nuevo;
	nuevo^.sig := act;	
end;

procedure eliminar (var l : lista, x : integer); {C}
var
	act, ant : lista;
begin
	act := l;
	while(act <> nil)and(act^.elem.cod <> x)do begin
		ant := act;
		act := act^.sig;
	end;
	if(act <> nil)then begin
		dispose(ant);
		ant^.sig := act;
	end
	else
		{no se consiguio}
end;

procedure avionse200 (l : lista;var l2 : lista); {D}
var
	ult, nuevo : lista;
begin
	ult := nil;
	while(l <> nil)do begin
		if(l^.elem.asientos > 200)then begin
			if(l2 <> nil)then
				l2 := l;
			else
				ult^.sig := l;
			ult := l;
		end;
	end;
end;

procedure eliminarModelo (var l : lista; m : string); {F}
var
	ant, act : lista;
begin
	act := l;
	while(act <> nil)do begin
		while(act <> nil)and(act^.elem.modelo <> m)do begin
			ant := act;
			act := act^.sig;
		end;
		if(act <> nil)then begin
			if(act = l)then begin
				l := l^.sig;
				dispose(act);
				act := l;
			end
			else
				ant^.sig := act^.sig;
				dispose(act);
				act := ant^sig;
		end;
	end;
end;

VAR

BEGIN
	
	
END.

