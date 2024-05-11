program untitled;

Const

Type
	novela = record
		cod : integer;
		genero : integer;
		nombre : string;
		duracion : double;
		director : string;
		precio : double;
		end;
	
	archivo = file of novela;

procedure cargarNovela(x : novela);
begin
	readln(x.cod);
	readln(x.genero);
end;



BEGIN
	
	
END.

