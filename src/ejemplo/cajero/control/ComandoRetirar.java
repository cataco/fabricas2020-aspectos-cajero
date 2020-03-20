package ejemplo.cajero.control;

import java.util.Scanner;

import ejemplo.cajero.Cajero;
import ejemplo.cajero.modelo.Banco;
import ejemplo.cajero.modelo.Cuenta;

/**
 * Comando usado para retirar dinero
 */
public class ComandoRetirar implements Comando {

	@Override
	public String getNombre() {
		return "Retirar dinero";
	}

	@SuppressWarnings("resource")
	@Override
	public void ejecutar(Banco contexto) throws Exception {
		
		System.out.println("Retiro de Dinero");
		System.out.println();
		
		// la clase Console no funciona bien en Eclipse
		Scanner console = new Scanner(System.in);			
		
		// Ingresa los datos
		System.out.println("Ingrese el número de cuenta");
		String numeroDeCuenta = console.nextLine();
		
		Cuenta cuenta = contexto.buscarCuenta(numeroDeCuenta);
		if (cuenta == null) {
			throw new Exception("No existe cuenta con el número " + numeroDeCuenta);
		}
		
		System.out.println("Ingrese el valor a retirar");
		String valor = console.nextLine();
		if(Cajero.auditoria) {
			String datos = "RETIRO: monto de "+valor+" de cuenta "+numeroDeCuenta;
		    Cajero.setAuditoria(datos);
		}
	
		try {
			long valorNumerico = Long.parseLong(valor);
			if(Cajero.saldoReducido && cuenta.getSaldo()-valorNumerico < 200000) {
				throw new Exception ("MLa cuenta no puede quedar con un saldo menor a 200.000");
			}
			cuenta.retirar(valorNumerico);
		
		} catch (NumberFormatException e) {
			throw new Exception("Valor a retirar no válido : " + valor);
		}
	}

}
