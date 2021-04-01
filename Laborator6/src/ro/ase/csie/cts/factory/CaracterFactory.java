package ro.ase.csie.cts.factory;

import java.nio.channels.UnsupportedAddressTypeException;

public class CaracterFactory {
public static CaracterAbstract getCaracter(TipCaracter tip,String nume) {
	CaracterAbstract caracter = null;
	switch(tip) {
	case DISNEY:
		caracter=(CaracterAbstract) new CaracterDisney("alb",nume,true);
		break;
	case MARVEL:
		caracter = new CaracterMarvel(nume,50);
		break;
		default: 
			throw new UnsupportedOperationException();
		}
		return caracter;
	}
}
