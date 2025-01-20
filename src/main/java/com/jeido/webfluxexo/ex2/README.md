### **Exercice 2 : Manipulation des flux avec des opérateurs**

#### **Objectif :**
Créer un contrôleur qui expose un endpoint pour transformer et filtrer un flux.

#### **Énoncé :**
1. Créez un contrôleur nommé `OperationController`.
2. Implémentez un endpoint :
    - **GET `/api/processed-numbers` :** Retourne un `Flux<String>` :
        - Génère un flux de nombres de 1 à 10.
        - Filtre les nombres pairs.
        - Multiplie chaque nombre par 10.
        - Retourne chaque valeur sous la forme `"Processed: X"` (où `X` est le résultat).