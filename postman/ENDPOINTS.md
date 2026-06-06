# IFM Services — Catálogo de endpoints

Base URL local: `http://localhost:8084/ifm`

| Código | Método | Ruta | Descripción |
|--------|--------|------|-------------|
| — | GET | `/test` | Health — servicio activo |
| **310** | POST | `/cuentas/apertura` | Apertura de cuenta |
| **345** | POST | `/cuentas/cuentas` | Variables de cuentas |
| **347** | POST | `/cuentas/plazoFijo` | Cuentas plazo fijo |
| **919** | POST | `/cuentas/solicitudChequera` | Solicitud de chequera |
| **318** | POST | `/novedades/novedades` | Variables novedades |
| **8630** | POST | `/administrativo` | Novedades tarjetas |
| **582** | POST | `/proveedores/pagoProveedores` | Pago a proveedores |
| **565** | POST | `/empleados/empleados` | Maestro de empleados |
| **567** | POST | `/nominas/nomina` | Nóminas |
| **915** | POST | `/creditos/solicitud` | Solicitud de crédito |
| **917** | GET | `/creditos/consultasBuro` | Consultas buró |
| **640** | POST | `/contable/consultaMaestro` | Consulta maestro contable |
| **620** | POST | `/contable/consultaCuentas` | Consulta cuentas contables |
| **650** | POST | `/contable/consultaMovimientos` | Consulta movimientos contables |
| **920** | POST | `/tarjetas/solicitudTarjetaDebito` | Solicitud tarjeta débito |
| **921** | POST | `/internet-banking/solicitud` | Solicitud internet banking |
| **8765** | POST | `/reclamos/reclamos` | Reclamos |
| **8620** | POST | `/operaciones/debitocreditoTarjeta` | Débito/crédito tarjeta |
| **8625** | POST | `/operaciones/debitocreditoComercio` | Débito/crédito comercio |

## Pruebas con cURL

| Archivo | Descripción |
|---------|-------------|
| `CURL-PRUEBAS.md` | Comandos curl listos para copiar y pegar |
| `ifm-services-curl.sh` | Script bash — ejecuta todas o una por código (`bash ifm-services-curl.sh 318`) |
| `ifm-services-curl.cmd` | Script Windows CMD — `ifm-services-curl.cmd 318` |

## Cómo importar en Postman

1. Abrir Postman → **Import**
2. Seleccionar `IFM-Services.postman_collection.json`
3. Importar `IFM-Services.postman_environment.json`
4. Activar el entorno **IFM Local**
5. Ejecutar requests (carpetas numeradas por módulo)

## Pruebas en VS Code / IntelliJ

Abrir `ifm-services.http` con la extensión **REST Client** (VS Code) o el cliente HTTP de IntelliJ.

## Swagger

`http://localhost:8084/ifm/swagger-ui.html`
