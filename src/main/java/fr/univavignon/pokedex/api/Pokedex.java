package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
	public static List<Pokemon> pokedex1;
	Pokemon pokemon1;
	Pokemon pokemon2;
	
	public Pokedex() {
		pokedex1 = new ArrayList<Pokemon>();
		pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		
		//Ajouter les deux pokemons à la liste
		pokedex1.add(pokemon1);
		pokedex1.add(pokemon2);
	}
	
	//Cette fonction permet de créer un pokemon
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		return new Pokemon(index, null, candy, candy, candy, candy, candy, candy, candy, candy);
	} 
	
	//Cette fonction permet de vérifier que le Pokemon existe à partir un index
	public Pokemon getIndexPok(int index) throws PokedexException {
        for(int i=0;i<pokedex1.size();i++) {
            if(pokedex1.get(i).getIndex() == index) {
                System.out.println(pokedex1.get(i).getIndex());
                return pokedex1.get(i);
            }
        }
        throw new PokedexException("Pas de pokemon");
    }
	
	//Cette fonction permet de renvoyer la taille de la liste
	public int size() {
		return pokedex1.size();
	}
	
	//Cette fonction permet d'ajouter un pokemon
	public int addPokemon(Pokemon pokemon) {
		pokedex1.add(pokemon);
		return pokemon.getIndex();
	}
	
	//cette fonction permet de récupérer le pokemon
	public Pokemon getPokemon(int id) throws PokedexException{
		for(int i=0;i<pokedex1.size();i++) {
            if(pokedex1.get(i).getIndex() == id) {
                System.out.println(pokedex1.get(i).getIndex());
                return pokedex1.get(i);
            }
        }
        throw new PokedexException("Pas de pokemon");
	}
	
	//Cette foonction permet de renvoyer la liste des pokemons
	public List<Pokemon> getPokemons(){
		return pokedex1;
	}

	
	public List<Pokemon> getPokemons(Comparator<Pokemon> order){
		return pokedex1;
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		return null;
	}
}
