package uk.co.jfactory.enigma.domain;

public class WheelElement {

	private final char letter;
	private final int offset;
	private final boolean advance;
	
	public WheelElement( final char letter, final char codedLetter ){
		this( letter, codedLetter, false );
	}

	public WheelElement( final char letter, final char codedLetter, final boolean advance ){
		this.letter = letter;
		offset = codedLetter - letter;
		this.advance = advance;
	}

	public char getLetter() {
		return letter;
	}

	public int getOffset() {
		return offset;
	}

	public boolean isAdvance() {
		return advance;
	}

}
