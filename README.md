# Tarea02.1-1Evaluacion
Sobre el proyecto que se provee de GitHub: https://github.com/adp-code-2223/Tarea02.1-Enunciado:

 - 1.- Crear clase AccountMovement para modelar los datos de la tabla ACC_MOVEMENT e implementa un toString() con la implementación por defecto del IDE (1 punto)
 - 2.- Crear estructura para AccountMovementSQLServerDao que implemente solo el método read. El resto de métodos los podéis dejar con  throw new UnsupportedOperationException("Not supported yet."); (1,5 puntos)
 - 3.- Modifica el método de IAccountDao transferir(cuentaOrigen.getAccountId(), cuentaDestino.getAccountId(), cantidad) para que devuelva el identificador del AccountMovement creado en lugar de boolean. Si ha habido algún error, devolverá -1. ( 1 punto)
 - 4.- Añade a IEmpleadoServicio el método: public AccountMovement transferir(int empnoOrigen, int empnoDestino, BigDecimal cantidad) throws SaldoInsuficienteException, InstanceNotFoundException, UnsupportedOperationException; (0,25puntos)
    - La implementación del método transferir del servicio deberá:
      - Comprobar que cantidad es mayor que cero. En caso contrario lanzará una excepción UnsupportedOperationException  (0,25puntos)
      - Recuperar a través de IAccountDao un objeto Account por el número de empleado origen. Si  encuentra el objeto Account y no hay saldo suficiente lanzará SaldoInsuficienteException (se provee en el paquete es.teis.ud2.exceptions). Si tiene suficiente saldo para hacer la transferencia, recuperará un objeto Account por el número de empleado destino, obtendrá los ids de las cuentas origen y destino y llamará a accountDao.transferir(int accIdOrigen, int accIdDestino, BigDecimal amount). (3 puntos)
      - Con el id devuelto por accountDao.transferir(), obtendrá el objeto AccountMovement de persistencia y lo devolverá. Si no lo encuentra, lanzará una InstanceNotFoundException (1 punto)
 - 5.- Completa en Main.java el método private static AccountMovement transferirDineroEntreEmpleados(int empnoOrigen, int empnoDestino, BigDecimal cantidad) {...} para que instancie el servicio e invoque a su método transferir. Controla las excepciones que puedan surgir dentro de transferirDineroEntreEmpleados mostrando su mensaje de forma que no lleguen al main. (2 puntos)
