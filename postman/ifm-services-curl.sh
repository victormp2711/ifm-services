#!/usr/bin/env bash
# =============================================================================
# IFM Services — Pruebas con cURL
# =============================================================================
# Uso:
#   export BASE_URL=http://localhost:8084/ifm   # opcional
#   bash postman/ifm-services-curl.sh           # ejecuta todas las pruebas
#   bash postman/ifm-services-curl.sh 318      # solo el código indicado
#
# Requisitos: curl (Git Bash, WSL, Linux, macOS, o curl.exe en Windows)
# Opcional:   jq  (formatea JSON de respuesta)
# =============================================================================

set -u

BASE_URL="${BASE_URL:-http://localhost:8084/ifm}"
FILTER="${1:-}"

pretty() {
  if command -v jq >/dev/null 2>&1; then
    jq .
  else
    cat
  fi
}

run() {
  local code="$1"
  local title="$2"
  if [[ -n "$FILTER" && "$FILTER" != "$code" ]]; then
    return 0
  fi
  echo ""
  echo "========================================================================"
  echo "  ${code} — ${title}"
  echo "========================================================================"
  shift 2
  # shellcheck disable=SC2068
  curl -sS -w "\n\n--- HTTP %{http_code} ---\n" "$@" | pretty
}

# -----------------------------------------------------------------------------
# Salud
# -----------------------------------------------------------------------------

run "HEALTH" "Servicio activo" \
  -X GET "${BASE_URL}/test"

# -----------------------------------------------------------------------------
# Cuentas
# -----------------------------------------------------------------------------

run "310" "Apertura de cuenta" \
  -X POST "${BASE_URL}/cuentas/apertura" \
  -H "Content-Type: application/json" \
  -d '{
    "idClienteRfc": "RFC123456789",
    "fechaAperturaCuenta": "20260602",
    "horaTrx": "103000",
    "tipoPersona": "F",
    "codigoProducto": "01",
    "codigoSubproducto": "001",
    "sucursalTransaccion": "00001"
  }'

run "345" "Variables de cuentas" \
  -X POST "${BASE_URL}/cuentas/cuentas" \
  -H "Content-Type: application/json" \
  -d '{
    "codClienteRimOrigen": "12345",
    "numeroCuentaOrigen": "000123456789",
    "codigoTransaccion": "345"
  }'

run "347" "Cuentas plazo fijo" \
  -X POST "${BASE_URL}/cuentas/plazoFijo" \
  -H "Content-Type: application/json" \
  -d '{
    "codClienteRimOrigen": "12345",
    "numeroCuentaOrigen": "000123456789",
    "codigoTransaccion": "347"
  }'

run "919" "Solicitud de chequera" \
  -X POST "${BASE_URL}/cuentas/solicitudChequera" \
  -H "Content-Type: application/json" \
  -d '{
    "codClienteRimOrigen": "12345",
    "numeroCuentaOrigen": "000123456789",
    "tipoChequera": "01",
    "noChequeras": 1
  }'

# -----------------------------------------------------------------------------
# Novedades
# -----------------------------------------------------------------------------

run "318" "Variables novedades" \
  -X POST "${BASE_URL}/novedades/novedades" \
  -H "Content-Type: application/json" \
  -d '{
    "codClienteRimOrigen": "12345",
    "numeroCuentaOrigen": "000123456789",
    "codigoTransaccion": "318",
    "canalMedio": "WEB",
    "fechaTrx": "20260602",
    "horaTrx": "103000",
    "tipoNovedad": "01"
  }'

# -----------------------------------------------------------------------------
# Administrativo
# -----------------------------------------------------------------------------

run "8630" "Novedades tarjetas" \
  -X POST "${BASE_URL}/administrativo" \
  -H "Content-Type: application/json" \
  -d '{
    "idCliente": "CLI001",
    "noTarjetaEncriptadoSha256": "abc123hash",
    "codigoDeTransaccion": 8630,
    "fechaTrxAdq": 20260602,
    "horaTrxAdq": 103000,
    "idTerminal": "TERM001",
    "datoAnterior": "ACTIVA",
    "datoPosterior": "BLOQUEADA",
    "acfUsuario": "USUARIO01"
  }'

# -----------------------------------------------------------------------------
# Proveedores
# -----------------------------------------------------------------------------

run "582" "Pago a proveedores" \
  -X POST "${BASE_URL}/proveedores/pagoProveedores" \
  -H "Content-Type: application/json" \
  -d '{
    "entidad": "0001",
    "codigoTerceraParte": "PROV001",
    "nombreBusinessDBA": "Proveedor Demo SA",
    "fechaPago": "2026-06-02",
    "horaPago": "10:30:00",
    "monedaPago": "USD",
    "montoPago": 1500.00,
    "numeroFactura": "FAC-2026-001",
    "formaPago": "T",
    "usuario": "USUARIO01",
    "terminal": "192.168.1.10"
  }'

# -----------------------------------------------------------------------------
# Empleados
# -----------------------------------------------------------------------------

run "565" "Maestro de empleados" \
  -X POST "${BASE_URL}/empleados/empleados" \
  -H "Content-Type: application/json" \
  -d '{
    "entidad": "0001",
    "codigoEmpleado": "EMP001",
    "primerNombreEmpleado": "Juan",
    "primerApellidoEmpleado": "Perez",
    "fechaContratacion": "20260101"
  }'

# -----------------------------------------------------------------------------
# Nóminas
# -----------------------------------------------------------------------------

run "567" "Nóminas" \
  -X POST "${BASE_URL}/nominas/nomina" \
  -H "Content-Type: application/json" \
  -d '{
    "codigoEmpleado": "EMP001",
    "sueldoBase": 1500.00,
    "bonificacion": 100.00
  }'

# -----------------------------------------------------------------------------
# Créditos
# -----------------------------------------------------------------------------

run "915" "Solicitud de crédito" \
  -X POST "${BASE_URL}/creditos/solicitud" \
  -H "Content-Type: application/json" \
  -d '{
    "idCliente": "CLI001",
    "tipoDeSolicitud": "PERS",
    "montoSolicitado": 50000.00,
    "monedaDeLaCuenta": "USD",
    "usuario": "USUARIO01"
  }'

run "917" "Consultas buró de crédito" \
  -X GET "${BASE_URL}/creditos/consultasBuro" \
  -H "Content-Type: application/json" \
  -d '{
    "idCliente": "CLI001",
    "tipoDeIdDelCliente": "RFC"
  }'

# -----------------------------------------------------------------------------
# Contable
# -----------------------------------------------------------------------------

run "640" "Consulta maestro contable" \
  -X POST "${BASE_URL}/contable/consultaMaestro" \
  -H "Content-Type: application/json" \
  -d '{
    "idMaestro": "MAE001",
    "periodo": "202606"
  }'

run "620" "Consulta cuentas contables" \
  -X POST "${BASE_URL}/contable/consultaCuentas" \
  -H "Content-Type: application/json" \
  -d '{
    "codigoCuenta": "110101",
    "periodo": "202606"
  }'

run "650" "Consulta movimientos contables" \
  -X POST "${BASE_URL}/contable/consultaMovimientos" \
  -H "Content-Type: application/json" \
  -d '{
    "codigoCuenta": "110101",
    "fechaDesde": "20260601",
    "fechaHasta": "20260630"
  }'

# -----------------------------------------------------------------------------
# Tarjetas
# -----------------------------------------------------------------------------

run "920" "Solicitud tarjeta débito" \
  -X POST "${BASE_URL}/tarjetas/solicitudTarjetaDebito" \
  -H "Content-Type: application/json" \
  -d '{
    "idCliente": "CLI001",
    "tipoCuenta": "AHORRO",
    "numeroCuenta": "000123456789"
  }'

# -----------------------------------------------------------------------------
# Internet Banking
# -----------------------------------------------------------------------------

run "921" "Solicitud acceso internet banking" \
  -X POST "${BASE_URL}/internet-banking/solicitud" \
  -H "Content-Type: application/json" \
  -d '{
    "idCliente": "CLI001",
    "tipoCuenta": "CORRIENTE",
    "correoElectronico": "cliente@ejemplo.com"
  }'

# -----------------------------------------------------------------------------
# Reclamos
# -----------------------------------------------------------------------------

run "8765" "Reclamos" \
  -X POST "${BASE_URL}/reclamos/reclamos" \
  -H "Content-Type: application/json" \
  -d '{
    "codigoDeReclamo": "8765",
    "numeroDelReclamo": "REC001",
    "idDelCliente": "CLI001",
    "medioOCanalDelReclamo": "WEB",
    "montoDeLaTransaccion": 100.00
  }'

# -----------------------------------------------------------------------------
# Operaciones débito / crédito
# -----------------------------------------------------------------------------

run "8620" "Débito/crédito tarjeta" \
  -X POST "${BASE_URL}/operaciones/debitocreditoTarjeta" \
  -H "Content-Type: application/json" \
  -d '{
    "acfCodTrx": 8620,
    "acfFechaTrx": 20260602,
    "acfHoraTrx": 103000,
    "acfIdCliente": "CLI001",
    "acfMontoEnMonedaLocal": 100.50,
    "acfDebitoCredito": "DB",
    "acfUsuario": "USUARIO01"
  }'

run "8625" "Débito/crédito comercio" \
  -X POST "${BASE_URL}/operaciones/debitocreditoComercio" \
  -H "Content-Type: application/json" \
  -d '{
    "acfCodTrx": 8625,
    "acfFechaTrx": 20260602,
    "acfHoraTrx": 103000,
    "acfIdCliente": "CLI001",
    "acfMontoEnMonedaLocal": 250.00,
    "acfDebitoCredito": "CR",
    "acfUsuario": "USUARIO01"
  }'

# -----------------------------------------------------------------------------
# Actuator (monitoreo)
# -----------------------------------------------------------------------------

run "ACTUATOR-CB" "Circuit breakers — estado" \
  -X GET "${BASE_URL}/actuator/circuitbreakers"

run "ACTUATOR-CB-EVENTS" "Circuit breakers — eventos" \
  -X GET "${BASE_URL}/actuator/circuitbreakerevents"

run "ACTUATOR-HEALTH" "Health" \
  -X GET "${BASE_URL}/actuator/health"

echo ""
echo "Pruebas finalizadas. BASE_URL=${BASE_URL}"
