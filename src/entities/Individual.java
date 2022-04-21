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

		double basicTax = 0.0;

		if (getRendaAnual() < 20000.00) {
			basicTax = getRendaAnual() * 0.15;

		} else {
			basicTax = getRendaAnual() * 0.25;

		}

		basicTax -= gastosSaude * 0.5;

		if (basicTax < 0.0) {
			basicTax = 0.0;
		}

		return basicTax;
	}

}
