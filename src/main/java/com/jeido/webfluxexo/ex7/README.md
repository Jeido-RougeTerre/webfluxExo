### **Exercice 7 : Gestion des utilisateurs**

#### **Objectif :**
Créer une API réactive pour gérer une liste d’utilisateurs avec des fonctionnalités CRUD complètes.

#### **Énoncé :**
1. Créez une entité `User` avec les propriétés suivantes :
    - `id` : Identifiant unique (généré automatiquement).
    - `name` : Nom de l’utilisateur.
    - `email` : Email de l’utilisateur.
    - `active` : Booléen indiquant si l’utilisateur est actif.
2. Implémentez un repository réactif pour gérer les utilisateurs.
3. Ajoutez un service et un contrôleur pour les endpoints suivants :
    - **GET `/api/users`** : Retourne tous les utilisateurs.
    - **GET `/api/users/{id}`** : Retourne un utilisateur par ID.
    - **POST `/api/users`** : Crée un nouvel utilisateur.
    - **PUT `/api/users/{id}`** : Met à jour un utilisateur.
    - **DELETE `/api/users/{id}`** : Supprime un utilisateur.