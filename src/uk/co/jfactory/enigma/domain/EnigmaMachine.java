package uk.co.jfactory.enigma.domain;

public class EnigmaMachine {
	
	private final RotorSet rotorSet;
	
	public EnigmaMachine(final RotorSet rotorSet) {
		this.rotorSet = rotorSet;
	}

	public void setRotorSettings(final String rotorCode){
		rotorSet.setRotorSettings( rotorCode );
	}
	
	public String encryptText(final String plainText){
		StringBuffer cipherText = new StringBuffer();
		for (char character: plainText.toCharArray()){
			cipherText.append(encryptCharacter(character));
		}
		return cipherText.toString();
	}

	private char encryptCharacter(final char character) {
		return rotorSet.encryptCharacter( character );
	}

}
