program untitled;
Uses sysutils;
Const
	error = -1;
	total_detalles = 10;
Type
	recuento = record
		cod_loc : integer;
		cod_cepa : integer;
		casos_activos : integer;
		casos_nuevos : integer;
		casos_recup : integer;
		casos_fallec : integer;
		end;
	
	registro_maestro = record
		cod_loc : integer;
		nombre_loc : string;
		cod_cepa : integer;
		nombre_cepa : string;
		casos_activos : integer;
		casos_nuevos : integer;
		casos_recup : integer;
		casos_fallec : integer;
		end;

	maestro = file of registro_maestro;
	arch_detalle = file of recuento;
	
	vec_detalle = array[1..total_detalles] of arch_detalle;
	vec_reg = array[1..total_detalles] of recuento;

procedure OpenDetalle(var v_det : vec_detalle);
var
	i : integer;
begin
	for i := 1 to total_detalles do 
		reset(v_det[i]);
end;

procedure CloseDetalle(var v_det : vec_detalle);
var
	i : integer;
begin
	for i := 1 to total_detalles do 
		close(v_det[i]);
end;

procedure leer (var arch : arch_detalle; var dato : recuento);
begin
	if(not eof(arch))then
		read(arch,dato)
	else begin
		dato.cod_loc := error;
		dato.cod_cepa := error;
	end;
end;

procedure minimo (var v_reg : vec_reg; var v_det : vec_detalle; var min_reg : recuento);
var
	i : integer;
	index_min : integer;
begin
	for i := 1 to total_detalles do begin
		if(min_reg.cod_loc < v_reg[i].cod_loc)and(min_reg.cod_cepa< v_reg[i].cod_cepa)then begin
			min_reg := v_reg[i];
			index_min := i;
		end;
	end;
	leer(v_det[index_min], v_reg[index_min]);
end;

procedure actualizar (var arch_maestro : maestro; var v_det : vec_detalle; var v_reg : vec_reg);
var
	cant50 : integer;
	act_reg, min_reg : recuento;
	reg_m : registro_maestro;
begin
	cant50 := 0;
	
	reset(arch_maestro); 
	read(arch_maestro, reg_m);
	
	OpenDetalle(v_det);
	minimo(v_reg, v_det, min_reg);
	
	while(reg_m.cod_loc <> error)do begin
		act_reg := min_reg;
		act_reg.casos_activos := 0;
		act_reg.casos_nuevos := 0;
		act_reg.casos_recup := 0;
		act_reg.casos_fallec:= 0;
		
		while(act_reg.cod_loc = reg_m.cod_loc)and(act_reg.cod_cepa = reg_m.cod_cepa)do begin
			act_reg.casos_activos := act_reg.casos_activos + reg_m.casos_activos;
			act_reg.casos_nuevos := act_reg.casos_nuevos + reg_m.casos_nuevos;
			act_reg.casos_recup := act_reg.casos_recup + reg_m.casos_recup;
			act_reg.casos_fallec := act_reg.casos_fallec + reg_m.casos_fallec;
			
			minimo(v_reg, v_det, min_reg);
		end;
		
		while(reg_m.cod_loc <> act_reg.cod_loc)and(reg_m.cod_cepa <> act_reg.cod_cepa)do begin
			if(reg_m.casos_activos >= 50)then
				cant50 := cant50 + 1;
			read(arch_maestro,reg_m);
		end;
			
		reg_m.casos_activos := act_reg.casos_activos; 
		reg_m.casos_nuevos := act_reg.casos_nuevos;
		reg_m.casos_recup := reg_m.casos_recup + act_reg.casos_recup;
		reg_m.casos_fallec := reg_m.casos_fallec + act_reg.casos_fallec;
		
		seek(arch_maestro, filepos(arch_maestro) -1);
		write(arch_maestro, reg_m);
	end;
	close(arch_maestro);
	CloseDetalle(v_det);
end;

VAR
	v_det : vec_detalle;
	v_reg : vec_reg;
	arch_maestro : maestro;
	i :integer;
BEGIN
	for i := 1 to total_detalles do begin
		assign(v_det[i], 'detalle' + IntToStr(i) + '.dat');
	end;
	assign(arch_maestro,'mastro.dat');
	
	actualizar(arch_maestro, v_det, v_reg);
END.

