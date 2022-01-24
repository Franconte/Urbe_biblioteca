/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library.util;

/**
 * Esta clase posee propiedades estaticas que permiten almacenar sentencias SQL y que seran utilizadas
 * posteriormente en conjunto con JdbcTemplate.
 * @author David Soles
 */
public class SQL {

	public static final String SP_MAX_ID = "DECLARE @ret integer EXEC @ret = dbo.sp_max_id ? SELECT @ret as retorno";

	public static final String SP_RESERVE_MAX_ID = "DECLARE @ret integer EXEC @ret = dbo.sp_max_id_reserva ?, ? SELECT @ret as retorno";

	public static final String FIND_ALL_BIBLIOGRAPHIC_MATERIAL = "SELECT * FROM material_bibliografico WHERE estado = 'A'";

	public static final String FIND_BIBLIOGRAPHIC_MATERIAL_BY_ID = "SELECT * FROM material_bibliografico WHERE id_mtb = ? AND estado = 'A'";

	public static final String SAVE_BIBLIOGRAPHIC_MATERIAL = "INSERT INTO material_bibliografico (id_mtb, abreviatura, descripcion_mtb, internet, imagen_defecto, estado, id_academico, id_usuario) VALUES (?,?,?,?,?,?,?,?)";

	public static final String UPDATE_BIBLIOGRAPHIC_MATERIAL = "UPDATE material_bibliografico SET abreviatura = ?, descripcion_mtb = ?, internet = ?, imagen_defecto = ?, estado = ? WHERE id_mtb = ?";

	public static final String DELETE_BIBLIOGRAPHIC_MATERIAL = "UPDATE material_bibliografico SET estado = 'I' WHERE id_mtb = ?";

	public static final String FIND_CALENDAR_BY_ID = "SELECT * FROM calendario WHERE id_calendario = ?";

	public static final String FIND_BY_CURRENT_MONTH = "SELECT * FROM calendario WHERE datepart(mm,fecha_gracia) = datepart(mm,getdate())";

	public static final String FIND_BY_MONTH = "SELECT * FROM calendario WHERE datepart(mm,fecha_gracia) = ?";

	public static final String FIND_ALL_CALENDAR = "SELECT * FROM calendario ORDER BY id_calendario";

	public static final String SAVE_CALENDAR = "INSERT INTO calendario (id_calendario, fecha_gracia, desc_fecha, fijo_festivo, id_academico, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";

	public static final String UPDATE_CALENDAR = "UPDATE calendario SET fecha_gracia = ?, desc_fecha = ?, fijo_festivo = ? WHERE id_calendario = ?";

	public static final String DELETE_CALENDAR = "DELETE FROM calendario WHERE id_calendario = ?";

	public static final String FIND_ALL_MARC = "SELECT * FROM campo_control";

	public static final String FIND_MARC_BY_ID = "SELECT * FROM campo_control WHERE marctag = ?";

	public static final String SAVE_MARC = "INSERT INTO campo_control (nombre, subindices, uso, marctag, etiqueta, ayuda_marctag, id_academico, id_usuario, etiqueta_web) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String UPDATE_MARC = "UPDATE campo_control SET nombre = ?, subindices = ?, uso = ?, etiqueta = ?, ayuda_marctag = ?, etiqueta_web = ? WHERE marctag = ?";

	public static final String DELETE_MARC = "DELETE FROM campo_control WHERE marctag = ?";

	public static final String FIND_ALL_PARAMETERS = "SELECT * FROM parametro WHERE estado_parametro = 'A' AND id_aplicacion = ?";

	public static final String FIND_PARAMETER_BY_ID = "SELECT * FROM parametro WHERE estado_parametro = 'A' AND id_parametro = ? AND id_aplicacion = ?";

	public static final String SAVE_PARAMETER = "INSERT INTO parametro (id_parametro, descripcion_par, valor, id_academico, id_usuario, id_aplicacion, estado_parametro) VALUES (?, ?, ?, ?, ?, ?, 'A')";

	public static final String UPDATE_PARAMETER = "UPDATE parametro SET descripcion_par = ?, valor = ?, estado_parametro = ? WHERE id_parametro = ? AND id_aplicacion = ?";

	public static final String DELETE_PARAMETER = "UPDATE parametro SET estado_parametro = 'I' WHERE estado_parametro = 'A' AND id_parametro = ? AND id_aplicacion = ?";

	public static final String FIND_ALL_RESTAURATION_TYPE = "SELECT * FROM tipo_restauracion";

	public static final String FIND_RESTAURATION_TYPE_BY_ID = "SELECT * FROM tipo_restauracion WHERE id_tipo_restauracion = ?";

	public static final String SAVE_RESTAURATION_TYPE = "INSERT INTO tipo_restauracion (id_tipo_restauracion, tipo_restauracion, id_academico, id_usuario) VALUES (?, ?, ?, ?)";

	public static final String UPDATE_RESTAURATION_TYPE = "UPDATE tipo_restauracion SET tipo_restauracion = ? WHERE id_tipo_restauracion = ?";

	public static final String DELETE_RESTAURATION_TYPE = "DELETE FROM tipo_restauracion WHERE id_tipo_restauracion = ?";

	public static final String FIND_ALL_TEMPLATES = "SELECT * FROM plantilla";

	public static final String FIND_ALL_TEMPLATES_BY_ID_MTB = "SELECT * FROM plantilla WHERE id_mtb = ?";

	public static final String FIND_TEMPLATE_BY_ID = "SELECT * FROM plantilla WHERE id_plantilla = ?";

	public static final String SAVE_TEMPLATE = "INSERT INTO plantilla (id_plantilla, id_mtb, plantilla, id_academico, id_usuario) VALUES (?, ?, ?, ?, ?)";

	public static final String UPDATE_TEMPLATE = "UPDATE plantilla SET id_mtb = ?, plantilla = ? WHERE id_plantilla = ?";

	public static final String DELETE_TEMPLATE = "DELETE FROM plantilla WHERE id_plantilla = ?";

}
