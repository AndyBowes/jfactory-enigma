package uk.co.jfactory.enigma.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWheel {

	protected static List<WheelElement> generateWheelElements(final String codeLetters, final String advanceLetters) {
		List<WheelElement> wheelElements = new ArrayList<WheelElement>(codeLetters.length());
		char letter = 'A';
		for ( char codeLetter : codeLetters.toUpperCase().toCharArray()){
			wheelElements.add(new WheelElement(letter, codeLetter, isAdvance(advanceLetters, letter)));
			letter++;
		}
		return wheelElements;
	}

	private static boolean isAdvance(CharSequence advanceLetters, char letter) {
		boolean isAdvance = false;
		for (int pos = 0; pos < advanceLetters.length() ; pos++){
			if (advanceLetters.charAt(pos) == letter ){
				isAdvance = true;
				break;
			}
		}
		return isAdvance;
	}

	protected AbstractWheel( String codeLetters ){
		this( codeLetters, "");
	}
	
	protected AbstractWheel( String codeLetters, String advanceLetters ){
		this( generateWheelElements(codeLetters, advanceLetters));
	}
	
	protected AbstractWheel(List<WheelElement> wheelElements) {
		this.wheelElements = wheelElements;
	}
	
	public int getCharacterPosition(char character) {
		int position = -1;
		int x = 0;
		while ( (position == -1) && (x < wheelElements.size())){
			if ( character == wheelElements.get(x).getLetter()){
				position = x;
			}
			x++;
		}
		return position;
	}
	
	public boolean advance(){
		WheelElement topElement = wheelElements.get(0);
		wheelElements.remove(0);
		wheelElements.add(topElement);
		return topElement.isAdvance();
	}

	public int convert( final int entryPosition ){
		int returnValue = entryPosition + wheelElements.get(entryPosition).getOffset();
		int elementCount = wheelElements.size();
		while ( returnValue < 0 ){
			returnValue = returnValue + elementCount;
		}
		if ( returnValue >= elementCount ){
			returnValue = returnValue - elementCount;
		}
		return returnValue;
	}
	
	public char getCharacterAtPosition(int characterPosition) {
		return wheelElements.get(characterPosition).getLetter();
	}

	protected final List<WheelElement>wheelElements;

	
	
}
