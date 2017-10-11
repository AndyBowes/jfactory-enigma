package uk.co.jfactory.enigma.domain;

public class Reflector extends AbstractWheel{
	
	public Reflector( final String codeLetters ){
		super( codeLetters );
	}

	@Override
	public boolean advance() {
		return false;
	}
	
	
}
