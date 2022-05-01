package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonTrainerFactoryTest {
	IPokemonTrainerFactory test1;
	IPokedex pokedex1;
	Team team;
	PokemonTrainer pokemonTrainer1;
	PokemonTrainer pokemonTrainer2;
	PokemonTrainer pokemonTrainer3;
	
	@Before
	public void init() {
		//création des mocks
		test1 = Mockito.mock(IPokemonTrainerFactory.class);
        
        IPokedexFactory pokedex = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider pokprovider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        
        pokedex1 = pokedex.createPokedex(pokprovider, pokemonFactory);
        
        //Création des pokemons trainer
        pokemonTrainer1 = new PokemonTrainer("Ghizlane", team.valueOf("MYSTIC"), pokedex1);
        pokemonTrainer2 = new PokemonTrainer("GDIRA", team.valueOf("INSTINCT"), pokedex1);
        pokemonTrainer3 = new PokemonTrainer("GhizGD", team.valueOf("VALOR"), pokedex1);
	}
	
	@Test
	public void createTrainer() {
        //L'utilisation de "anyString()" pour donner n'importe quel string
        when(test1.createTrainer(Mockito.anyString(), Mockito.any(Team.class),Mockito.any(IPokedexFactory.class))).thenAnswer(
    			new Answer() {
    				@Override
    				public Object answer(InvocationOnMock invocation) throws PokedexException {
    					Object[] args = invocation.getArguments();
    					String nom = (String) args[0];
    					if(nom.equals("Ghizlane")){
    						return new PokemonTrainer("Ghizlane", team.valueOf("MYSTIC"), pokedex1);
    					}
    					else if(nom.equals("GDIRA")) {
    						return new PokemonTrainer("GDIRA", team.valueOf("INSTINCT"), pokedex1);
    					}
    					else if(nom.equals("GhizGD")) {
    						return new PokemonTrainer("GhizGD", team.valueOf("VALOR"), pokedex1);
    					}
    					else {
    						return new PokedexException("Error: la création est impossible");
    					}
    				}
    			}
    			);
        
		System.out.println(pokemonTrainer1);
		System.out.println(pokemonTrainer1.getName());
		System.out.println(pokemonTrainer1.getTeam());
		
		System.out.println(pokemonTrainer2);
		System.out.println(pokemonTrainer2.getName());
		System.out.println(pokemonTrainer2.getTeam());
		
		System.out.println(pokemonTrainer3);
		System.out.println(pokemonTrainer3.getName());
		System.out.println(pokemonTrainer3.getTeam());
		
		assertEquals(pokemonTrainer1.getName(), "Ghizlane" );
		assertEquals(pokemonTrainer1.getTeam(), team.valueOf("MYSTIC"));
		assertEquals(pokemonTrainer2.getName(), "GDIRA");
		assertEquals(pokemonTrainer2.getTeam(), team.valueOf("INSTINCT"));
		assertEquals(pokemonTrainer3.getName(), "GhizGD");
		assertEquals(pokemonTrainer3.getTeam(), team.valueOf("VALOR"));
		
    }	
}
