package ase.ro.cts.laboratoare;

public class Produs {
	public static final int VECHIME_CLIENT_MAXIMA=10;
	public static final float DISCOUNT_CLIENT_MAXIM=0.15f;
		public float calculeazaPretFinal(int tipProdus, float pretinitial, int vechimeClientInAni)
		  {
		    float pretFinal = 0;
		    float discountFidelitate = (vechimeClientInAni > VECHIME_CLIENT_MAXIMA) ? DISCOUNT_CLIENT_MAXIM : (float)vechimeClientInAni/100; 
		    if (tipProdus== TipProdus.NOU)
		    {
		      pretFinal = pretinitial;
		    }
		    else if (tipProdus == TipProdus.DISCOUNT)
		    {
		      pretFinal = (pretinitial - (0.1f * pretinitial)) - discountFidelitate * (pretinitial - (0.1f * pretinitial));
		    }
		    else if (tipProdus == TipProdus.STOC_LIMITAT)
		    {
		      pretFinal = (pretinitial - (0.25f * pretinitial)) - discountFidelitate * (pretinitial - (0.25f * pretinitial));
		    }
		    else if (tipProdus == TipProdus.VECHI)
		    {
		      pretFinal = (pretinitial - (0.35f * pretinitial)) - discountFidelitate * (pretinitial - (0.35f * pretinitial));
		    }
		    return pretFinal;
		  }
	}
