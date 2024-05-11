program P7 E4;
CONST
	tam = 42;
TYPE
	Dia = array [1..tam] of real;
	
	paciente = record;
		nombre : string;
		apellido : string;
		Peso : Dia;
		DL : integer;
		end;
		
	lista = ^nodo;
	nodo = record;
		elem = paciente;
		sig : lista;
		end;

procedure LeerPeso (var d : dia; var x : integer);
var 
	i : integer;
begin
	i := 1;
	x := 0;
	readln(d[i]);
	while(d[i] <> 0)do begin
		x := x + 1;
		i := i + 1;
		readln(d[i]);
	end;
end;

procedure LeerPaciente (p : paciente);
	d : Dia;
begin
	readln(p.nombre);
	readln(p.apellido);
	readln(p.Peso);
	LeerPeso(d,p.DL);
	p.peso := d;
end;
		
procedure agregarAtras (var l : lista; var ult : lista; p : paciente); {cargar cada elemento de la lista}
var
	nuevo : lista;
begin
	new(nuevo);
	nuevo^.elem := p;
	nuevo^.sig := nil:
	if(l = nil)then
		l := nuevo;
	else
		ult^.sig := nuevo;
	ult:= nuevo;
end;	

procedure cargarLista (var l : lista); {armar toda la lista}
var
	ult : lista;
	p : paciente;
begin
	LeerPaciente(p);
	while(p.nombre <> 'xxxx')do begin
		agregarAtras(l,ult,p);
		LeerPaciente(p);
	end;
end;

function MaxPeso (l : lista): integer; {4a}
var
	max, i : integer;
begin
	max := -1;
	for i = 1 to l^.elem.DL do begin
		if(l^.elem.Peso[i] >= max)then
			max := l^.elem.Peso[i];
	end;
	MaxPeso := max;
end;

function TotalPeso (l : lista): integer; {4b}
var
	x, i : integer;
begin
	x := 0;
	for i = 1 to l^.elem.DL do begin
		x := l^.elem.Peso[i];
	end;
	TotalPeso := x;
end; 

procedure recorrerLista (l : lista);
var
begin
	while(l <> nil)do begin
		writeln(MaxPeso(l));
		
		l:= l^.sig;
	end;
end;

{PP}
VAR
	l : lista;
BEGIN
	l := nil;
	cargarLista(l);
	
END.

