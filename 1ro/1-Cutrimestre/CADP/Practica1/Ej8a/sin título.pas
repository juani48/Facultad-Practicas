
program Practica1Parte2EJ8a;
Type
	atomo = record
		Nombre : string;
		Protones : integer;
		Neutrones : integer;
		Electrones : integer;
		end;

Procedure leer (var a : atomo); {read del atomo}
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

Function Masa (a : atomo) integer; {saca la masa del atomo}
	Masa := (a.Protones * 1,0) + (a.Electrones * 0,000555556) + (a.Neutron * 1,0005);
uses crt;
var
	Atomo : atomo;
BEGIN
	leer(Atomo);
	write(Masa);
END.
