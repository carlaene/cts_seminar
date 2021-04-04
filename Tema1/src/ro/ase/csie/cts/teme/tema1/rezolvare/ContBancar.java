package ro.ase.csie.cts.teme.tema1.rezolvare;

public class ContBancar implements Payable{
	private double	valoareImprumut;
	private double rata;	
	private int	zileActiv;
	private int tipCont;
	@Override
	public void RataLunara() {
		// TODO Auto-generated method stub
		
	}
	public ContBancar(double valoareI, double rata,int zile, int tip) {
		if(valoareI<0)
		{
			throw new ExceptieValoareImprumutNegativa("Valoarea imprumutului este negativa. Trebuie sa fie mai mare de 0");
		}
	}
}
