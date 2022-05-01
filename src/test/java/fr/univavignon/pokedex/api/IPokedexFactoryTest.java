package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
	
	//Pour le création des mocks
	IPokedexFactory test1;
	IPokedex pokedex1;
	IPokemonFactory pokemonFactory1;
	IPokemonMetadataProvider pokemonMD1;
	
	@Before
	public void init() {
		test1 = mock(IPokedexFactory.class);
		pokedex1 = mock(IPokedex.class);
		pokemonFactory1 = mock(IPokemonFactory.class);
		pokemonMD1 = mock(IPokemonMetadataProvider.class);
	}
	
	@Test
	public void createPokedex() {
		when(test1.createPokedex(pokemonMD1, pokemonFactory1)).thenReturn(pokedex1);
		assertEquals(test1.createPokedex(pokemonMD1, pokemonFactory1), pokedex1);
	}
}
