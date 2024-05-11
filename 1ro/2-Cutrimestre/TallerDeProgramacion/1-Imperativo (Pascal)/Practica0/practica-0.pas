program untitled;
Const
	cant = 36;
Type
	materias = 1..cant;
	
	vector = array [1..cant] of integer;
	
	
	alumnos = record
		apellido : string;
		numero: integer;
		ingreso : integer;
		materiasAprov : materias;
		nota : vector;
		end;
		
		lista = ^nodo;
		nodo = record
			elem : alumnos;
			sig : lista;
			end;
			
		PromedioAlumno = record
			numero : integer;
			prom : real;
			end;
			
		lista2 = ^nodo2;
		nodo2 = record
			elem : PromedioAlumno;
			sig : lista2;
			end;
		
procedure cargarV (var v : vector ; dl : integer);
var
	i: integer;
	x : integer;
begin
	for i := 1 to dl do begin
		readln(x);
		v[i]:= x;
		end;
end;

procedure cargarA (var x : alumnos);

begin
	readln(x.apellido);
	readln(x.numero);
	readln(x.ingreso);
	readln(x.materiasAprov);
	cargarV(x.nota,x.materiasAprov);
end;

procedure AgregarAtras (var l : lista ; var ult : lista ; x : alumnos);
Var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := nil;
	
	if(l = nil) then
		L := nuevo 
	else 
		ult^.sig := nuevo;
	ult := nuevo;
end;

procedure AgregarAtras2 (var l : lista2 ;var ult : lista2; x : PromedioAlumno);
Var
	nuevo : lista2;
begin
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := nil;
	
	if(l = nil) then
		L := nuevo 
	else 
		ult^.sig := nuevo;
	ult := nuevo;
end;

procedure cargarLista (var l : lista);
var 
	ult : lista;
	x : alumnos;
begin
	l := nil;
	cargarA(x);
	while(x.numero <> 1111)do begin
		AgregarAtras(l,ult,x);
		cargarA(x);
	end;
end;

procedure promedio (l : lista; var l2 : lista2);
var
	i : integer;
	x : PromedioAlumno;
	total : integer;
	ult : lista2;
begin
	while(l <> nil)do begin
		total := 0;
		for i := 1 to l^.elem.materiasAprov do begin
			total := total + l^.elem.nota[i];
		end;
		x.prom := total div l^.elem.materiasAprov;
		x.numero := l^.elem.numero;
		AgregarAtras2(l2,ult,x);
		l := l^.sig;
	end;
end;
VAR
l : lista;
l2 : lista2;

BEGIN
	l := nil;
	l2 := nil;
	cargarLista(l);
	promedio(l,l2);
END.

