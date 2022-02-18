Los objetivos de la práctica son:

Definir adecuadamente las clase que representa a lo que se ejcutará en el hilo. Programando adecuadamente la excepción de interrupción de su ejecución.
Modificar el método main(..) de la aplicación Java para una prueba correcta de las clases previamente definidas.
Crear los objetos que representan lo que deberá ejecutarse en los hilos.
Crear los objetos de los hilos de ejecución. Asociando correctamente lo que deberá ejercutarse.
La interrupción de los hilos cuando sea solicitado.
En el ejercicio se pretende simular la asignación de coches a las reservas pendientes por un gestor, a petición del hilo principal. El hilo principal esperára un tiempo y posteriormente interrumpirá el proceso de organización. Para la solución se tiene que utilizar los siguientes elementos ya programados:

Utils: Clase con las constantes y tipos enumerados necesarios para la solución del ejercicio. Hay que utilizar los elementos de esta clase de forma obligatoria para la resolución.
Coche: Identificará a un coche disponible por medio de un número de identificación. También tendrá asociado un TipoReserva que identifica la gama del coche.
Reserva: Identificará a una reserva de alquiler por medio de un número de identificación y contará con una propiedad que indique la gama de coche reservada y cuantos coches son necesarios. Solo se le podrán asignar coches que coincidan con la gama elegida y sin sobrepasar los coches solicitados.
El ejercicio consiste en completar la implementación de las siguientes clases:

Gestor: Representa un trabajador encargado de organizar las diferentes reservas. Tendrá las siguientes variables de instancia:
Un identificador.
Una serie de reservas para completar con coches.
Una lista de coches para asignar.
Una lista en común con el resto de gestores para almacenar los coches descartados.
Los pasos que debe realizar son:
Organizar los coches en reservas:
Procesar un coche: inserta el coche en una reserva, si no se puede insertar en ninguna se guarda en la lista común de descartados. El tipo de distribución se mantiene, se intentará asignar coches de manera equitativa.
Se simula el tiempo de trabajo de entre 2 a 5 segundos, ambos incluidos
El coche se considera procesado se haya podido insertar o no, excepto en el caso de que se interrumpa, los no procesados por falta de tiempo no cuentan como procesados ni se guardan en la lista de descartados.
Una vez interrumpido el proceso se seguirán procesando solo aquellos coches de la gama PREMIUM, el resto se ignorará.
A la finalización del trabajo, o interrupción, se debe presentar el trabajo realizado por el gestor, debe incluir como mínimo el porcentaje de coches procesados, la información de las reservas y debe quedar claro si el proceso ha sido cancelado/interrumpido. Las salidas por consola de los diferentes procesos no deben intercalarse.
HiloPrincipal: Realizará los siguientes pasos:
Crear una estructura única para los coches que no se han podido asignar a ningún plan de estudios.
Crear 5 gestores:
Asignar a cada gestor 12 reservas, entre 10 y 25 coches y la estructura común de descartados.
Asociar un objeto Thread a cada gestor para su ejecución.
Ejecutar los hilos.
Suspender el hilo principal durante 30 segundos.
Pasados los 30 segundos, solicitar la interrupción de todos los trabajos.
Esperar a que todos los procesos terminen.
Imprimir los datos de los coches descartados.