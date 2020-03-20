import java.util.Date;

public aspect Auditoria {
	
	pointcut metodoAuditoria(): call(* setAuditoria..*(..));
 
	before (): metodoAuditoria() {
		    Date date = new Date();
		    System.out.println("Ejectando Operacion en cajero - Fecha: "+date.toString());
		    System.out.println("\t argumentos : " + thisJoinPoint.getArgs());
	}
	
	
}
