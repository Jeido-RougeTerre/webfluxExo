### **Exercice 6 : API des livres (Bibliothèque)**

#### **Objectif :**
Créer une API fonctionnelle pour gérer un catalogue de **livres**, avec des fonctionnalités pour ajouter, chercher, et supprimer des livres.

---

#### **Énoncé :**
1. Créez un modèle `Book` avec les propriétés suivantes :
    - `id` : Identifiant unique.
    - `title` : Titre du livre.
    - `author` : Auteur du livre.
2. Implémentez un gestionnaire (`BookHandler`) pour gérer les fonctionnalités suivantes :
    - **GET `/api/books` :** Retourne tous les livres.
    - **GET `/api/books/search?title=XYZ` :** Recherche les livres par titre.
    - **POST `/api/books` :** Ajoute un nouveau livre.
    - **DELETE `/api/books/{id}` :** Supprime un livre par son ID.
3. Configurez les routes avec un `RouterFunction`.