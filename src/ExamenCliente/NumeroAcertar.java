package ExamenCliente;

import java.io.Serializable;

public class NumeroAcertar implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int numero;
	
	public NumeroAcertar(int numero) {
		this.numero=numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
