@echo off
REM =============================================================================
REM IFM Services — Pruebas con cURL (Windows CMD)
REM =============================================================================
REM Uso:
REM   cd postman
REM   ifm-services-curl.cmd
REM   ifm-services-curl.cmd 318
REM
REM Requiere curl.exe (incluido en Windows 10+)
REM =============================================================================

setlocal EnableDelayedExpansion
set "BASE_URL=http://localhost:8084/ifm"
set "FILTER=%~1"

if /I "%FILTER%"=="" goto :run_all
goto :run_filter

:run_all
set "FILTER="

:run_filter
echo BASE_URL=%BASE_URL%
echo.

if "%FILTER%"=="" goto :do_health
if "%FILTER%"=="HEALTH" goto :do_health
goto :skip_health
:do_health
echo ===== HEALTH - Servicio activo =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X GET "%BASE_URL%/test"
echo.
:skip_health

if "%FILTER%"=="" goto :do_310
if "%FILTER%"=="310" goto :do_310
goto :skip_310
:do_310
echo ===== 310 - Apertura de cuenta =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/cuentas/apertura" -H "Content-Type: application/json" -d "{\"idClienteRfc\":\"RFC123456789\",\"fechaAperturaCuenta\":\"20260602\",\"horaTrx\":\"103000\",\"tipoPersona\":\"F\",\"codigoProducto\":\"01\",\"codigoSubproducto\":\"001\",\"sucursalTransaccion\":\"00001\"}"
echo.
:skip_310

if "%FILTER%"=="" goto :do_345
if "%FILTER%"=="345" goto :do_345
goto :skip_345
:do_345
echo ===== 345 - Variables de cuentas =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/cuentas/cuentas" -H "Content-Type: application/json" -d "{\"codClienteRimOrigen\":\"12345\",\"numeroCuentaOrigen\":\"000123456789\",\"codigoTransaccion\":\"345\"}"
echo.
:skip_345

if "%FILTER%"=="" goto :do_347
if "%FILTER%"=="347" goto :do_347
goto :skip_347
:do_347
echo ===== 347 - Cuentas plazo fijo =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/cuentas/plazoFijo" -H "Content-Type: application/json" -d "{\"codClienteRimOrigen\":\"12345\",\"numeroCuentaOrigen\":\"000123456789\",\"codigoTransaccion\":\"347\"}"
echo.
:skip_347

if "%FILTER%"=="" goto :do_919
if "%FILTER%"=="919" goto :do_919
goto :skip_919
:do_919
echo ===== 919 - Solicitud de chequera =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/cuentas/solicitudChequera" -H "Content-Type: application/json" -d "{\"codClienteRimOrigen\":\"12345\",\"numeroCuentaOrigen\":\"000123456789\",\"tipoChequera\":\"01\",\"noChequeras\":1}"
echo.
:skip_919

if "%FILTER%"=="" goto :do_318
if "%FILTER%"=="318" goto :do_318
goto :skip_318
:do_318
echo ===== 318 - Variables novedades =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/novedades/novedades" -H "Content-Type: application/json" -d "{\"codClienteRimOrigen\":\"12345\",\"numeroCuentaOrigen\":\"000123456789\",\"codigoTransaccion\":\"318\",\"canalMedio\":\"WEB\",\"fechaTrx\":\"20260602\",\"horaTrx\":\"103000\",\"tipoNovedad\":\"01\"}"
echo.
:skip_318

if "%FILTER%"=="" goto :do_8630
if "%FILTER%"=="8630" goto :do_8630
goto :skip_8630
:do_8630
echo ===== 8630 - Novedades tarjetas =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/administrativo" -H "Content-Type: application/json" -d "{\"idCliente\":\"CLI001\",\"noTarjetaEncriptadoSha256\":\"abc123hash\",\"codigoDeTransaccion\":8630,\"fechaTrxAdq\":20260602,\"horaTrxAdq\":103000,\"idTerminal\":\"TERM001\",\"datoAnterior\":\"ACTIVA\",\"datoPosterior\":\"BLOQUEADA\",\"acfUsuario\":\"USUARIO01\"}"
echo.
:skip_8630

if "%FILTER%"=="" goto :do_582
if "%FILTER%"=="582" goto :do_582
goto :skip_582
:do_582
echo ===== 582 - Pago a proveedores =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/proveedores/pagoProveedores" -H "Content-Type: application/json" -d "{\"entidad\":\"0001\",\"codigoTerceraParte\":\"PROV001\",\"nombreBusinessDBA\":\"Proveedor Demo SA\",\"fechaPago\":\"2026-06-02\",\"horaPago\":\"10:30:00\",\"monedaPago\":\"USD\",\"montoPago\":1500.00,\"numeroFactura\":\"FAC-2026-001\",\"formaPago\":\"T\",\"usuario\":\"USUARIO01\",\"terminal\":\"192.168.1.10\"}"
echo.
:skip_582

if "%FILTER%"=="" goto :do_565
if "%FILTER%"=="565" goto :do_565
goto :skip_565
:do_565
echo ===== 565 - Maestro de empleados =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/empleados/empleados" -H "Content-Type: application/json" -d "{\"entidad\":\"0001\",\"codigoEmpleado\":\"EMP001\",\"primerNombreEmpleado\":\"Juan\",\"primerApellidoEmpleado\":\"Perez\",\"fechaContratacion\":\"20260101\"}"
echo.
:skip_565

if "%FILTER%"=="" goto :do_567
if "%FILTER%"=="567" goto :do_567
goto :skip_567
:do_567
echo ===== 567 - Nominas =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/nominas/nomina" -H "Content-Type: application/json" -d "{\"codigoEmpleado\":\"EMP001\",\"sueldoBase\":1500.00,\"bonificacion\":100.00}"
echo.
:skip_567

if "%FILTER%"=="" goto :do_915
if "%FILTER%"=="915" goto :do_915
goto :skip_915
:do_915
echo ===== 915 - Solicitud de credito =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/creditos/solicitud" -H "Content-Type: application/json" -d "{\"idCliente\":\"CLI001\",\"tipoDeSolicitud\":\"PERS\",\"montoSolicitado\":50000.00,\"monedaDeLaCuenta\":\"USD\",\"usuario\":\"USUARIO01\"}"
echo.
:skip_915

if "%FILTER%"=="" goto :do_917
if "%FILTER%"=="917" goto :do_917
goto :skip_917
:do_917
echo ===== 917 - Consultas buro =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X GET "%BASE_URL%/creditos/consultasBuro" -H "Content-Type: application/json" -d "{\"idCliente\":\"CLI001\",\"tipoDeIdDelCliente\":\"RFC\"}"
echo.
:skip_917

if "%FILTER%"=="" goto :do_640
if "%FILTER%"=="640" goto :do_640
goto :skip_640
:do_640
echo ===== 640 - Consulta maestro contable =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/contable/consultaMaestro" -H "Content-Type: application/json" -d "{\"idMaestro\":\"MAE001\",\"periodo\":\"202606\"}"
echo.
:skip_640

if "%FILTER%"=="" goto :do_620
if "%FILTER%"=="620" goto :do_620
goto :skip_620
:do_620
echo ===== 620 - Consulta cuentas contables =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/contable/consultaCuentas" -H "Content-Type: application/json" -d "{\"codigoCuenta\":\"110101\",\"periodo\":\"202606\"}"
echo.
:skip_620

if "%FILTER%"=="" goto :do_650
if "%FILTER%"=="650" goto :do_650
goto :skip_650
:do_650
echo ===== 650 - Consulta movimientos contables =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/contable/consultaMovimientos" -H "Content-Type: application/json" -d "{\"codigoCuenta\":\"110101\",\"fechaDesde\":\"20260601\",\"fechaHasta\":\"20260630\"}"
echo.
:skip_650

if "%FILTER%"=="" goto :do_920
if "%FILTER%"=="920" goto :do_920
goto :skip_920
:do_920
echo ===== 920 - Solicitud tarjeta debito =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/tarjetas/solicitudTarjetaDebito" -H "Content-Type: application/json" -d "{\"idCliente\":\"CLI001\",\"tipoCuenta\":\"AHORRO\",\"numeroCuenta\":\"000123456789\"}"
echo.
:skip_920

if "%FILTER%"=="" goto :do_921
if "%FILTER%"=="921" goto :do_921
goto :skip_921
:do_921
echo ===== 921 - Internet banking =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/internet-banking/solicitud" -H "Content-Type: application/json" -d "{\"idCliente\":\"CLI001\",\"tipoCuenta\":\"CORRIENTE\",\"correoElectronico\":\"cliente@ejemplo.com\"}"
echo.
:skip_921

if "%FILTER%"=="" goto :do_8765
if "%FILTER%"=="8765" goto :do_8765
goto :skip_8765
:do_8765
echo ===== 8765 - Reclamos =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/reclamos/reclamos" -H "Content-Type: application/json" -d "{\"codigoDeReclamo\":\"8765\",\"numeroDelReclamo\":\"REC001\",\"idDelCliente\":\"CLI001\",\"medioOCanalDelReclamo\":\"WEB\",\"montoDeLaTransaccion\":100.00}"
echo.
:skip_8765

if "%FILTER%"=="" goto :do_8620
if "%FILTER%"=="8620" goto :do_8620
goto :skip_8620
:do_8620
echo ===== 8620 - Debito/credito tarjeta =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/operaciones/debitocreditoTarjeta" -H "Content-Type: application/json" -d "{\"acfCodTrx\":8620,\"acfFechaTrx\":20260602,\"acfHoraTrx\":103000,\"acfIdCliente\":\"CLI001\",\"acfMontoEnMonedaLocal\":100.50,\"acfDebitoCredito\":\"DB\",\"acfUsuario\":\"USUARIO01\"}"
echo.
:skip_8620

if "%FILTER%"=="" goto :do_8625
if "%FILTER%"=="8625" goto :do_8625
goto :skip_8625
:do_8625
echo ===== 8625 - Debito/credito comercio =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X POST "%BASE_URL%/operaciones/debitocreditoComercio" -H "Content-Type: application/json" -d "{\"acfCodTrx\":8625,\"acfFechaTrx\":20260602,\"acfHoraTrx\":103000,\"acfIdCliente\":\"CLI001\",\"acfMontoEnMonedaLocal\":250.00,\"acfDebitoCredito\":\"CR\",\"acfUsuario\":\"USUARIO01\"}"
echo.
:skip_8625

if "%FILTER%"=="" goto :do_actuator
if "%FILTER%"=="ACTUATOR" goto :do_actuator
goto :skip_actuator
:do_actuator
echo ===== ACTUATOR - Circuit breakers =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X GET "%BASE_URL%/actuator/circuitbreakers"
echo.
echo ===== ACTUATOR - Health =====
curl.exe -sS -w "\nHTTP %%{http_code}\n" -X GET "%BASE_URL%/actuator/health"
echo.
:skip_actuator

echo Pruebas finalizadas.
endlocal
