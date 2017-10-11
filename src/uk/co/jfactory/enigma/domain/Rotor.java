package uk.co.jfactory.enigma.domain;

import java.util.List;

public class Rotor extends AbstractWheel{

	public Rotor( final String codeLetters, final String advanceLetters ){
		super( codeLetters, advanceLetters );
	}

	public Rotor(List<WheelElement> wheelElements) {
		super(wheelElements);
	}

	public int reverseConvert(int characterPosition) {
		int retValue = -1;
		int x = 0;
		while ( (retValue < 0) && (x < wheelElements.size())){
			if (convert(x) == characterPosition ){
				retValue = x;
				break;
			}
			x++;
		}
		if ( retValue == -1 ){
			System.out.println("Unable to locate reverse mapping for " + characterPosition );
			System.out.println("Wheel Mappings");
			for ( x =0 ; x < wheelElements.size() ; x++ ){
				WheelElement wheelElement = wheelElements.get(x);
				System.out.println( x + " : " + wheelElement.getLetter() + " : " 
						                + wheelElement.getOffset() + " : " + convert(x));
			}
		}
		return retValue;
	}

}
