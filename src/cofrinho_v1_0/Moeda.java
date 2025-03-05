package cofrinho_v1_0;

public abstract class Moeda {
	protected double valor;
	
	protected Moeda(double valor) {
		this.valor = valor;
	}
	
	public abstract void info();
	
	public abstract double converter();
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	    	return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	    	return false;
	    }
	    Moeda other = (Moeda) obj;
	    return Double.compare(this.valor, other.valor) == 0;
	}

	@Override
	public int hashCode() {
		final int prime = 32;
	    int result = super.hashCode();
	    long temp = Double.doubleToLongBits(valor);
	    result = prime * result + (int) (temp ^ (temp >>> 32));
	    return result;
	}

}
