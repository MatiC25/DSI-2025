### Cambio de Estado 
- Modelé la entidad cambio de estado como una entidad separada para 
llevar la trazabilidad de los cambios en el estado de las donaciones, permitiendo un historial detallado y facilitando auditorías futuras (Mejora de la Trazabilidad y Auditoría).

### Estado
- Utilicé un Enumerado para el estado de la donación (Entregada, Pendiente, En deposito) para garantizar la Integridad Referencial y evitar errores de tipeo (favoreciendo la Robustez), dado que es un conjunto cerrado de valores que no requiere comportamiento complejo/adicional

### Categoría
- Modelé a Categoría como una Entidad/Clase y no como un String o Enum 
permitiendo así encapsular la lógica y atributos relacionados a la categoría dentro de su propia clase, favoreciendo la Cohesión (respondiendo al principio solid de Responsabilidad Única). Por otro lado, estaríamos
permitiendo la Extensibilidad futura (agregar nuevos atributos o comportamientos a la categoría sin afectar otras partes del sistema o 
agregar nuevos tipos de categorías sin tener que modificar el código).

- Modelé a la categoría como una interfaz para permitir la implementación de diferentes tipos de categorías en el futuro, favoreciendo la Extensibilidad (y,así , el Principio de Abierto/Cerrado permitiendo agregar nuevas categorías sin modificar las existentes). Además esto me permite definir para cada uno de ellas sus propios atributos y comportamientos específicos, mejorando la Cohesión (y así respondiendo al principio solid de Responsabilidad Única).


### Registrador
- Decidí modelar a la entidad registrador apoyandome en el principio de 
Responsabilidad Única, ya que esta entidad se encarga exclusivamente de gestionar la información relacionada con los usuarios que registran las donaciones, lo que mejora la Cohesión al mantener sus responsabilidades claramente definidas y separadas de otras entidades. Además evito la orquestación de casos de usos en las propias entidades de Donante y Beneficiario.

### Interfaz Adapter 
- En esta entidad implementé el patrón Adapter para permitir la integración con sistemas externos de manera flexible y desacoplada, facilitando la Extensibilidad del sistema al permitir agregar nuevas integraciones sin modificar el código existente (respondiendo al principio solid de Abierto/Cerrado). Además, esto mejora la Mantenibilidad al aislar las dependencias externas y permitir cambios en las integraciones sin afectar la lógica interna del sistema. Por último, una de las ventajas más importantes de tener un adapter contra una entidad externa es que permite testear esa funcionalidad de manera aislada mediante mocks sin la necesidad de consumir al sistema externa (dependiendo de este) y además consumiendo potencialmente menos recursos (ya que consumir un sistema externo puede ser costoso en términos de tiempo y recursos).

### Interfaz Algoritmo 
- Decido implementar la interfaz Algoritmo para definir un contrato común para las diferentes estrategias de asignación de donaciones que pueden haber. En este caso estoy implementando el patrón Strategy ya que existen múltiples formas de realizar esta acción. Esto aumenta la cohesión del contexto de donaciones al encapsular las diferentes estrategias de asignación en clases separadas. Además permite la extensibilidad del sistema al facilitar la adición de nuevas estrategias de asignación sin modificar el código existente (respondiendo al principio solid de Abierto/Cerrado). Por último evita de manera directa el code smell de métodos largos con condicionales complejos al delegar la lógica específica de cada estrategia a sus respectivas clases.

### ServicioRuteo 
- Decido implementar la clase de ServicioRuteo junto a un Crontask para generar de forma asincrónica las rutas de entrega de las donaciones. Esto mejora la Escalabilidad del sistema al permitir manejar un mayor volumen de donaciones sin afectar el rendimiento general, ya que las tareas de ruteo se procesan en segundo plano (respondiendo al principio solid de Responsabilidad Única al separar la lógica de ruteo de otras responsabilidades del sistema)
(Justificación a mejorar)