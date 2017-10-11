package uk.co.jfactory.enigma.domain;

public class RotorFactory {

	public static Rotor createInstance(RotorType rotorType){
		return new Rotor( rotorType.getCodeLetters(), rotorType.getAdvanceLetters());
	}
	
}


