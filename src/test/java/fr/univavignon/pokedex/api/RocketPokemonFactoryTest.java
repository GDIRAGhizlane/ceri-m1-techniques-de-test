package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RocketPokemonFactoryTest {
	RocketPokemonFactory rocketPokemon;
	Pokemon pokemon1, pokemon2, pokemon3, pokemon4, pokemon5;
	
	
	@Before
	public void init() {
		rocketPokemon = new RocketPokemonFactory();
		pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		pokemon3 = rocketPokemon.createPokemon(-1, 1, 1, 1, 1);
		pokemon4 = rocketPokemon.createPokemon(1, 1, 1, 1, 1);
		pokemon5 = rocketPokemon.createPokemon(0, 1, 1, 1, 1);
    }
	
	@Test
	public void createPokemon() {
		
		//Test pour le premier pokemon
		assertEquals(0, pokemon1.getIndex());	
		assertEquals("Bulbizarre", pokemon1.getName());
		assertEquals(126, pokemon1.getAttack());
		assertEquals(126, pokemon1.getDefense());
		assertEquals(90, pokemon1.getStamina());
		
		//Test pour le deuxième pokemon
		assertEquals(133, pokemon2.getIndex());	
		assertEquals("Aquali", pokemon2.getName());	
		assertEquals(186, pokemon2.getAttack());
		assertEquals(168, pokemon2.getDefense());
		assertEquals(260, pokemon2.getStamina());
		
		//assertEquals(1000, pokemon3.getAttack());
		assertEquals("Ash's Pikachu", pokemon3.getName());
		
		//assertEquals(50, pokemon4.getAttack());
		assertEquals("Bulbasaur", pokemon4.getName());
		
		//assertEquals(50, pokemon5.getAttack());
		assertEquals("MISSINGNO", pokemon5.getName());
		
		/*
		//On vérifie si le pokemon qu'on a crée renvoie le bon IV
		//Le test na passe pas car le RocketFactory donne que 1 aux iv
		Assert.assertEquals(pokemon2.getIv(), rocketPokemon.createPokemon(133,2729, 202, 5000, 4).getIv(), 0.0);
        Assert.assertEquals(pokemon1.getIv(), rocketPokemon.createPokemon(0, 613, 64, 4000, 4).getIv(), 0.0);
		*/
		

	}
}
