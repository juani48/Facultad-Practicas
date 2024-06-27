program untitled;
Const
	cursada = 'C';
	final = 'F';
	error = -1;
Type
	alumno = record
		codALU : integer;
		apellido : string;
		nombre : string;
		cursadas : integer;
		finales : integer;
		end;	
	materia = record
		codALU : integer;
		aprobo : char;
		end;
	maestro = file of alumno;
	detalle = file of materia;
procedure Leer (var det : detalle; var mat : materia);
begin
	if(not eof(det))then
		read(det,mat)
	else
		mat.codALU := error;
end;
procedure Modificar (var mae : maestro; var det : detalle);
var
	_materia : materia;
	_alumno : alumno;
begin
	reset(det);
	reset(mae);
	
	Leer(det,_materia);
	while(_materia.codALU <> error)do begin
		read(mae,_alumno);
		
		while(_materia.codALU <> _alumno.codALU)do //busco en el regitor maestro a modificar
			read(det, _materia);
			
		while(_materia.codALU = _alumno.codALU)do begin //como hay repeticion busco hasta donde se repite
			if(_materia.aprobo = 'C')then
				_alumno.cursadas := _alumno.cursadas + 1
			else
				_alumno.finales := _alumno.finales + 1;	
				_alumno.cursadas := _alumno.cursadas - 1;
			Leer(det,_materia);
		end;
		seek(mae, filePos(mae) -1);
		write(mae,_alumno);
	end;
end;

VAR
	mae : maestro;
	det : detalle;
BEGIN
	assign(mae, 'mestro.dat');
	assign(det, 'detalle');
END.

