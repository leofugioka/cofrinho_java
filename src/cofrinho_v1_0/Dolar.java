package cofrinho_v1_0;

public class Dolar extends Moeda{
	
	public Dolar(double valor) {
		super(valor);
	}
	
	@Override
	public void info() {
		System.out.printf("Código da moeda: USD | Valor: %.2f\n", this.valor);
	}
	
	@Override
	public double converter() {
		return this.valor * 5.7;
	}
}
