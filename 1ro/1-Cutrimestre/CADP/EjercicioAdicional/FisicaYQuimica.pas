
program Ejercico1;
Const
	CantAtom = 30;
	tam = 119;
Type
	atomo = record
		Nombre : string;
		Protones : real;
		Neutrones : real;
		Electrones : real;
		end;
		
	tabla = array [1..tam] to atomo;
	
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

Function Masa (a : atomo): real; {saca la masa del atomo}
	var
		ProMasa : real;
		ElecMasa : real;
		NeuMasa : real;
		Total : real;
	begin
		Total := 0;
		ProMasa := a.Protones;
		ElecMasa := a.Electrones * 0.000555556;
		NeuMasa := a.Neutrones * 1.0005;
		
		Total := ProMasa + ElecMasa+ NeuMasa;
		Masa := Total;
	end;
	
Function Masico (a : atomo): real; {saca el numero masico del atomo}
	begin
		Masico:= a.Protones + a.Neutrones;
	end;

Function Carga (a : atomo): char; {Carga del atomo}

	begin
		if(a.Protones = a.Electrones) then
			Carga := '0'
		else
			if(a.Protones > a.Electrones) then
				Carga := '+'
			else 
				if(a.Protones < a.Electrones) then
					Carga := '-'
	end;
	
Function Isotopo (a : atomo; b : atomo): string; {Saca si B es isotopo de A}
	var
		NumAtom1, NumAtom2 : real;
	begin
		NumAtom1 := Masa(a);
		NumAtom2 := Masa(b);
		if (NumAtom1 = NumAtom2) and (a.Neutrones <> b.Neutrones) then
			Isotopo := 'El atomo B es isotopo de A'
		else
			Isotopo := 'El atomo B no es isotopo de A';
	end;

{programa principal}
var
	Atomo1, AtomoMin: atomo;
	i, Ato0, Ato1, MinM : integer;
	Max1, Max2 : string;
	x : char;
	M, MaxMasa1, MaxMasa2 : real;
BEGIN
	Ato0 := 0;
	Ato1:= 0;
	MaxMasa1 := -1;
	MaxMasa2 :=-1;
	MinM := 9999;
	Max1:= ' ';
	
	for i := 1 to CantAtom do begin
		{writeln('Ingrese el atomo ', i, 'de ' CantAtom);}
		leer(Atomo1);
		
		x := Carga(Atomo1); {que valor carga tiene el atomo}
		if(x = '+')then
			Ato0 := Ato0 + 1
		else
			if(x = '-')then
			Ato1 := Ato1 + 1;
			
		M := Masa(Atomo1); {para saber cuales son los atomos mas pesados}
		if (M >= MaxMasa1)then begin
			{prepara a Max1 para ser el valor mas alto}
			MaxMasa2 := MaxMasa1;
			Max2 := Max1;
			{Max1 como mas alto}
			MaxMasa1 := M;
			Max1 := Atomo1.Nombre;
			end
		else
			if(M >= MaxMasa2)then begin
			MaxMasa2 := M;
			Max2 := Atomo1.Nombre;
			end;
		
		
		if(Masico(Atomo1) >= MinM) then {Para saber el atomo como numero M mas chico}
			AtomoMin := Atomo1;
		end;
			
	writeln('La cantidad de iones positivos ingresados es de ', Ato0, ' y de iones negativos es de ', Ato1);
	writeln('El nombre del atomo mas pesado es ', Max1, ' y el nombre del segundo mas pesado es ', Max2);
	writeln('el nombre del atomo con menor numero masico es ', AtomoMin.Nombre ,' ,con ', AtomoMin.Protones,' protones, ', AtomoMin.Electrones,'electrones y ', AtomoMin.Neutrones,'neutrones.');
	
END.
