package cofrinho_v1_0;

public class Euro extends Moeda{
	
	public Euro(double valor) {
		super(valor);
	}
	
	@Override
	public void info() {
		System.out.printf("Código da moeda: EUR | Valor: %.2f\n", this.valor);
	}
	
	@Override
	public double converter() {
		return this.valor * 6.0;
	}
}
