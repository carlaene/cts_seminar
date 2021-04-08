package ro.ase.csie.cts.ro.factory.method;

public class FactoryModNormal extends FactoryAbstractCaracter {

	@Override
	public CaracterJoc getCaracter(TipCaracter tip, String nume) {
		// TODO Auto-generated method stub
		CaracterJoc caracter=null;
		switch(tip) {
		case DISNEY:
			caracter=new CaracterDisney(nume);
			break;
		case MARVEL:
			caracter=new CaracterMarvel(nume, 300);
			break;
		case DC:
			caracter=new CaracterDCComics(nume);
			break;
			default:
				throw new UnsupportedOperationException();
		}
		return caracter;
	
		}
	}


