package uk.co.jfactory.enigma.domain;

public class KeyPanel extends AbstractWheel {
	
	public KeyPanel (){
		this( "ABCDEFGHIJKLMNOPQRSTUVWXYZ" );
	}
	
	public KeyPanel( final String codeLetters ){
		super( codeLetters );
	}

	@Override
	public boolean advance() {
		return true;
	}


}
