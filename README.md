**Nom** : GDIRA

**Prénom**: Ghizlane

**Groupe** : M1 ILSEN GR1 CLA

**#Les badges:**

#Badge pour CircleCi:

[![CircleCI](https://circleci.com/gh/GDIRAGhizlane/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://circleci.com/gh/GDIRAGhizlane/ceri-m1-techniques-de-test/tree/master)

#Badge pour le couverture de test:

[![codecov](https://codecov.io/gh/GDIRAGhizlane/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=2BIEQ5W8XT)](https://codecov.io/gh/GDIRAGhizlane/ceri-m1-techniques-de-test)

#Badge pour le CheckStyle :

![Checkstyle](target/site/badges/checkstyle-result.svg)

#Badge pour JavaDoc :

[![javadoc](https://javadoc.io/badge2/org.springframework/spring-core/javadoc.svg)](https://javadoc.io/doc/org.springframework/spring-core)

---------------------------------------------------------------------------------------------------------------------------------------------
#Le projet contient plusieurs Interface:

1/- **IPokemonMetadataProvider** est chargé pour un index donné de retourner les métadonnées d’une espèce.

2/- **IPokemonFactory** permet de créer un individu.

3/- **IPokedex** est notre conteneur, qui étend les deux interfaces précédentes, qu’il fournit à travers le pattern "Décorateur".

4/- **IPokedexFactory** permet de créer une instance de IPokedex.

**-->** Un IPokedex appartient à un PokemonTrainer, défini par un nom et une équipe.

**-->** Les PokemonTrainer sont créés à travers l’interface **IPokemonTrainerFactory**. 





