program untitled;
Const
	
Type
	asistente = record
		numero : integer;
		apellido : string;
		nombre : string;
		email : string;
		telefono : integer;
		dni : integer;
		end;

	archivo = file of asistente;

procedure cargarAsistente ( var x : asistente);
begin
	readln(x.numero);
	readln(x.apellido);
	readln(x.nombre);
	readln(x.email);
	readln(x.telefono);
	readln(x.dni);
end;


BEGIN
	
	
END.

