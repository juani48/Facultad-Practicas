program untitled;
Const
	df = 10;
Type
	sub_codigos = 1..15;
	sub_vendidas = 1..99;
	
	venta = record
		dia : integer;
		codigo : sub_codigos;
		cant_vendida : sub_vendidas;
		end;
	
	vector = array[1..df] of venta;

procedure CargarVenta(var v : venta);
begin
	writeln('Ingrese el dia de venta');
	readln(v.dia);
	if(v.dia <> 0)then begin
		Randomize;
		v.codigo := Random(15);
		v.cant_vendida := Random(99);
	end;
end;

procedure CargarVector (var v : vector; var dl : integer);
var
	x : venta;
begin
	writeln('Cargando el vector');
	CargarVenta(x);
	dl := 0;
	while(x.dia <> 0)and(dl < df)do begin
		dl := dl + 1;
		v[dl] := x;
		CargarVenta(x);
	end;
	writeln('Fin de la carga del vector');
end;

procedure Mostrar(v : vector; dl : integer);
var
	i : integer;
begin
	writeln('Mostando vector');
	for i := 1 to dl do begin
		writeln('[ dia: ',v[i].dia,' codigo: ',v[i].codigo,' cantidad vendida: ',v[i].cant_vendida,' ]');
	end;
	writeln('Fin de la muestra');
end;

procedure Seleccion (var v : vector; dl : integer);
var
	i, j , pos : integer;
	aux : venta;
begin
	for i := 1 to dl-1 do begin
		pos := i;
		for j := i+1 to dl do begin
			if(v[j].codigo < v[pos].codigo) then
				pos := j;
		end;
		aux := v[j];
		v[j] := v[pos];
		v[pos] := aux;
	end;
end;

procedure Insercion (var v : vector; dl : integer);
var
	i , j : integer;
	act : venta;
begin
	writeln('Odenando vector');
	for i := 2 to dl do begin
		j := i-1;
		act := v[i];
		while(j>0)and(v[j].codigo > act.codigo)do begin
			v[j+1] := v[j];
			j := j-1;
		end;
		v[j+1] := act;
	end;
	writeln('Vector ordenado');
end;

procedure Eliminar(var v : vector; var dl : integer; min : integer; max : integer);
var
	i : integer;
	x : integer;
begin
	x := max-min;
	for i := min to max do
		v[i] := v[i+x];
	dl := dl - (max-min);
end;

VAR
	v : vector;
	dl : integer;
	max, min : integer;
BEGIN
	CargarVector(v,dl);
	Mostrar(v,dl);
	Insercion(v,dl);
	Mostrar(v,dl);
	writeln('Ingrese dos numeros, primero el minimo');
	readln(min);
	readln(max);
	Eliminar(v,dl,min,max);
	Mostrar(v,dl);
END.

