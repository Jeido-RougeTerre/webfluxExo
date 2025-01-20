### **Exercice 1 : Découverte des flux réactifs (Mono et Flux)**

#### **Objectif :**
Créer un contrôleur qui expose deux endpoints :
1. Un **Mono** pour afficher un message unique.
2. Un **Flux** pour afficher une liste de nombres.

#### **Énoncé :**
1. Créez un contrôleur nommé `BasicController`.
2. Implémentez deux endpoints :
    - **GET `/api/welcome` :** Retourne un `Mono<String>` contenant `"Welcome to Project Reactor!"`.
    - **GET `/api/numbers` :** Retourne un `Flux<Integer>` contenant les nombres de 1 à 5.