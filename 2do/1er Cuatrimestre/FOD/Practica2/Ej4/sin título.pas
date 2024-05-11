program untitled;
Const
	error = 'zzz';
Type
	censo = record
		provincia : string;
		localidad : integer;
		alfabetizados : integer;
		encuenstados : integer;
		end;
		
	alfabetizacion = record
		provincia :  string;
		alfabetizados : integer;
		encuestados : integer;
		end;
	
	detalle = file of censo;
	maestro = file of alfabetizacion;

procedure LeerDetalle(var _detalle : detalle; var x : censo);
begin
	if(eof(_detalle))then
		x.provincia := error
	else
		read(_detalle,x);
end;

procedure Embudo( var censo_detalle1 : censo; var censo_detalle2 : censo; var _detalle1 : detalle; var _detalle2 : detalle; var min : censo);
begin
	if(censo_detalle1.provincia < censo_detalle2.provincia)then begin
		min := censo_detalle1;
		LeerDetalle(_detalle1, censo_detalle1);
	end
	else begin
		min := censo_detalle2;
		LeerDetalle(_detalle2, censo_detalle2);
	end;
end;	

procedure Modiifciar(var _maestro : maestro; var _detalle1 : detalle; var _detalle2 : detalle);
var
	reg_d1 : censo; reg_d2 : censo; reg_m : alfabetizacion;
	min : censo;
begin
	reset(_maestro); reset(_detalle1); reset(_detalle2);
	LeerDetalle(_detalle1, reg_d1); LeerDetalle(_detalle2, reg_d2);
	
	Embudo(reg_d1,reg_d2,_detalle1,_detalle2,min);
	
	while(min.provincia <> error)do begin
		read(_maestro,reg_m);
		
		while(min.provincia <> reg_m.provincia)do //busco el registro maestro a modificar
			read(_maestro,reg_m);
			
		while(reg_m.provincia = min.provincia)do begin //busco todos los registros dtalle que modifiquen el registor maestro
			reg_m.alfabetizados := reg_m.alfabetizados + min.alfabetizados;
			Embudo(reg_d1,reg_d2,_detalle1,_detalle2,min);
		end;
		seek(_maestro, filePos(_maestro)-1);
		write(_maestro,reg_m);
	end;
end;

VAR
	_maestro : maestro;
	_detalle1 : detalle; _detalle2 : detalle;
BEGIN
	assign(_maestro, 'maestro.dat');
	assign(_detalle1, 'detalle1.dat');
	assign(_detalle2, 'detalle2.dat');
END.

