
# Reto Técnico 
## Training Leagues - Naves Espaciales - Sofka

Dada la siguiente lectura:
🔗 [Ley de Barrow](https://moaramore.com/2016/05/14/clasificacion-de-las-naves-espaciales).

Se realizó la extracción de atributos genéricos e interfaces, se crearon dos comportamientos abstractos por nave, se creó sobrecarga 
y sobre escritura de métodos, se creó una clase principal (clase padre) contiene la información de las naves básica espaciales:
- Ship - Nave.
Una clase tipo *interface*:
- Objetive - Con un objetivo.
Y 3 clases hijas que extienden de la clase padre:
- Shuttle - Nave tipo Lanzadera.
- UnManned - Nave No Tripulada.
- Manned - Nave Tripulada.

El programa tiene una ejecución infinita hasta que se decida terminarlo. Se creó un inventario con al menos 9 naves espaciales.
El sistema tiene un método para visualizar (buscar) las naves espaciales con sus diferentes atributos.

El Diagrama Entidad Relación es el siguiente:
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/der.png?raw=true)


EL proyecto sigue el patrón MVC (Modelo, vista y controlador).

![MVC](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/mvc.JPG?raw=true)

El sistema se divide en 3 formularios (Uno por cada tipo de nave espacial).

- # Nave Tipo Lanzadera.
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/shuttle-form.JPG?raw=true)

- # Nave No Tripulada.
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/Unmanned.JPG?raw=true)

- # Nave Tripulada.
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/Manned.JPG?raw=true)

Los 3 formularios cuentan con las operaciones básicas de un CRUD (Create, Read, Update, Delete).


El código cuenta con un paquete base que inicializa a la vista y ésta a su ves llama al controlador para comunicarse 
con el resto de componentes. 
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/cod-base.JPG?raw=true)

Conexión a la DB:
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/cod-conexion.JPG?raw=true)

La vista:
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/cod-view.JPG?raw=true)

La clase SHIP (Nave):
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/cod-ship.JPG?raw=true)

La *interface* Objetive:
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/cod-objetive.JPG?raw=true)

La clase de Nave Tipo Lanzadera:
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/cod-shuttle.JPG?raw=true)

La clase de Nave No Tripulada:
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/cod-unmanned.JPG?raw=true)

La clase de Nave Tripulada:
![](https://github.com/ksamueloz/reto-sofka/blob/main/src/sofka/view/assets/cod-manned.JPG?raw=true)
