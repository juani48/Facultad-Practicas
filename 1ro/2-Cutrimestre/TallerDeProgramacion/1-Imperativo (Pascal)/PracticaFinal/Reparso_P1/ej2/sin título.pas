program untitled;

Const
	tam = 300;
Type
	oficina = record
		codigo : integer;
		dni = : integer;
		valor : double;
		end;
	
	vector = array[1..tam] of oficina;

procedure cargarOficina(var x : oficina);
begin
	readln(x.codigo);
	if(x.codigo <> -1)then begin
		Randomize;
		x.dni := Random(301);
		x.valor := Random(301);
	end;
end;

procedure cargarVector(var v : vector; var dl : integer);
var
	o : oficina;
begin
	cargarOficina(o);
	dl := 0;
	while(o.codigo <> -1)and(dl < tam)do begin
		dl := dl + 1;
		v[dl] := o;
		cargarOficina(o);
	end;
end;

procedure insercion(var v : vector; dl : integer);
var 
	i, j : integer;
	elem : oficina;
begin
	for i:= 2 to dl do begin
		j := i-1;
		elem := v[i];
		while(j>=0)and(v[j].codigo > elem.codigo)do begin
			v[j+1] := v[j];
			j:= j -1;
		end;
		v[j+1] := elem;
	end;
end;

procedure seleccion (var v : vector; dl : integer);
var
	i, j ,pos : integer;
	elem : oficina;
begin
	for i := i to dl-1 do begin
		pos := i;
		for j := i+1 to dl do begin
			if(v[j].codigo > v[pos].codigo)then
				pos := j;
		end;
		item := v[pos];
		v[pos] := v[i];
		v[i] := elem;
	end;
end;

BEGIN
	
	
END.

