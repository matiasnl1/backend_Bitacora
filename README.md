# Bitácora Escolar — Backend y Aplicación Móvil (DSY1105)

Proyecto académico desarrollado para la asignatura **DSY1105 (Desarrollo de Aplicaciones Móviles)** en Duoc UC[cite: 3, 8], compuesto por una aplicación móvil Android en Kotlin/Jetpack Compose y un servicio backend en Java Spring Boot conectado a MySQL[cite: 2, 11].

## Integrantes y distribución del trabajo
- **Darío Silva:** Configuración inicial con MySQL, base del CRUD en el backend Spring Boot y manejo de respuestas HTTP (`201`, `204`, entre otras).
- **Matías:** Modificaciones y desarrollo del frontend en Android Studio (interfaz en Jetpack Compose, arquitectura MVVM, integración con Retrofit y pruebas unitarias)[cite: 2, 11].
- **Diego Norambuena:** Finalización del APK firmado (`.apk` y `.jks`) y cierre de los últimos detalles del proyecto.

## Arquitectura y estructura del proyecto

### Backend (`backend_Bitacora`)
- **Paquete base:** `cl.duoc.educacional`[cite: 16]
- **Puerto de ejecución:** `8080` (`http://localhost:8080`)
- **Componentes principales:**
    - `EducacionalApplication`: clase principal de Spring Boot[cite: 16].
    - `Registro`: entidad JPA persistida en base de datos[cite: 16].
    - `RegistroRepository`: repositorio con Spring Data JPA[cite: 16].
    - `RegistroController`: controlador REST expuesto bajo `/api/registros`[cite: 16].
- **Base de datos:** MySQL en `localhost:3306`, base `educacional` (`createDatabaseIfNotExist=true`, usuario `root`, contraseña vacía, `spring.jpa.hibernate.ddl-auto=update`)[cite: 16].

### Aplicación Android (`proyecto_semestral_dsy1105`)
- **Tecnologías:** Kotlin, Jetpack Compose, Material Design 3 y arquitectura MVVM (`Screen`, `ViewModel`, `UiState`, `Repository`, `Model`)[cite: 2, 11].
- **Red y persistencia:** Consumo del backend propio vía Retrofit (`http://10.0.2.2:8080/` en emulador), integración de API externa y persistencia local cuando corresponde[cite: 2, 4, 11].
- **Pruebas unitarias:** Implementadas en `src/test` con JUnit / MockK / Kotest[cite: 2, 11, 15].

## Endpoints y APIs utilizadas

### Endpoints propios del backend (`http://localhost:8080/api/registros`)
- `GET /api/registros` — Obtiene el listado de registros[cite: 16].
- `GET /api/registros/{id}` — Consulta un registro por su `id` (`200 OK` o `404 Not Found`)[cite: 16].
- Operaciones CRUD adicionales del backend (incluyendo respuestas como `201 Created` y `204 No Content`): `[Completar: Verificar y detallar rutas exactas POST/PUT/DELETE en RegistroController]`[cite: 2, 16]

### API externa (Retrofit)
- `[Completar: URL base, endpoints y propósito de la API externa consumida desde la app]`[cite: 2, 11]

## Pasos para ejecutar la solución

1. **Levantar MySQL (XAMPP):**
    - Inicia el servicio **MySQL** desde XAMPP en el puerto `3306`[cite: 16].
    - La base de datos `educacional` se crea automáticamente al iniciar si no existe (`usuario: root`, sin contraseña)[cite: 16].
2. **Ejecutar el backend (Spring Boot):**
    - Abre `backend_Bitacora` en IntelliJ IDEA y ejecuta `EducacionalApplication`, o desde consola con:
      ```cmd
      mvnw.cmd spring-boot:run
      ```
    - Verifica que el servidor inicie en el puerto `8080`.
3. **Ejecutar la aplicación Android:**
    - Abre `proyecto_semestral_dsy1105` en Android Studio[cite: 15].
    - Si el IDE pide seleccionar JVM para Gradle, utiliza **JVM 21**[cite: 14].
    - Ejecuta en un emulador Android (usando `http://10.0.2.2:8080/`) o dispositivo físico en la misma red[cite: 4].
4. **Ejecutar pruebas unitarias:**
    - Ejecuta los tests desde Android Studio (`src/test`) o por consola:
      ```cmd
      gradlew.bat test
      ```

## APK firmado y credenciales de demostración
- **APK firmado:** `[Completar: Nombre y ruta del archivo .apk en el repositorio]`[cite: 2, 11]
- **Keystore (`.jks`):** `[Completar: Nombre y ruta del archivo .jks de demostración]`[cite: 2, 11]
- **Claves de demostración académica:** `1234` y `123456` *(verificar cuál corresponde a Keystore password y Key password, además del alias del `.jks`)*[cite: 2, 11]
- **Evidencia y planificación:** `[Completar: Enlace a Trello y ubicación de la captura del APK firmado]`[cite: 2, 11]