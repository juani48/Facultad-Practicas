program untitled;
CONST
	tam = 6
	tam2 = 10;
TYPE
	criasParto = array [1..tam2] of integer;
	
	conejo = record
		cod : integer;
		ano : integer;
		tipo : integer[1..tam];
		nombre : string;
		partos : integer[1..tam2];
		crias : criasParto;
	end;

	especies = array [1..tam] of integer;

procedure cargarLista (var l : lista);

procedure limpiar (var v : especies);

function masConejos (l : lista): integer; {A}
var
	max,i,z : integer;
	v : especies;
begin
	max := -1;
	limpiar(v);
	while(l <> nil)do begin
		v[l^.elem.tipo] := v[l^.elem.tipo] + 1;
		l := l^.sig;
	end;
	for i = 1 to tam do begin
	 if(v[i] > max)then
		max := v[i];
		z := i;
	end;
	masConejos := z;
end;

procedure mas35 (l : lista; var l2 : lista); {B}
var
	i,total : integer;
	ult : lista;
begin
	ult := nil;
	while(l <> nil)do begin
		total := 0;
		for i = 1 to l^.elem.partos do
			total := total + l^.elem.crias[i];
		if(total >= 35)then
			agregarAtras(l2,ult,l^.elem);
		l := l^.sig;
	end;
end;

function impar (x : integer): boolean; {C} 
begin
	if(x MOD 2 <> 0)then
		impar := true
	else
		impar := flase;
end;

procedure C (l2 : lista); {C}
var

begin
	while(l <> nil)do begin
		if(impar(l^.elem.cod))and(l^.elem.ano < 2020)then
			writeln(l^.elem.nombre);
		l := l^.sig;
	end;
end;

VAR

BEGIN
	
	
END.

