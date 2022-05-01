package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonMetadataProviderTest {
	IPokemonMetadataProvider test1;
	PokemonMetadata pokemonMD1;
	PokemonMetadata pokemonMD2;
	
	@Before
	public void init() {
		//Creation mock
		test1 = mock(IPokemonMetadataProvider.class);

		//Creation instance pokemonMD1
		pokemonMD1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		//Creation instance pokemonMD1
		pokemonMD2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);
	}
	
	@Test
	public void getPokemonMetadata() throws PokedexException {
		
		when(test1.getPokemonMetadata(Mockito.anyInt())).thenAnswer(
				new Answer() {
					@Override
					public Object answer(InvocationOnMock invocation) throws PokedexException {
    					Object[] args = invocation.getArguments();
    					int index = (int) args[0];
    					if(index == 0) {
    						return new PokemonMetadata(0,"Bulbizarre",126,126,90);
    					}
    					else if(index == 133) {
    						return new PokemonMetadata(133, "Aquali", 186, 168, 260);
    					}
    					else if(index<0 || index >150) {
    						throw new PokedexException("Index numérique doit etre entre 0 et 150");
    					}
    					else {
    						return new PokemonMetadata(index, null,0,0,0);
    					}
    				}
    			}
		);
		assertEquals("Bulbizarre", pokemonMD1.getName());
		assertEquals("Aquali", pokemonMD2.getName());
		
		
		//PokemonMetadata pokemonMD3 = new PokemonMetadata(160, "Aquali", 186, 168, 260);
		//Exception
		//when(pokemonMetadata1.getIndex() > 150).thenThrow(new PokedexException("l'index numérique doit etre entre 0 et 150"));
		//when(test1.getPokemonMetadata(anyInt())).thenAnswer(new PokedexException("l'index numérique doit etre entre 0 et 150"));
	}
}
