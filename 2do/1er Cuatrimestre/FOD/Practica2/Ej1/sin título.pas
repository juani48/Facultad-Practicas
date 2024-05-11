program untitled;

Type

	empleado = record
		codEmpl : integer;
		nombre : string;
		monto : double;
		end;
		
	archivo = file of empleado;

//carga del archivo detalle

procedure CrearMaestro (var det : archivo; var mae : archivo);
var
	emplACT : empleado;
	empl : empleado;
begin
	reset(det);
	rewrite(mae);
	read(det,empl);
	while(not eof(det))do begin
		emplACT.monto := 0;
		emplACT.nombre := empl.nombre;
		emplACT.codEmpl := empl.codEmpl;
		while((not eof(det))and(emplACT.codEmpl = empl.codEmpl))do begin
			emplACT.monto := emplACT.monto + empl.monto;
			read(det,empl);
		end;
		write(mae,emplACT);
	end;
	close(det);
	close(mae);
end;

VAR
	mae : archivo;
	det : archivo;
BEGIN
	assign(mae, 'maestro.dat');
	assign(det,'detalle.dat');
	CrearMaestro(det,mae);
END.

