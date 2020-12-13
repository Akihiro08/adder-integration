# Adder
TP Bootiful tests du cours de VVCL

## Exécution des tests

Les tests ne se lanceront pas avec la commande `mvn clean verify`. À la place il faut éxécuter les tests à la main dans IntelliJ.

Pour lancer les tests d'intégration `AdderTestSuite`, il faut d'abord commencer par lancer le client via Angular CLI (Voir README du dossier `/front/adder-front`).

## Lancement du back

```
mvn compile
mvn exec:java -Dexec.mainClass="com.hyridia.adder.AdderApplication"
```
