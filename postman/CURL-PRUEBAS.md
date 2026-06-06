# cURL — Pruebas generales IFM Services

Base URL: `http://localhost:8084/ifm`

> Scripts ejecutables: `ifm-services-curl.sh` (Git Bash/WSL) · `ifm-services-curl.cmd` (Windows CMD)

---

## Salud

```bash
# HEALTH — Servicio activo
curl -sS -X GET "http://localhost:8084/ifm/test"
```

---

## Cuentas

```bash
# 310 — Apertura de cuenta
curl -sS -X POST "http://localhost:8084/ifm/cuentas/apertura" \
  -H "Content-Type: application/json" \
  -d '{"idClienteRfc":"RFC123456789","fechaAperturaCuenta":"20260602","horaTrx":"103000","tipoPersona":"F","codigoProducto":"01","codigoSubproducto":"001","sucursalTransaccion":"00001"}'

# 345 — Variables de cuentas
curl -sS -X POST "http://localhost:8084/ifm/cuentas/cuentas" \
  -H "Content-Type: application/json" \
  -d '{"codClienteRimOrigen":"12345","numeroCuentaOrigen":"000123456789","codigoTransaccion":"345"}'

# 347 — Cuentas plazo fijo
curl -sS -X POST "http://localhost:8084/ifm/cuentas/plazoFijo" \
  -H "Content-Type: application/json" \
  -d '{"codClienteRimOrigen":"12345","numeroCuentaOrigen":"000123456789","codigoTransaccion":"347"}'

# 919 — Solicitud de chequera
curl -sS -X POST "http://localhost:8084/ifm/cuentas/solicitudChequera" \
  -H "Content-Type: application/json" \
  -d '{"codClienteRimOrigen":"12345","numeroCuentaOrigen":"000123456789","tipoChequera":"01","noChequeras":1}'
```

---

## Novedades

```bash
# 318 — Variables novedades
curl -sS -X POST "http://localhost:8084/ifm/novedades/novedades" \
  -H "Content-Type: application/json" \
  -d '{"codClienteRimOrigen":"12345","numeroCuentaOrigen":"000123456789","codigoTransaccion":"318","canalMedio":"WEB","fechaTrx":"20260602","horaTrx":"103000","tipoNovedad":"01"}'
```

---

## Administrativo

```bash
# 8630 — Novedades tarjetas
curl -sS -X POST "http://localhost:8084/ifm/administrativo" \
  -H "Content-Type: application/json" \
  -d '{"idCliente":"CLI001","noTarjetaEncriptadoSha256":"abc123hash","codigoDeTransaccion":8630,"fechaTrxAdq":20260602,"horaTrxAdq":103000,"idTerminal":"TERM001","datoAnterior":"ACTIVA","datoPosterior":"BLOQUEADA","acfUsuario":"USUARIO01"}'
```

---

## Proveedores

```bash
# 582 — Pago a proveedores
curl -sS -X POST "http://localhost:8084/ifm/proveedores/pagoProveedores" \
  -H "Content-Type: application/json" \
  -d '{"entidad":"0001","codigoTerceraParte":"PROV001","nombreBusinessDBA":"Proveedor Demo SA","fechaPago":"2026-06-02","horaPago":"10:30:00","monedaPago":"USD","montoPago":1500.00,"numeroFactura":"FAC-2026-001","formaPago":"T","usuario":"USUARIO01","terminal":"192.168.1.10"}'
```

---

## Empleados · Nóminas

```bash
# 565 — Maestro de empleados
curl -sS -X POST "http://localhost:8084/ifm/empleados/empleados" \
  -H "Content-Type: application/json" \
  -d '{"entidad":"0001","codigoEmpleado":"EMP001","primerNombreEmpleado":"Juan","primerApellidoEmpleado":"Perez","fechaContratacion":"20260101"}'

# 567 — Nóminas
curl -sS -X POST "http://localhost:8084/ifm/nominas/nomina" \
  -H "Content-Type: application/json" \
  -d '{"codigoEmpleado":"EMP001","sueldoBase":1500.00,"bonificacion":100.00}'
```

---

## Créditos

```bash
# 915 — Solicitud de crédito
curl -sS -X POST "http://localhost:8084/ifm/creditos/solicitud" \
  -H "Content-Type: application/json" \
  -d '{"idCliente":"CLI001","tipoDeSolicitud":"PERS","montoSolicitado":50000.00,"monedaDeLaCuenta":"USD","usuario":"USUARIO01"}'

# 917 — Consultas buró (GET con body — como en el controlador)
curl -sS -X GET "http://localhost:8084/ifm/creditos/consultasBuro" \
  -H "Content-Type: application/json" \
  -d '{"idCliente":"CLI001","tipoDeIdDelCliente":"RFC"}'
```

---

## Contable

```bash
# 640 — Consulta maestro contable
curl -sS -X POST "http://localhost:8084/ifm/contable/consultaMaestro" \
  -H "Content-Type: application/json" \
  -d '{"idMaestro":"MAE001","periodo":"202606"}'

# 620 — Consulta cuentas contables
curl -sS -X POST "http://localhost:8084/ifm/contable/consultaCuentas" \
  -H "Content-Type: application/json" \
  -d '{"codigoCuenta":"110101","periodo":"202606"}'

# 650 — Consulta movimientos contables
curl -sS -X POST "http://localhost:8084/ifm/contable/consultaMovimientos" \
  -H "Content-Type: application/json" \
  -d '{"codigoCuenta":"110101","fechaDesde":"20260601","fechaHasta":"20260630"}'
```

---

## Tarjetas · Internet Banking · Reclamos

```bash
# 920 — Solicitud tarjeta débito
curl -sS -X POST "http://localhost:8084/ifm/tarjetas/solicitudTarjetaDebito" \
  -H "Content-Type: application/json" \
  -d '{"idCliente":"CLI001","tipoCuenta":"AHORRO","numeroCuenta":"000123456789"}'

# 921 — Solicitud internet banking
curl -sS -X POST "http://localhost:8084/ifm/internet-banking/solicitud" \
  -H "Content-Type: application/json" \
  -d '{"idCliente":"CLI001","tipoCuenta":"CORRIENTE","correoElectronico":"cliente@ejemplo.com"}'

# 8765 — Reclamos
curl -sS -X POST "http://localhost:8084/ifm/reclamos/reclamos" \
  -H "Content-Type: application/json" \
  -d '{"codigoDeReclamo":"8765","numeroDelReclamo":"REC001","idDelCliente":"CLI001","medioOCanalDelReclamo":"WEB","montoDeLaTransaccion":100.00}'
```

---

## Operaciones débito / crédito

```bash
# 8620 — Débito/crédito tarjeta
curl -sS -X POST "http://localhost:8084/ifm/operaciones/debitocreditoTarjeta" \
  -H "Content-Type: application/json" \
  -d '{"acfCodTrx":8620,"acfFechaTrx":20260602,"acfHoraTrx":103000,"acfIdCliente":"CLI001","acfMontoEnMonedaLocal":100.50,"acfDebitoCredito":"DB","acfUsuario":"USUARIO01"}'

# 8625 — Débito/crédito comercio
curl -sS -X POST "http://localhost:8084/ifm/operaciones/debitocreditoComercio" \
  -H "Content-Type: application/json" \
  -d '{"acfCodTrx":8625,"acfFechaTrx":20260602,"acfHoraTrx":103000,"acfIdCliente":"CLI001","acfMontoEnMonedaLocal":250.00,"acfDebitoCredito":"CR","acfUsuario":"USUARIO01"}'
```

---

## Actuator

```bash
curl -sS "http://localhost:8084/ifm/actuator/circuitbreakers"
curl -sS "http://localhost:8084/ifm/actuator/circuitbreakerevents"
curl -sS "http://localhost:8084/ifm/actuator/health"
```
