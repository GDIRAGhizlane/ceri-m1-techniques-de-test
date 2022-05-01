package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;

import org.junit.Test;

public class IPokemonFactoryTest {
	
	//Pour la création du mock
	IPokemonFactory test1;
			
	//Pour la création des pokemons
	Pokemon pokemon1;
	Pokemon pokemon2;
	
	@Before
	public void init() {
		test1 = mock(IPokemonFactory.class);
		pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
	}
	
		
	@Test
	public void createPokemon() throws PokedexException {
		
		when(test1.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon1);
		when(test1.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pokemon2);
		
		//Le premier pokemon
		assertEquals(0, pokemon1.getIndex());
		assertEquals("Bulbizarre",pokemon1.getName());
		assertEquals(126, pokemon1.getAttack());
		assertEquals(126, pokemon1.getDefense());
		assertEquals(90, pokemon1.getStamina());
		assertEquals(613, pokemon1.getCp());
		assertEquals(64, pokemon1.getHp());
		assertEquals(4000, pokemon1.getDust());
		assertEquals(4, pokemon1.getCandy());
		assertEquals(56.0, pokemon1.getIv(),0.1);
		
		//Le deuxième pokemon
		assertEquals(133, pokemon2.getIndex());
		assertEquals("Aquali",pokemon2.getName());
		assertEquals(186, pokemon2.getAttack());
		assertEquals(168, pokemon2.getDefense());
		assertEquals(260, pokemon2.getStamina());
		assertEquals(2729, pokemon2.getCp());
		assertEquals(202, pokemon2.getHp());
		assertEquals(5000, pokemon2.getDust());
		assertEquals(4, pokemon2.getCandy());
		assertEquals(100.0, pokemon2.getIv(),0.1);
		
	}
}
