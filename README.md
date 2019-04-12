Instrucciones:
----------------
Desarrollar pantallas para la aplicacion mybank

Desarrollar consumidores para las siguientes APIs:
---------------
 - Registro (sign-up)
 - Autenticacion (login)
 - Consulta de saldo (Get customer product)
 - Crear transaccion (Save Transaction)
 - Consulta de ultimos 5 movimientos (Get Last Transactions)

Entradas:
---------------
- Diagrama de base de datos: mybank-db.pdf
- Crear la base de datos en MySQL (mybank-db-v1.1.sql)
- La comunicacion es sobre REST/HTTPS
- El usuario y password de la base de datos debe ser root/root
- El API escucha en localhost:4443 (https)
- Describir todos los supuestos necesarios.
- Especificacion del API: MyBank WebService API Specification v1.0.pdf
- Archivo certificado SSL cliente: mybank-client.crt
- Ejecutar el servidor de la siguiente forma:
	java -jar mybank-demo-1.0.jar


Herramientas:
---------------
Android Studio / Objective-C / swift 
MySql 5.7
gradle (Android)
JDK 1.8
JaCoCo


Entregables:
---------------
- Codigo fuente de la solucion (Gradle Project)
- Aplicacion instalable (apk)
- Pruebas de unidad (JUnit)
- Cobertura de codigo minima: 50%.
- Enviar un video con la demostración de la aplicación funcionando en el emulador

Subir los entregables anteriores en la rama master creada previamente.

Criterios de evaluación:
-----------------------
1. Completitud de la prueba: 25%
2. Estructuración del proyecto y prácticas de desarrollo: 20%
3. Pruebas de unidad y cobertura: 15%
4. Cumplimiento: 20%
5. Conocimientos: 20%


Happy Coding!
