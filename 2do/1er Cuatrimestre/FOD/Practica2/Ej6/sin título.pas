program untitled;
Const
	error = -1;

Type
	log = record
		cod_usuario : integer;
		fecha : integer;
		tiempo_sesion : double;
		end;
		
	log_central = record
		cod_usuario : integer;
		fecha : integer;
		tiempo_total : double;
		end;
	
	maestro = file of log_central;
	detalle = file of log;

procedure Leer (var det : detalle; var reg_d : log);
begin
	if(eof(det))then begin
		reg_d.fecha := error;
		reg_d.cod_usuario := error;
	end
	else
		read(det,reg_d);
end;

procedure Embudo(var det_1 : detalle; var det_2 : detalle; var det_3 : detalle; var reg_d1 : log; var reg_d2 : log; var reg_d3 : log; var min : log);
var
	x : integer;
begin
	//obtengo la fecha mas chicha
	if(reg_d1.fecha < reg_d2.fecha)and(reg_d1.fecha < reg_d3.fecha)then
		x := reg_d1.fecha
	else
		if(reg_d2.fecha < reg_d1.fecha)and(reg_d2.fecha < reg_d3.fecha)then 
			x := reg_d2.fecha
		else
			if(reg_d3.fecha < reg_d1.fecha)and(reg_d3.fecha < reg_d2.fecha)then 
				x := reg_d3.fecha;
	//luego si es la fecha mas chica, el codigo mas chico		
	if(reg_d1.fecha = x)and(reg_d1.cod_usuario < reg_d2.cod_usuario)and(reg_d1.cod_usuario < reg_d3.cod_usuario)then begin
		min := reg_d1;
		Leer(det_1,reg_d1);
	end
	else
		if(reg_d2.fecha = x)and(reg_d2.cod_usuario < reg_d1.cod_usuario)and(reg_d2.cod_usuario < reg_d3.cod_usuario)then begin
			min := reg_d2;
			Leer(det_2,reg_d2);
		end
		else
			if(reg_d3.fecha = x)and(reg_d3.cod_usuario < reg_d1.cod_usuario)and(reg_d3.cod_usuario < reg_d1.cod_usuario)then begin
				min := reg_d3;
				Leer(det_3,reg_d3);
			end;
end;

procedure Merge (var _maestro : maestro; var det_1 : detalle; var det_2 : detalle; var det_3 : detalle);
var
	reg_d1, reg_d2, reg_d3, min : log;
	reg_m : log_central;
begin
	reset(det_1); reset(det_2); reset(det_3); rewrite(_maestro);
	
	Leer(det_1,reg_d1); Leer(det_2,reg_d2); Leer(det_3,reg_d3);
	Embudo(det_1, det_2, det_3, reg_d1, reg_d2, reg_d3, min);
	
	while(min.cod_usuario <> error)and(min.fecha <> error)do begin
		reg_m.fecha := min.fecha;
		reg_m.cod_usuario := min.cod_usuario;
		reg_m.tiempo_total := 0;
		while(reg_m.fecha = min.fecha)and(reg_m.cod_usuario = min.cod_usuario)do begin
			reg_m.tiempo_total := reg_m.tiempo_total + min.tiempo_sesion;
			Embudo(det_1, det_2, det_3, reg_d1, reg_d2, reg_d3, min);
		end;
		write(_maestro, reg_m);
	end;
	close(det_1); close(det_2); close(det_3); close(_maestro);
end;

VAR
	_maestro : maestro;
	detalle_1, detalle_2, detalle_3 : detalle;
BEGIN
	assign(_maestro, 'maestro.dat');
	assign(detalle_1, 'detalle_1.dat');
	assign(detalle_2, 'detalle_2.dat');
	assign(detalle_3, 'detalle_3.dat');
	Merge(_maestro,detalle_1,detalle_2,detalle_3);
END.

