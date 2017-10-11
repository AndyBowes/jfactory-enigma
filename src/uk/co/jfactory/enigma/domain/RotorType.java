package uk.co.jfactory.enigma.domain;

public enum RotorType {
	
	ROTOR_I("JGDQOXUSCAMIFRVTPNEWKBLZYH", "Q"),
	ROTOR_II("AJDKSIRUXBLHWTMCQGZNPYFVOE", "E"),
	ROTOR_III("BDFHJLCPRTXVZNYEIWGAKMUSQO","V");
	
	private final String codeLetters;
	private final String advanceLetters;
	
	private RotorType(final String codeLetters, final String advanceLetters){
		this.codeLetters = codeLetters;
		this.advanceLetters = advanceLetters;
	}

	public String getCodeLetters() {
		return codeLetters;
	}

	public String getAdvanceLetters() {
		return advanceLetters;
	}
	
}
