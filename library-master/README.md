# Biblioteca Dr. Nectario Andrade Labarca

El microservicio de Biblioteca tiene como propósito permitir que los usuarios realicen las siguientes actividades:  

1. Confuguración de los parámetros de biblioteca tales como: días de préstamos externo, valor de la multa, días feriados entre otros.
2. Definición de las etiquetas del formato Marc 21 y como se aplican a los diferentes tipos de material bibliográfico.
3. Catalogación de libros, trabajos de grado, tesis, gacetas oficiales, articulos de revistas, videos, ponencias entre otros.
4. Préstamo de libros para estudiantes y docentes.
5. Devolución de libros.
6. Reporte de estadisticas de préstamos.
7. Reserva de aulas.

# Exposición del microservicio

El microservicio está expuesto bajo la siguiente dirección: https://biblioteca.urbe.edu/api

# Preparación del Ambiente de Desarrollo

El repositorio debe ser clonado via SSH o HTTPS a la máquina local del desarrollador desde el servidor de Gitlab de la universidad. El archivo POM se encargará de descargar las dependencias del proyecto vía internet o a través del servidor de artefactos interno. El IDE utilizado para desarrollar el microservicio es IntelliJ IDEA Ultimate el cual requiere de una licencia. Dicha licencia se obtiene a través de un convenio estudiantil internacional en donde las universidades haciendo uso de una dirección de correo electrónico [*.edu] pueden tener acceso a dichos productos por un lapso no mayor a cuatro años.
También puede ser utilizado el IDE NetBeans 11 junto al pluging para desarrollar aplicaciones de tipo Spring Boot. A continuación los enlaces de interés:  

https://netbeans.apache.org/  
http://plugins.netbeans.org/plugin/67888/nb-springboot  

Para ejecutar aplicaciones Spring Boot desde NetBeans debe incorporar al proyecto el archivo nbactions.xml el cual contiene instrucciones de inicio de aplicación. Ejemplo: https://gitlab.urbe.edu/snippets/4

# Reporte de Errores

Para reportar errores correspondientes a éste microservicio debe dirigirse al servidor Gitlab y crear un caso, documentando los pasos necesarios para reproducir el error.

# Integración y Despliegue Continuo (CI+CD)

Este repositorio hace uso del mecanismo de integración y despliegue continuo ofrecido por el servidor Gitlab por lo que cualquier fusión exitosa que se realice sobre la rama Master será puesta en el ambiente de producción de forma automática. Favor coordinar con el Network Operation Center (NOC) para todo lo relacionado con ésta actividad.

# Imágen Docker

Este microservicio se encuentra en ejecución dentro de un cluster de Docker Swarm. Para mayor información póngase en contacto con el personal del NOC.

# Documentación

REST Docs >> https://readthedocs.urbe.edu/biblioteca/restdocs/index.html  
Javadocs  >> https://readthedocs.urbe.edu/biblioteca/javadocs/index.html   

# Frontend

El cliente que consume este microservicio se encuentra en la siguiente dirección: https://gitlab.urbe.edu/angular/urbe-biblioteca-material
