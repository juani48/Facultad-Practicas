
program Ejercicio2;
Const
	tam:= 199;
	
Type
	atomo = record
		Nombre : string;
		Protones : real;
		Neutrones : real;
		Electrones : real;
		end;
		
	tabla = array [1..tam] to atomo;
	
Procedure leerAtomo (var a : atomo); {read del atomo}
	begin
		with a do
			begin
				write('Introdusca el nombre del atomo: ');
				readln(Nombre);
				write('Introdusca la cantidad de protones: ');
				readln(Protones);
				write('Introdusca la cantidad de neutrones:');
				readln(Neutrones);
				write('Introdusca la cantidad de electrones:');
				readln(Electrones);
			end;
	end;

Procedure LeerTabla (var a : atomo; var l : tabla); {read de la tabla}
	var
		i : integer;
	begin
		for i = 1 to tam do begin
			readln(a);
			l[i] := a;
		end;
	end;

Procedure CorespondenciaP (a : atomo; l : tabla; var a2 : atomo; p : real; var pude : boolean); {indica si los protones coinciden con algun elemento de la tabla}
	var
		i : integer;
	begin
		i := 1;
		while(l[i].Protones <> p) and (i <= tam)do
			i := i + 1;
		
		if(l[i].Protones = p)then begin
			pude := true;
			a2 := l[i];
			end
		else
			pude := false;
	end;
	
Function EstaTabla (a : atomo; t : tabla): boolean; {indica si el elemnto igresado esta en la tabla o es isotopo}
	var
		i : integer;
		x : boolean;
	begin
		i:= 1;
		while(a.Protones <> t[i].Protones) and (i <= tam)do
			i:= i + 1;
		if(a.Neutrones = t[i].Neutrones) and (i <= tam) then
			EstaTabla := true
		else
			if(a.Neutrones <> t[i].Neutrones) and (i <= tam) then
				EstaTabla := false
			else
				EstaTabla := false;
	end;


	
BEGIN
	
	
END.

