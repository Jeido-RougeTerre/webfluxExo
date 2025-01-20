### **Exercice 4 : Création d’un endpoint GET**

#### **Objectif :**
Créer un endpoint qui retourne une liste statique d’articles.

#### **Énoncé :**
1. Créez une classe `ArticleController` avec une route **GET** accessible à `/api/articles`.
2. Le endpoint doit retourner un `Flux<String>` contenant les titres suivants :
    - `"Introduction to Spring WebFlux"`
    - `"Reactive Programming with Project Reactor"`
    - `"Building APIs with Spring Boot"`