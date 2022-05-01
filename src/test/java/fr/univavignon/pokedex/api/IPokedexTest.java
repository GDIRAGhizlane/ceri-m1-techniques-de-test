package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest  {
	
	public static List<Pokemon> pokedex1;
    IPokedex test;
    IPokemonFactory pokemonFactory1;
    IPokemonMetadataProvider pokemonMD1;
    
    @Before
    public void init() {
    	pokedex1 = new ArrayList<Pokemon>();
    	test = mock(IPokedex.class);
    	pokemonFactory1 = mock(IPokemonFactory.class);
    	pokemonMD1 = mock(IPokemonMetadataProvider.class);
    }
    
	
	@Test
	public void size() {
		addPokemon();
        when(test.size()).thenReturn(pokedex1.size());
        assertEquals(test.size(), 2);
	}
	
	@Test
	public void addPokemon() {
		//Création instance pokemon1
		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre" , 126, 126, 90, 613, 64, 4000, 4, 56);
				
		//Création instance pokemon2
		Pokemon pokemon2 = new Pokemon(133, "Aquali" , 186, 168, 260, 2729, 202, 5000, 4, 100);
		
		pokedex1.add(pokemon1);
        pokedex1.add(pokemon2);
        
        when(test.addPokemon(pokemon1)).thenReturn(pokemon1.getIndex());
        when(test.addPokemon(pokemon2)).thenReturn(pokemon2.getIndex());
        
        assertEquals(test.addPokemon(pokemon1), 0);
        assertEquals(test.addPokemon(pokemon2), 133);
	}
	
	@Test
	public void getPokemon() throws PokedexException {
        addPokemon();        
        //L'utilisation de "anyInt()" pour donner n'importe quel entier
        when(test.getPokemon(Mockito.anyInt())).thenReturn(getIndexPok(0));
        assertEquals(pokedex1.get(0), getIndexPok(0));
        //assertEquals(pokedex1.get(1), getIndexPok(133));
    }
    
	//Cette fonction permet de vérifier que l'index est entre 0 et 150 et de lever l'exception s'il ne vérifie pas la condition
    public Pokemon getIndexPok(int index) throws PokedexException {
        for(int i=0;i<pokedex1.size();i++) {
            if(pokedex1.get(i).getIndex() == index) {
                System.out.println(pokedex1.get(i).getIndex());
                return pokedex1.get(i);
            }
        }
        throw new PokedexException("Vous devez donner un index entre 0 et 150");
    }
		
    @Test
	public void getPokemons() {
    	addPokemon();
    	
    	//Création instance pokemon1
    	Pokemon pokemon1 = new Pokemon(0, "Bulbizarre" , 126, 126, 90, 613, 64, 4000, 4, 56);			
    	//Création instance pokemon2
    	Pokemon pokemon2 = new Pokemon(133, "Aquali" , 186, 168, 260, 2729, 202, 5000, 4, 100);
    	
    	//Crétion de la liste des pokemons par rapport au pokedex
    	List<Pokemon> pokemonsListe = new ArrayList<Pokemon>();
    	for(Pokemon pok: pokedex1) {
    		pokemonsListe.add(pok);
    	}
    	pokemonsListe.add(pokemon2);
    	
    	when(pokedex1.get(0).getIndex()).thenReturn(pokemonsListe.get(0).getIndex());
		assertEquals(pokedex1.get(1).getIndex(), 133);
    	
    	
    }
}
