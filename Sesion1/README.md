En una empresa de alquiler de coches se tienen una serie de reservas, pero a cada reserva solo  le pueden asignar coches que coincidan con lo pedido, coches de tipo básico, superior o premium.
Para la realización del ejercicio propuesto se deben crear las siguientes clases:


Coche: Identificará a un coche disponible por medio de un número de identificación. También tendrá asociado un TipoReserva que identifica la gama del coche. Se tiene que definir el constructor, los métodos de acceso y el método toString().

Reserva: Identificará a una reserva de alquiler por medio de un número de identificación y contará con una propiedad que indique la gama de coche reservada y cuantos coches son necesarios. Solo se le podrán asignar coches que coincidan con la gama elegida y sin sobrepasar los coches solicitados.

Hay que definir el constructor y los métodos de acceso correspondientes.
Definir el método toString() para mostrar los datos de la reserva y los coches ya asignados.



Hilo Principal:

Generar una lista de 10 reservas con un tipo de reserva aleatorio y con un valor aleatorio de entre 1 y 3 coches solicitados.
Generar 20 coches:

Generar un valor de construcción aleatorio entre 0 y 100.
Seleccionar la gama del coche correspondiente con el valor de construcción generado.


Asignar cada coche a una de las reservas que acepte la gama del coche sin exceder el número de coches solicitados. Intentando repartir los coches por todas las reservas de forma equitativa.
Presentar las reservas de la empresa de alquiler.