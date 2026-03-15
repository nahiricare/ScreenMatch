🎬 ScreenMatch - Buscador de Películas

ScreenMatch es una aplicación robusta desarrollada en Java que permite buscar información de películas y series en tiempo real, gestionar colecciones personalizadas y almacenar los resultados de forma permanente en archivos JSON.

Este proyecto forma parte de mi especialización en Backend con Java, integrando conceptos avanzados de programación orientada a objetos, consumo de APIs y manejo de archivos.

🚀 Funcionalidades Principales

Consumo de API Real: Conexión con la API de OMDb para obtener datos actualizados de títulos.

Buscador Interactivo: Bucle de búsqueda dinámico que permite al usuario realizar múltiples consultas hasta decidir salir.

Manejo de Errores Profesional: Implementación de bloques try-catch y Excepciones Personalizadas para gestionar errores de conversión y datos nulos (ej. duraciones "N/A").

Persistencia de Datos: Exportación automática de la lista de búsquedas a un archivo físico peliculas.json utilizando la librería GSON.

Serialización Refinada: Uso de anotaciones @Expose para generar archivos JSON limpios, guardando solo la información relevante (Nombre, Año, Duración).

🛠️ Tecnologías y Herramientas

Lenguaje: Java 25 (LTS)

Librerías Externas: GSON (para manipulación de JSON).

API: OMDb API.

Herramientas: HTTP Client para peticiones asíncronas, Java IO para escritura de archivos.

📚 Conceptos Técnicos Aplicados

1. Programación Orientada a Objetos
Herencia y Polimorfismo: Estructura de clases para Películas y Series.

Records: Uso de TituloOmdb para un mapeo eficiente de los datos de la API (DTO - Data Transfer Object).

Interfaces: Implementación de Comparable para ordenar listas alfabéticamente.

2. Manejo de Excepciones
Creación de excepciones personalizadas para validar reglas de negocio.

Uso de throws y delegación de errores hacia la JVM cuando es necesario.

3. Persistencia y JSON
Configuración de GsonBuilder con políticas de nombres (FieldNamingPolicy.UPPER_CAMEL_CASE).

Implementación de Serialización selectiva para optimizar el tamaño de los archivos.

▶️ Cómo ejecutar el proyecto

Clonar el repositorio:

Bash
git clone https://github.com/nahiricare/ScreenMatch.git
Importar el proyecto en IntelliJ IDEA (o tu IDE preferido).

Asegurarte de tener configurada la librería GSON en las dependencias del proyecto.

Ejecutar la clase PrincipalConBusqueda.

Ingresa los nombres de tus películas favoritas y, al finalizar, escribe "salir" para generar tu archivo JSON.

🧠 Próximos pasos

[ ] Deserialización: Implementar la lectura del archivo JSON al iniciar la aplicación.

[ ] Interfaz Gráfica: Evolucionar la consola a una interfaz visual básica.

[ ] Filtros Avanzados: Clasificar títulos por género o calificación directamente desde la lista guardada.

Proyecto desarrollado por Nahir Jasmin Icare en el marco del programa Oracle Next Education (ONE).
