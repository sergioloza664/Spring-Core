# Spring-Core


1. # **Introducción**
   1.1 ## **Inversión de control**
- Principio de diseño (o patrón)
El objetivo es conseguir desacoplar
- objetos.
- Dejar que sea otro el que controle el flujo del
- programa (por ejemplo, un framework)
- Ejemplo:
  - Suscripción o manejo de eventos (.NET, Java, …)
  - Session Bean (EJB): ejbRemove, ejbPassivate, ejbActivate, ...
  - JUnit: setUp, tearDown, ...
  - **Inyección de dependencias: es solo una forma de inversión de control.**
- En el contenedor de inversión de control, los objetos se llaman beans.

1.2 ## **Inyección de dependencias**
Es una forma de inversión de control.

![](Aspose.Words.28dcbe56-3fdf-4297-8d5e-b8fcfb8cb939.001.png)

**
2. # **Instalación de spring tools**
En eclipse debemos instalar spring tolos en: **Help/Eclipse Marketplace**

![](Aspose.Words.28dcbe56-3fdf-4297-8d5e-b8fcfb8cb939.002.png)


3. # **Crear el xml para los beans**
En la **carpeta src/main/sources** damos clic derecho y vamos a **new/Other/Spring/Spring bean configuration file** y lo llamamos **beans.xml** 

![](Aspose.Words.28dcbe56-3fdf-4297-8d5e-b8fcfb8cb939.003.png)

4. # **Dependencias Maven**

<!-- Para usar Spring IOC container(inyección de dependencias)  -->
**
` `<dependency>
**
`  	`<groupId>**org.springframework**</groupId>
**
`    	`<artifactId>**spring-context**</artifactId>
**
`    	`<version>**5.0.8.RELEASE**</version>

</dependency>


5. # **Configurar beans a través de anotaciones**
Dentro del archivo**beans.xml** daremos clic a la **pestaña namespaces** y seleccionamos **context**

![](Aspose.Words.28dcbe56-3fdf-4297-8d5e-b8fcfb8cb939.004.png)

![](Aspose.Words.28dcbe56-3fdf-4297-8d5e-b8fcfb8cb939.005.png)

