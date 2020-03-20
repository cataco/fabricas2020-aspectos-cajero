import java.util.Date;

public aspect Auditoria {
	
	pointcut metodoAuditoria(): call(* ejemplo.cajero.Cajero.setAuditoria(..));
 
	before (): metodoAuditoria() {
		    Date date = new Date();
		    System.out.println("Ejectando Operacion en cajero - Fecha: "+date.toString());
		    System.out.println("\t argumentos : " + thisJoinPoint.getArgs()[0].toString());
	}
	
	
}
