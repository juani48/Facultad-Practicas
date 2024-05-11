program untitled;
TYPE
	juego : record
		nombre : string;
		cat : string;
		idioma : string;
		cantVotos : integer;
		end;
		
procedure cargarRecord (var x : juego);
begin
	readln(x.nombre);
	if(x.nombre <> 'ZZZ')then begin
		readln(x.cat);
		readln(x.idioma);
		readnl(x.cantVotos);
	end;
end;

procedure 

VAR
	j, maxJuegos, maxVotos : juegos;
	catACT, idiomaACT : string;
	contJuegos, contVotos : integer;
BEGIN
	cargarRecord(p);
	catACT := p.cat;
	idiomaACT := p.idioma;
	maxJuegos.cantVotos := -1;
	maxVotos.cantVotos := -1;
	while(j.nombre <> 'zzz')and(j.cat = catACT)do begin
		
		while(j.nombre <> 'zzz')and(j.idioma = idiomaACT)
		contJuegos := contJuegos + 1;
		contVotos := contVotos + 1;
		
		cargarRecord(p);
	end;
	if(contJuegos >= maxJuegos.cantVotos)then
		maxJuegos.cat := p.cat;
	if(contVotos >= maxVotos.cantVotos)then
		maxVotos.cat := p.cat;
END.

