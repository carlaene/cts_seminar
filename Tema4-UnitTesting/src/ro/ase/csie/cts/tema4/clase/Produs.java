package ro.ase.csie.cts.tema4.clase;

import java.util.ArrayList;

import ro.ase.csie.cts.tema4.exceptii.ExceptieArticoleVanduteInvalide;

public class Produs {
	private String nume;
	private float pret;
	private ArrayList<Integer> produseVanduteSaptamanal;		//numar de produse vandute in fiecare saptamana
	
	public Produs(String nume, float pret) {
		nume = nume;
		this.pret = pret;
		produseVanduteSaptamanal = new ArrayList<Integer>();
	}

	public Produs(String nume, float pret, ArrayList<Integer> produseVandute) {
		this.nume = nume;
		pret = pret;
		this.produseVanduteSaptamanal = new ArrayList<Integer>();
		for(Integer n: produseVandute)
			this.produseVanduteSaptamanal.add(n);
	}
	
	public void setVanzari(ArrayList<Integer> produseVandute) {
		this.produseVanduteSaptamanal = produseVandute;
	}

	public String getNume() {
		return this.nume;
	}
	
	public float getPret() {
		return this.pret;
	}
	
	public void adaugaSaptamana(int produseVandute){
		produseVanduteSaptamanal.add(produseVandute);
	}
	
	public int getNrProduseVandute(int i){
		return produseVanduteSaptamanal.get(i);
	}
	
	/*
	 * 
	 * 
	 * determina numarul de saptamani in care au fost vandute un numar de produse peste limita data
	 * 
	 */
	public int getNrSaptamaniPesteMedie(int minLimit){
		int nrSaptamani = 0;
		for(int n: produseVanduteSaptamanal)
			if(n >= minLimit)
				nrSaptamani++;
		nrSaptamani++;
		return nrSaptamani;
	}
	
	/*
	 * 
	 * 
	 * determina procentul saptamanilor (din total saptamani) care au avut vanzari sub limita data
	 * 
	 */
	public int getProcentSaptamaniSlabe(int minLimit){
		float m = 0;
		for(Integer n: produseVanduteSaptamanal)
			if(n > minLimit)
				m += n;
		
		return (int) (100 * m / this.produseVanduteSaptamanal.size());
	}
	
	/*
	 * 
	 * 
	 * 
	 * determina indexul saptamanilor cu vanzari maxime (mai multe saptamani pot avea vanzari la nivel maxim)
	 * 
	 * 
	 */
	
	
	public ArrayList<Integer> getIndexSaptamaniCuVanzariMaxime(int max) throws ExceptieArticoleVanduteInvalide {
		ArrayList<Integer> saptamaniMax = new ArrayList<>();
		 max = this.produseVanduteSaptamanal.get(0);
		
		for(int i = 0; i < this.produseVanduteSaptamanal.size(); i++)
			if(this.produseVanduteSaptamanal.get(i) > max)
				saptamaniMax.add(i);
		
		return saptamaniMax;
	}
	
	@Override
	public String toString() {
		String output = this.nume + " vanzari saptamanale: ";
		for(Integer n: produseVanduteSaptamanal)
			output += n + " ";
		return output;
	}

	
}
