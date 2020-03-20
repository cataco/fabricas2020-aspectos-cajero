import java.util.Date;

import ejemplo.cajero.Cajero;

public aspect listadoOperaciones {
	pointcut metodosComandos(): call(* ejecutar..*(..));
	 
	before (): metodosComandos() {
		    Date date = new Date();
		    String operacion = "Ejectando Operacion en cajero - Fecha: "+date+
		    "\t Comando : " + thisJoinPoint.getClass()+
		   "\t Banco : " + thisJoinPoint.getArgs();
		    Cajero.operaciones.add(operacion);
	}
}
