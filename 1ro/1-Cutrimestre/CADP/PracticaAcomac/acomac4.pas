
program untitled;
CONST

TYPE
	listaN = ^nodoN;
	nodoN = record
		elem : intege[4..10];
		sig : listaN;
	end;
	
	alumno = record
		numero : integer;
		año : integer;
		notas : listaN;
	end;
	
	lista = ^nodo;
	nodo = record;
		elem : alumno;
		sig : lista;
	end;

procedure agregarAtrazN (var l : listaN; var ult : listaN; x : integer); {A}
var
	nuevo : listaN;
begin
		if(x <> -1) then begin
			new(nuevo);
			nuevo^.elem := x;
			nuevo^.sig := nil;
			if(l = nil)then
				l := nuevo
			else
				ult^.sig := nuevo;
			ult := nuevo;
		end;
end;

procedure cargarNotas (var ln : listaN); {A}
var
	ult : listaN;
	n : integer;
begin
	readln(n);
	agregarAtrazN(ln,ult,n);
	if(n <> -1)then begin
		agregarAtraz(ln,ult,n);
		reandln(n);
	end;
end;

procedure cargarAlumno (var a : alumno); {A}

begin
	readln(a.numero);
	readln(a.año);
	cargarNotas(a.notas);
end;

procedure agregarAtras (var l : lista; var ult : lista; a : alumno); {A}
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := a;
	nuevo^.sig := nil;
	if(l = nil)then
		l := nuevo
	else
		ult^.sig := nuevo;
	ult := nuevo;
end;

procedure cargarLista (var l : lista); {A}
var
	ult := lista;
	a : alumno;
begin
	cargarAlumno(a);
	while(a.numero <> -1)do begin
		agregarAtras(l,ult,a);
		cargarAlumno(a);
	end;
end;

function totalNotas(ln : listaN): integer; {B}
var
	x, z : integer;
begin
	x := 0;
	z := 0;
	while(ln <> nil)do begin
		x := x + ln^.elem;
		z := z + 1;
		ln := l^.sig;
	end;
	totalNotas := x DIV z; {writeln(totalNotas := x DIV z)??}
end:

procedure superanPromedio (var l2 : lista; a : alumno; x : integer); {B}
var
	ult : lista;
	z : integer;
begin
	z := totalNotas(a.notas);
	writeln(z); {C}
	if(z >= x)then
		agregarAtras(l2,ult,a);
end;

procedure recorrerLista (l : lista; var l2 : lista); {B}
var
	x : integer;
begin
	readln(x);
	while(l <> nil)do begin
		superarPormedio(l2,l^elem,x)
		l := l^.sig;
	end;
end;



VAR

BEGIN
	
	
END.

