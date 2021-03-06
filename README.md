# Desafio6
Base de datos y calendario

Descripción
En este desafío programaremos una aplicación que nos permite almacenar tareas en
nuestro dispositivo. Estas tareas se pueden agregar, editar y borrar, se muestran en una lista
simple, un elemento de esa lista se puede editar presionando sobre la tarea. Las tareas se
eliminan todas al mismo tiempo al presionar eliminar todas en el menú. El usuario puede
agregar tareas presionando agregar tarea en el menú superior. La aplicación debe utilizar
Room para persistir las tareas entre corridas de la aplicación. La edición de tareas es sólo
cambiar el texto de las mismas. Si siguió la lectura de la unidad, este desafío no debería ser
un problema.

HINT
La aplicación base solo es usada como referencia para los layout

Requerimientos
Para completar este desafío, Ud. recibirá un proyecto base que contiene toda la parte gráfica
y las clases necesarias para funcionar. La aplicación contiene una clase MainActivity, que es
la clase donde se ejecutan todos los métodos importantes de la aplicación. Ud deberá
completar lo siguiente:
1. Debe agregar todas las dependencias y configuraciones necesarias para integrar
Room en el proyecto.
a. Agregar dependencias y configuraciones a el archivo gradle correspondiente.
b. Crear las clases necesarias para inicializar la base de datos.
c. Agregar configuración al Manifest.
2. Crear todos los componentes de Room para persistir la lista y poder interactuar con
los datos guardados.
a. La lista sólo muestra texto, no sobre complique el modelamiento de datos.
Recuerde implementar todos los componentes de Room, esto entrega.
3. Completar los siguientes métodos y mostrar que la aplicación persiste los datos
entre diferentes corridas de la misma.
a. Crear las variables en la clase MainActivity, inicializar dichas variables donde
corresponde.
b. Completar el método para editar o actualizar una tarea, método updateEntity.
completar el método para agregar una tarea, método addTask, utilizar estos
métodos donde corresponda.
c. Completar los métodos: para convertir entre un entity y la clase que mapea la
data en pantalla createEntityListFromDatabase. El método que crea una
entidad a partir de texto, método createEntity. Completar el método que borra
todas las tareas de la base de datos.
d. La aplicación debe ejecutarse sin problemas y persistir los datos entre
diferentes corridas de la misma.

Examine bien el código, hay varios tips e instrucciones en los comentarios del código base.
Esto completa el desafío principal. Si después de completar el desafío, queda tiempo, se
pide realizar los siguientes puntos extras:
● Quiero agregar la fecha en que es creada la tarea, ¿Qué debo agregar a mi
implementación para hacer funcionar esta nueva propiedad agregada a nuestra base
de datos?
○ Crear cambios necesarios en el componente que representa las tareas.
○ Crear la clase necesaria para actualizar la base de datos.
○ Crear la clase necesaria para resolver el problema de almacenar este nuevo
campo en la base de datos.
Esta parte del desafío es opcional y no otorga puntaje adicional, se recomienda hacerla como
ejercicio.
