/*procedimiento almacenado consulta comunero*/
create procedure consulta_comunero()
select * from comunero;

/*procedimiento almacenado consulta comunero por id*/
create procedure consulta_comuneroID(pk_comuner int)
select * from comunero where pk_comunero=pk_comuner;

/*procedimiento almacenado para filatrar comunero por cedula*/
create procedure filtraComunero_cedula(
cedul varchar(25)
)
select * from comunero
where cedula like concat('%',cedul,'%');

/*filtrar comunero por nombres y apellidos ************************verificar uso si no se usa borrar igual a filtrar por cedula*/
create procedure filtraComunero_nomape(
primernombre varchar(25),
segundonombre varchar(25),
primerapellido varchar(25),
segundoapellido varchar(25)
)
select * from comunero
where primer_nombre like '%primernombre%' 
or segundo_nombre like '%segundonombre%'
or primer_apellido like '%primerapellido%'
or segundo_apellido like '%segundoapellido%'; 


/*procedimiento almacenado para guardar un comunero nuevo*/
create procedure guardar_comunero(
cedul varchar(15),
primer_nombr varchar(25) ,
segundo_nombr varchar(25),
primer_apellid varchar(25),
segundo_apellid varchar(25),
telefon varchar(15),
fecha_nacimient date,
eda int,
fk_comun int,
direccion_viviend varchar(500),
referencia_geografic varchar(500)
)
Insert into comunero(cedula,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,telefono,fecha_nacimiento,edad,fk_comuna,direccion_vivienda,referencia_geografica) 
			  values(cedul,primer_nombr,segundo_nombr,primer_apellid,segundo_apellid,telefon,fecha_nacimient,eda,fk_comun,direccion_viviend,referencia_geografic);

/*procedimiento almacenado para eliminar un comunero*/
create procedure eliminar_comunero(
pk_comuner int
)
delete from comunero where pk_comunero=pk_comuner;

/*metodo para actualizar los datos del comunero*/
create procedure actualizar_comunero(
pk_comuner int,
cedul varchar(15),
primer_nombr varchar(25),
segundo_nombr varchar(25),
primer_apellid varchar(25),
segundo_apellid varchar(25),
telefon varchar(15),
fecha_nacimient date,
eda int,
fk_comun int,
direccion_viviend varchar(500),
referencia_geografic varchar(500)
)
update comunero set 
cedula =cedul,
primer_nombre = primer_nombr,
segundo_nombre = segundo_nombr,
primer_apellido = primer_apellid,
segundo_apellido = segundo_apellid,
telefono = telefon,
fecha_nacimiento = fecha_nacimient,
edad = eda,
fk_comuna = fk_comun,
direccion_vivienda = direccion_viviend,
referencia_geografica = referencia_geografic 
where pk_comunero=pk_comuner;

/*procedimiento almacenado para listar comunas*/
create procedure listar_comuna()
select * from comuna;

/*procedimiento para guardar tipo de usuario*/
create procedure guardar_tipousuario(
pk_tipousuari int,
tipo_usuari varchar(25)
)
insert into tipousuario(pk_tipousuario, tipo_usuario)values(pk_tipousuari, tipo_usuari);

/*procedimiento para listar tipo de usuario*/
create procedure listar_tipousuario()
select * from tipousuario;

/*procedimiento para guardar usuario*/
create procedure guardar_usuario(
usuari varchar(50),
contraseñ varchar(25),
fk_tipousuari int,
cedul varchar(15)
)
insert into login(usuario,contraseña,fk_tipousuario,fk_comunero) values(usuari,contraseñ,fk_tipousuari,(select pk_comunero from comunero where cedula = cedul ));

/*procedimiento para listar usuario*/
create procedure listar_usuario()
select * from login;

create procedure listar_usuarioID(fk_comuner int)
select * from login where fk_comunero=fk_comuner;

/*procedimiento almacenado para eliminar usuarios*/
create procedure eliminar_login(pk_comun int)
delete from login where fk_comunero=pk_comun;

/*procedimiento almacenado para editar usuario*/
create procedure actualizar_usuario(
usua varchar(50),
contras varchar(25),
fk_tipusu int,
pk_comun int
)
update login set usuario=usua,contraseña=contras,fk_tipousuario=fk_tipusu where fk_comunero=pk_comun;

/*procedimiento almacenado para listar medidor de un comunero*/
create procedure listar_medidor_comunero(dato varchar(100))
select pk_medidor,numero_medidor from medidor where 
 fk_comunero=(select pk_comunero from comunero where CONCAT(primer_nombre," ",segundo_nombre," ",primer_apellido," ",segundo_apellido) = dato or cedula=dato);
 
 /*procedimiento almacenado para listar los datos del comunero por cedula*/
create procedure listar_datos_comunero_ced_nom(dato varchar(100))
 select pk_comunero,cedula,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido
 from comunero
 where cedula=dato or CONCAT(primer_nombre," ",segundo_nombre," ",primer_apellido," ",segundo_apellido) = dato;

/*procedimiento almacenado para seleccionar el maximo consumo de un medidor---------------*/
create procedure datos_lectura_medidor(num_medidor varchar(30))
select max(lectura_actual) as lectura_actual from consumo where fk_medidor=(select pk_medidor from medidor where numero_medidor=num_medidor);
 
 /*procedimiento almacenado para verificar cuantos tipos de consumo tiene cada comuna*/
 create procedure consulta_tipo_consumo_porcedula(cedul varchar(15))
 select tipo_consumo,limitem_cubico,valor,tarifa_basica,tarifa_ambiente,alcantarillado from tipoconsumo
 where fk_comuna=(select fk_comuna from comunero where cedula=cedul)
 order by limitem_cubico asc
 ;
 
/*procedimiento almacena para consultar el numero de dias a aumentar a la fecha actual*/
create procedure consultaFechaLimitePago(fk_comune int)
select DATE_ADD(CURDATE(),INTERVAL LimiteDias DAY) as fechaLimite from LimiteDias
where fk_comuna=(select fk_comuna from comunero where pk_comunero=fk_comune);

/*procedimiento almacenado para guardar el consumo*/
Delimiter $$
create procedure guardarconsumo(lectura_ante int, lectura_actual int, fecha_lectu varchar(15), fecha_limit varchar(15),consumo_mcubi int,total_pag double, nummedidor varchar(15),tipocon varchar(15))
BEGIN
insert into consumo (lectura_anterior,lectura_actual,fecha_lectura,fecha_limite_pago,consumo_mcubico,total_pagar,fk_medidor,fk_tipoconsumo) values(lectura_ante,lectura_actual,fecha_lectu,fecha_limit,consumo_mcubi,total_pag,(select pk_medidor from medidor where numero_medidor=nummedidor),
(select pk_tipoconsumo from tipoconsumo where tipo_consumo=tipocon and fk_comuna=(select fk_comuna from comunero where pk_comunero=(select fk_comunero from medidor where numero_medidor=nummedidor))));
insert into cobro_agua(
fk_consumo,
fecha_cacelacion,
dias_retraso,
fk_multas,
valor_multa ,
totalpagar ,
fk_estado_pagos ) values(
(select max(pk_consumo) as pk_consumo from consumo where fk_medidor=(select pk_medidor from medidor where numero_medidor=nummedidor)),
fecha_limit,0,1,0,total_pag,2
 );
end $$
DELIMITER $$;

/*procedimiento almacenado para cobrar por el consumo de agua se ase una
actualizacion de la fecha de cancelacion, dias de retraso, fk de fultas, valor de la multa, total pagar,*/

create procedure cobraragua(fecha_cancel varchar(15),dias_retra char(10),fk_multa int, valor_mult decimal(8,2),total_pagar decimal(8,2),fk_estado_pago int)
update cobro_agua set fecha_cancelacion=fecha_cancel, dias_retraso=dias_retra, fk_multas=fk_multa, valor_multa=valor_mult, totalpagar=total_pagar, fk_estado_pagos=fk_estado_pago;

/********************************/
/*procedimiento almacenado para buscar los consumos que aun no estan cancelados*/
DELIMITER $$
create procedure buscarConsumo_impaga(pk_medid int)
begin
SET lc_time_names = 'es_ES';
select pk_consumo,concat(MONTHNAME(fecha_lectura)," ",year(fecha_lectura)) as datoconsum from consumo join cobro_agua
on consumo.pk_consumo=cobro_agua.fk_consumo
where fk_medidor=pk_medid and fk_estado_pagos=2;
end$$
DELIMITER $$;


select pk_consumo,lectura_anterior,lectura_actual,fecha_lectura, fecha_limite_pago,consumo_mcubico,total_pagar,tipo_consumo, if(curdate()>fecha_limite_pago,(select tipo_multa from multas where tipo_multa="Retraso"
and fk_comuna=(select fk_comuna from comunero where cedula=1707616395)),"Sin Recargo") as tipomulta, if(TIMESTAMPDIFF(DAY, fecha_limite_pago, curdate())<=0,"0",TIMESTAMPDIFF(DAY, fecha_limite_pago, curdate())) as diasretraso, if(curdate()>fecha_limite_pago,(select valor from multas where tipo_multa="Retraso"
and fk_comuna=(select fk_comuna from comunero where cedula=1707616395)) *  if(TIMESTAMPDIFF(DAY, fecha_limite_pago, curdate())<=0,"0",TIMESTAMPDIFF(DAY, fecha_limite_pago, curdate())),"0.00") as valormulta  from consumo join cobro_agua
on consumo.pk_consumo=cobro_agua.fk_consumo
join tipoconsumo
on consumo.fk_tipoconsumo=tipoconsumo.pk_tipoconsumo
where pk_consumo=13;
select * from consumo;
select * from cobro_agua;
select con.consumo_mcubico,tipcon.tipo_consumo,con.fecha_lectura,con.fecha_limite_pago,con.total_pagar as subtotal, if(TIMESTAMPDIFF(day, con.fecha_limite_pago, curdate())<0,0,TIMESTAMPDIFF(day, con.fecha_limite_pago, curdate())) as dias_retraso, if(curdate()<=con.fecha_limite_pago,"Sin Recargo",(select tipmul.tipo_multa from multas as tipmul where tipo_multa="Retraso" and fk_comuna=(select fk_comuna from comunero where cedula=1707616395))) as tipo_multa, round((TIMESTAMPDIFF(day, con.fecha_limite_pago, curdate()) * if(TIMESTAMPDIFF(day, con.fecha_limite_pago, curdate())<0,"0.00",(select valor from multas where tipo_multa="Retraso" and fk_comuna=(select fk_comuna from comunero where cedula=1707616395)))),2) as total_multa, tipcon.tarifa_ambiente,tipcon.alcantarillado,round((con.total_pagar+tipcon.tarifa_ambiente+tipcon.alcantarillado+(TIMESTAMPDIFF(day, con.fecha_limite_pago, curdate()) * if(TIMESTAMPDIFF(day, con.fecha_limite_pago, curdate())<0,"0.00",(select valor from multas where tipo_multa="Retraso" and fk_comuna=(select fk_comuna from comunero where cedula=1707616395))))),2) as total_pagar from consumo as con
join tipoconsumo as tipcon
on con.fk_tipoconsumo=tipcon.pk_tipoconsumo
where con.pk_consumo=10

/******************************************sirve para calcular los dias aviles de una fecha a otra
Set @fechaTermino = '2020-11-10';
Set @fechaInicio = '2020-05-05';
SELECT
ROUND(((unix_timestamp(@fechaTermino) - unix_timestamp(@fechaInicio) ) /(24*60*60)-7+WEEKDAY(@fechaInicio)-WEEKDAY(@fechaTermino))/7)
 + if(WEEKDAY(@fechaInicio) <= 6, 1, 0)
 + if(WEEKDAY(@fechaTermino) >= 6, 1, 0)
as diasDomingos
*************************************************************/
select 4+5 as suma if(suma>5,"positivo","negativo")


