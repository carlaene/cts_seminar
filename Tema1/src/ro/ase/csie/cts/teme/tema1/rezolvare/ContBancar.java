package ro.ase.csie.cts.teme.tema1.rezolvare;

import ro.ase.csie.cts.teme.tema1.rezolvare.exceptii.ExceptieValoareImprumutNegativa;
import ro.ase.csie.cts.teme.tema1.rezolvare.interfete.Payable;

public class ContBancar implements Payable{
	private double	valoareImprumut;
	private double procentRata;	
	private int	zileActiv;
	private int tipCont;
	private static final float BROKERS_FEE=1.25f;
	private static final int NUMAR_ZILE_UN_AN=365;

	public ContBancar() {}
	

	public ContBancar(double valoareI, double rata, int tipCont) throws Exception {
		if(valoareI<0)
			throw new ExceptieValoareImprumutNegativa("Valoarea imprumutului e negativa. sa fie mai mare de 0 lei");
		else
		{
			valoareImprumut = valoareI;
		}
		this.procentRata = rata;
		this.tipCont = tipCont;
	}
	public double getValoareImprumut() {
		return valoareImprumut;
	}
	public void setValoareImprumut(double valoareImprumut) throws ExceptieValoareImprumutNegativa {
		if(valoareImprumut>0)
		{
			throw new ExceptieValoareImprumutNegativa("Valoarea imprumutului este negativa. Trebuie sa fie mai mare de 0");
		}
		else {
			this.valoareImprumut = valoareImprumut;
	
		}
	}
	

	public double getRata() {
		return procentRata;
	}
	public void setRata(double rata) {
		this.procentRata = rata;
	}
	@Override
	public String toString() {
		return "ContBancar [valoareImprumut=" + valoareImprumut + ", rata=" + procentRata + ", zileActiv=" + zileActiv
				+ ", tipCont=" + tipCont + "]";
	}
	
	@Override
	public double RataLunara() {
		// TODO Auto-generated method stub
		return valoareImprumut * procentRata;
	}
	
	public static double calculeazaComisionTotal(ContBancar[] conturi){
		double comisionTotal=0.0;
		ContBancar	contBancar;
		for	(int i=0;i<conturi.length;i++)	{
		contBancar=conturi[i];
		if(contBancar.tipCont==Account.PREMIUM.getTipCont()||contBancar.tipCont==Account.SUPER_PREMIUM.getTipCont())	
		comisionTotal+=BROKERS_FEE	*	(	//	1.25%	broker's	fee
				contBancar.valoareImprumut*Math.pow(contBancar.procentRata,(contBancar.zileActiv/NUMAR_ZILE_UN_AN)) - contBancar.valoareImprumut);	//	interest-principal
		}
		return	comisionTotal;
		}
	

}
