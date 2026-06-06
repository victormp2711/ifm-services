package com.pyg.ifm.modules.empleados.model;


import lombok.Data;

@Data
public class EmpleadosRequest {

    // ========== Datos de la Entidad ========== 565
    private String entidad; // ABC - Entidad

    // ========== Datos del Empleado ==========
    private String codigoEmpleado; // Código de Empleado
    private String codigoClienteRelacionado; // Código de Cliente Relacionado a Empleado
    private String numeroIdentidad; // Numero de Identidad
    private String noSeguroSocial; // No. de Seguro Social
    private String primerNombreEmpleado; // Primer Nombre Empleado
    private String segundoNombreEmpleado; // Segundo Nombre de Empleado
    private String primerApellidoEmpleado; // Primer Apellido de Empleado
    private String segundoApellidoEmpleado; // Segundo Apellido de Empleado
    private String apellidoCasadaEmpleada; // Apellido de Casada de empleada
    private String fechaNacimientoEmpleado; // Fecha de Nacimiento Empleado
    private Integer genero; // Género 1-Masculino, 2-Femenino
    private String estadoCivilEmpleado; // Estado Civil Empleado
    private String fechaContratacion; // Fecha de Contratación
    private String codigoEmpresaGrupo; // Cód. Empresa del Grupo con la que Trabaja
    private String puestoCargoActual; // Puesto o Cargo Actual
    private String fechaInicioPuestoActual; // Fecha de Inicio con Puesto actual dentro de la Institución
    private String tipoHorarioAsignado; // Tipo de Horario Asignado
    private Integer lugarTrabajo; // Lugar de Trabajo 1-Oficina 2-Agencia 3-Sucursal
    private String puestoCargoAnterior; // Puesto o Cargo Anterior dentro de la Institución
    private String fechaInicioPuestoAnterior; // Fecha de Inicio con Puesto Anterior dentro de la Institución
    private String unidadOrganizativa; // Unidad Organizativa
    private String codigoEmpleadoJefeInmediato; // Código de Empleado de Jefe Inmediato

    // ========== Datos de Contacto ==========
    private String numeroTelefonoDirecto; // Numero de Teléfono Directo
    private String numeroCelular; // Numero de Celular
    private String direccionCorreoElectronicoInstitucion; // Dirección de Correo Electrónico Institución
    private String direccionDomicilio; // Dirección de Domicilio

    // ========== Datos Personales Adicionales ==========
    private Integer tipoVivienda; // Tipo de Vivienda 1-Propia 2-Alquilada 3-Otros
    private Integer tipoVehiculo; // Tipo de Vehículo 1-Ya pagado 2-Financiado
    private String fechaMatrimonio; // Fecha de Matrimonio
    private String nombreConyuge; // Nombre del Cónyuge
    private String codigoClienteConyuge; // Código de Cliente Cónyuge
    private Double ingresosAnualesConyuge; // Ingresos Anuales que aporta el Cónyuge
    private Integer numeroCargasFamiliares; // Numero de Cargas Familiares
    private Double montoPensionMatrimonioAnterior; // Monto Pago de Pensión Matrimonio Anterior

    // ========== Datos de Ingresos ==========
    private Double totalIngresosAnualesSalarioAnterior3; // Total de Ingresos Anuales x Salario Anterior 3
    private Double totalIngresosAnualesSalarioAnterior2; // Total de Ingresos Anuales x Salario Anterior 2
    private Double totalIngresosAnualesSalarioAnterior1; // Total de Ingresos Anuales x Salario Anterior 1
    private Double totalIngresosAnualesSalarioActuales; // Total de Ingresos anuales por Salario Actuales
    private Double sueldoMesEnero; // Sueldo del Mes de Enero
    private Double sueldoMesFebrero; // Sueldo del Mes de Febrero
    private Double sueldoMesMarzo; // Sueldo del Mes de Marzo
    private Double sueldoMesAbril; // Sueldo del Mes de Abril
    private Double sueldoMesMayo; // Sueldo del Mes de Mayo
    private Double sueldoMesJunio; // Sueldo del Mes de Junio
    private Double sueldoMesJulio; // Sueldo del Mes de Julio
    private Double sueldoMesAgosto; // Sueldo del Mes de Agosto
    private Double sueldoMesSeptiembre; // Sueldo del Mes de Septiembre
    private Double sueldoMesOctubre; // Sueldo del Mes de Octubre
    private Double sueldoMesNoviembre; // Sueldo del Mes de Noviembre
    private Double sueldoMesDiciembre; // Sueldo del Mes de Diciembre
    private Double totalIngresosAnuales; // Total de Ingresos Anuales
    private Double totalEfectivo; // Total Efectivo
    private Double totalPropiedadesActivos; // Total Propiedades y Activos
    private Double totalCuentasPorCobrar; // Total de Cuentas Por Cobrar

    // ========== Datos de Vehículo ==========
    private String marcaVehiculo; // Marca de Vehículo
    private String modeloVehiculo; // Modelo de Vehículo
    private Double precioEstimadoVehiculo; // Precio Estimado del vehículo
    private Double pagoMensualVivienda; // Pago Mensual de Vivienda

    // ========== Datos Laborales ==========
    private Integer noDiasVacacionesPendientes; // No. de Días de Vacaciones Pendientes a la fecha
    private Integer nivelSatisfaccionEmpresa; // Nivel de Satisfacción con la empresa
    private Double saldoPrestamosTarjetaCredito; // Saldo en prestamos y/o tarjeta de Crédito
    private Integer nivelRotacionEmpleo; // Nivel de Rotación de empleo de los últimos Años

    // ========== Datos Comerciales ==========
    private String tieneCuotaVentasCumplir; // Tiene una Cuota de ventas que Cumplir S/N
    private String ingresoDependeResultadosVentas; // Su ingreso depende de los resultados de Ventas S/N
    private String territorioClientesSectorPublico; // En su territorio hay Clientes del sector Público S/N

    // ========== Datos de Contacto Personal ==========
    private String direccionCorreoElectronicoPersonal; // Dirección de Correo Electrónico Personal

    // ========== Datos de Capacitación y Antecedentes ==========
    private String tomoEntrenamientoAntiCorrupcion; // Ya tomo el entrenamiento Anti - Corrupción S/N
    private String empleadoTieneAntecedentes; // Empleado Tiene Antecedentes casos sospechosos de corrupción
    private String empleadoTieneFamiliaresInstitucionesEstatales; // Empleado tiene familiares cercanos Instituciones Estatales

    // ========== Datos de Estado ==========
    private String estadoEmpleado; // ABC - Estado del Empleado A=Activo, I=Inactivo

    // ========== Datos de Auditoría ==========
    private String abcFecha; // ABC - Fecha
    private String abcHora; // ABC - Hora
    private String abcUsuario; // ABC - Usuario
    private String abcTerminal; // ABC - Terminal, Dirección IP o Nombre de Maquina
}

