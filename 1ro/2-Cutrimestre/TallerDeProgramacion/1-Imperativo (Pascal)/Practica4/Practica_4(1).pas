program untitled;
Const
	tam = 300;
Type
	oficina = record
		codigo : integer;
		dni : integer;
		valor : real;
		end;
		
	vector = array [1..tam] of oficina;

procedure cargarOficina (var x : oficina);
begin
	readln(x.codigo);
	if(x.codigo <> -1)then begin
		readln(x.dni);
		readln(x.valor);
	end;
end;

procedure cargarVector (var v : vector; var dl : integer);
var
	x : oficina;
begin
	dl := 0;
	cargarOficina(x);
	while(x.codigo <> -1)do begin
		dl := dl + 1;
		v[dl]:= x;
		cargarOficina(x);
	end;
end;

procedure inserccion (var v : vector; dl : integer);
var
	i,j : integer;
	x : oficina;
begin
	for i:= 2 to dl do begin
		j:= i-1;
		x := v[i];
		while(j > 0)and(v[j].codigo > x.codigo)do begin
			v[j+1]:=v[j];
			j:= j-1;
		end;
		v[j+1]:=x;
	end;
end;

function Dicotomica (v : vector;inf : integer ; dl_sup : integer; iden : integer): integer;
var
	mid : integer;
begin
	mid := (dl_sup + inf) div 2;
	if(mid <> 0)then begin
		if(v[mid].codigo = iden)then
			Dicotomica := mid
		else
			if(iden > v[mid].codigo)then
				Dicotomica := Dicotomica(v,mid+1,dl_sup,iden)
			else
				Dicotomica := Dicotomica(v,inf,mid-1,iden);
	end
	else
		Dicotomica := 0;
end;

function Suma (v : vector; dl : integer; x : real): real;
begin
	if(dl < 0)then begin
		x := v[dl].valor + x;
		Suma := Suma(v,dl-1,x);
	end
	else
		Suma := x;
end;

VAR
	v : vector;
	identificador,dl : integer;
	montoTotal : real;
BEGIN
	dl := 0;
	cargarVector(v,dl);
	readln(identificador);
	identificador:= Dicotomica(v,1,dl,identificador);
	if(identificador<>0)then
		writeln('se ha encontrado el dni del identificador: ', v[identificador].dni)
	else
		writeln('no se ha encontrado el valor');
	montoTotal := 0;
	montoTotal := Suma(v,dl,montoTotal);
END.

