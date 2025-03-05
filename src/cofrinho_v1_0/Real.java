package cofrinho_v1_0;

public class Real extends Moeda{

	public Real(double valor) {
		super(valor);
	}
	
	@Override
	public void info() {
		System.out.printf("Código da moeda: BRL | Valor: %.2f\n", this.valor);
	}
	
	@Override
	public double converter() {
		return this.valor;
	}
	
}
