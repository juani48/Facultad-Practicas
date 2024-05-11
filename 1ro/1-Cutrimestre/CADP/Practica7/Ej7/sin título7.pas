program untitled;
CONST
	tam = 24;
TYPE
	materias = array [1..tam] of integer;
	
	alumno = record;
		NumAlum : integer;
		Apellido : string;
		Nombre : string;
		Correo : string;
		añoIngre : integer;
		añoEgre : integer;
		notas : materias;
		dl : integer;
		end;
		
	lista = ^nodo;
	nodo = record;
		elem : alumno;
		sig : lista
		end;
		
	lista2 = ^nodo2;
	nodo2 = record;
		elem : integer;
		sig : lista
		end;
		
	DosAlu = array [1..2] to aqlumno;

{lectura de variables}

procedure ordenarNotas (var m : materias; dl : integer); {ordeno el vector de notas}
var
	i, j, aux, elem : integer;
begin
	for i = 1 to dl-1 do begin
		aux := i;
		for j = i+1 to dl do
			if(m[j] > m[aux])then {desendente}
				aux := j;
		elem := m[aux];
		m[aux] := m[i];
		m[i] := elem;
	end
end;

procedure cargaNotas (var m : materias; var dl : integer); {cargo las materias probadas del alumno}
var
	i, dl: integer;
begin
	i := 1;
	while (i <= tam)do begin
		readln(m[i]);
		i := i +1;
	end;
	ordenarNotas(m,dl)
end;

procedure cargarAlumno (var a : alumno); {cargo el alumno}
var
	m : materias;
	x : integer;
begin
	readln(a.NumAlum);
	readln(a.Apellido);
	readln(a.Nombre);
	readln(a.Correo);
	readln(a.añoIngre);
	readln(a.añoEgre);
	cargaNotas(m,x);
	ordenarNotas(m,x);
	a.notas := m;
	a.dl := x;
end;

procedure agregarAtras (var l : lista; var ult : lista; a : alumno);
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := a;
	nuevo^.sig := nil;
	if(l = nil)the
		l := nuevo;
	else
		ult^.sig := nuevo;
	ult := nuevo;
end;

procedure cargarLista (var l : lista);
var
	a : alumno
	ult : lista;
begin
	cargarAlumno(a);
	while(a.CodAlum <> -1)do begin
		agregarAtras(l,ult,a);
		cargarAlumno(a);
	end;
end;

{resolucion de problema}

procedure promedio (l : lista; var l2 : lista2); {72a} 
var
	nuevo, ult : lista2
	i, x : integer;
begin
	x := 0;
	for i = 1 to l^.elem.dl do
		x := x + l^.elem.materias[i];
	new(nuevo);
	nuevo^.elem := x;
	nuevo^.sig := nil;
	if(l2 = nil)then
		l2 := nuevo;
	else
		ult^.sig := nuevo;
	ult := nuevo;
end;

function Imp (l : lista): boolean; {72b}
var
	num, t, x : integer;
begin
	num := l^.elem.NumAlum;
	while(num <> 0)do begin
		if not (num MOD 2 = 0)then
			x := x + 1;
		t := t + 1;
		num := num DIV 10;
	end;
	if(x = t)then
		Imp := true
	else
		imp := false;
end; 

procedure Ingr2012 (l : lista; var cant : integer); {72b}
var

begin
	if(l^.elem.añoIngre) and (Imp(l))then
		cant := cant +1;
end;

procedure AluRapidos (l : lista; var DA : DosAlu); {72c}
var
	max1, max2 : integer;
begin
	max1 := 9999;
	max2 := 9999;
	if(l^.elem.añoEgre - l^.elem.añoIngre >= max1)then begin
		max2 := max1;
		DA[2]:= DA[1];
		max1 := l^.elem.añoEgre - l^.elem.añoIngre;
		DA[1] := l^.elem;
	else
		if(l^.elem.añoEgre - l^.elem.añoIngre >= max2)then begin
			max2 := l^.elem.añoEgre - l^.elem.añoIngre;
			DA[2] := l^.elem;
		end;
	end;
end;

procedure recorrerLista (l : lista; var l2 : lista2; var DA : DosAlu);
var
	cant : integer;
begin
	cant := 0;
	while(l <> nil)do begin
		promedio(l,l2);
		Ingr2012(l,cant);
		AluRapidos(l,DA);
		l := l^.sig;
	end;
	writeln(cant);
end;

procedure Eliminar (var l : lista; x : integer); {3}
var 
	act, ant : lista;
begin
	act := l;
	while(act^.elem.CodAlu = x)do
		ant := act;
		act := act^.sig;
	if(act = l)then begin
		l := l^.sig;
		dispose(act);
		end
	else begin
		ant^.sig := act^.sig;
		dispose(act);
	end;
end;

{PP}
VAR
	l : lista;
	l2 : lista2;
	l3 : lista3;
	DA : DosAlu;
	x : integer;
BEGIN
	l := nil;
	l2 := nil;
	l3 := nil;
	readln(x);
	{cargo la lista}
	{recorro lista}
	cargarLista(l);
	recorrerLista(l,l2,l2,DA);
	Eliminar(l,x);
END.

