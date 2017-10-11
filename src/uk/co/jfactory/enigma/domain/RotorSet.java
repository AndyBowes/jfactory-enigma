package uk.co.jfactory.enigma.domain;

import java.util.List;

public class RotorSet {

	private final KeyPanel keyPanel;
	private final List<Rotor> rotors;
	private final Reflector reflector;
	
	public RotorSet( List<Rotor> rotors, Reflector reflector){
		this( new KeyPanel(), rotors, reflector );
	}
	
	public RotorSet( KeyPanel keyPanel, List<Rotor> rotors, Reflector reflector){
		this.keyPanel = keyPanel;
		this.rotors = rotors;
		this.reflector = reflector;
	}

	public List<Rotor> getRotors() {
		return rotors;
	}
	
	public char encryptCharacter(char character){

		int characterPosition = keyPanel.getCharacterPosition(character);

		// Reverse pass through the Rotors
		for ( Rotor rotor: rotors ){
			characterPosition = rotor.convert( characterPosition );
		}
		
		characterPosition = reflector.convert(characterPosition);

		// Reverse pass through the Rotors
		for ( int rotorNumber = rotors.size(); rotorNumber > 0 ; rotorNumber-- ){
			characterPosition = rotors.get(rotorNumber -1).reverseConvert( characterPosition );
		}
		
		char encodedCharacter = keyPanel.getCharacterAtPosition( characterPosition );

		// Move the Rotors on a notch
		advanceRotors();
		
		return encodedCharacter;
	}
	
	private void advanceRotors(){
		boolean advanceNext = true;
		int rotorNumber = 0;
		while ( advanceNext && (rotorNumber < rotors.size())){
			advanceNext = rotors.get(rotorNumber++).advance();
		}
	}

	public void setRotorSettings(String rotorCode) {
		throw new UnsupportedOperationException("Need to implement setRotorSettings");
	}
	
}
