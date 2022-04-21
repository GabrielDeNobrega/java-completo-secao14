package entities;

public class Individual extends TaxPayer {

	private Double gastosSaude;

	public Individual() {
		super();
	}

	public Individual(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double calcularImposto() {
		if (getRendaAnual() < 20000.00) {
			return getRendaAnual() * 0.15;
		} else if (gastosSaude > 0) {
			Double imposto = getRendaAnual() * 0.25;
			return imposto - gastosSaude * 0.5;
		} else {
			return getRendaAnual() * 0.25;
		}
	}

}
