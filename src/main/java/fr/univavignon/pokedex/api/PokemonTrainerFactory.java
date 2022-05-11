package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {
	
	//Pour la création du pokedex
	Pokedex pokedex;
	
	private Pokedex pokedex1;
	
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		//return new PokemonTrainer(name, team, null);
		return new PokemonTrainer(name, team, pokedexFactory.createPokedex(pokedex1, pokedex1));
	}
}
