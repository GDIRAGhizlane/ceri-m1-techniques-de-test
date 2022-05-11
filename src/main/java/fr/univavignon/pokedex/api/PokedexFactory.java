package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {
	
	IPokemonMetadataProvider metadataProvider;
	IPokemonFactory pokemonFactory;
	
	public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		return new Pokedex();
	}
}
