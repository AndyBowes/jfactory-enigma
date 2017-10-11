package uk.co.jfactory.enigma.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EnigmaMachineTest {

	private static final Reflector REFLECTOR_I = new Reflector("EJMZALYXVBWFCRQUONTSPIKHGD");
	
	private static final String TEST_MESSAGE = "THISISATESTMESSAGE".toUpperCase();
	
	@Test
	public void testEncryptText() {
		EnigmaMachine enigmaMachine = new EnigmaMachine(createRotorSet());
		String cipherText = enigmaMachine.encryptText(TEST_MESSAGE);
		assertNotNull(cipherText);
		assertFalse(cipherText.isEmpty());
		assertEquals(TEST_MESSAGE.length(), cipherText.length());
		assertNotSame(TEST_MESSAGE, cipherText);
		
		System.out.println("Encrypted Text:'" + cipherText + "'");
		
		// Reset the Enigma Machine to decrypt the message
		enigmaMachine = new EnigmaMachine(createRotorSet());
		String decipheredText = enigmaMachine.encryptText(cipherText);
		assertNotNull(decipheredText);
		assertFalse(decipheredText.isEmpty());
		assertEquals(cipherText.length(), decipheredText.length());
		assertNotSame(cipherText, decipheredText);
		assertEquals(TEST_MESSAGE, decipheredText);		
	}

	private RotorSet createRotorSet() {
		List<Rotor> rotors = new ArrayList<Rotor>();
		rotors.add(RotorFactory.createInstance(RotorType.ROTOR_I));
		rotors.add(RotorFactory.createInstance(RotorType.ROTOR_II));
		rotors.add(RotorFactory.createInstance(RotorType.ROTOR_III));
		Reflector reflector = REFLECTOR_I;
		return new RotorSet(rotors, reflector);
	}

}
