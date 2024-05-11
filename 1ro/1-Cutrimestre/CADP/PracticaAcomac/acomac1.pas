program untitled;
TYPE
	propiedad : record
		zona : string;
		tipo : string;
		precio : real;
		end;

procedure cargarRecord (var x : propiedad);
begin
	readln(x.precio);
	if(x.precio <> -1)then begin
		readln(x.zona);
		readnl(x.tipo);
	end;
end;

VAR
	p : propiedad;
	totalPrecio, cantProp : real;
	zonaACT : string;
	maxProp : propiedad;
BEGIN
	maxProp.precio := -1;
	cargarRecord(p);
	while(p.precio <> -1)do begin
		totalPrecio := 0;
		cantProp := 0;
		zonaACT := p.zona;
		while(p.zona = zonaACT)and(p.precio <> -1)do begin
			cantProp := cantProp + 1;
			totalPrecio := totalPrecio + p.precio;
			if(p.precio >= maxProp.precio)then
				maxProp := p;
			cargarRecord(p);
		end;
		writeln(totalPrecio DIV cantProp);
	end;
	if(maxProp <> 1)then begin
		writeln(maxProp.zona)
		writeln(,axProp.tipo);
	end;
END.

