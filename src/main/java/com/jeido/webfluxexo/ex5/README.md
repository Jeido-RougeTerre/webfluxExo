### **Exercice 5 : API des tâches (To-Do)**

#### **Objectif :**
Créer une API fonctionnelle complète pour gérer une liste de tâches avec des fonctionnalités CRUD complètes.

---

#### **Énoncé :**
1. Implémentez un modèle `Task` avec les propriétés:
    - `id` : Identifiant unique de la tâche.
    - `description` : Description de la tâche.
    - `completed` : Booléen indiquant si la tâche est terminée.
2. Créez un gestionnaire (`TaskHandler`) avec les fonctionnalités suivantes:
    - **GET `/api/tasks` :** Retourne toutes les tâches.
    - **GET `/api/tasks/{id}` :** Retourne une tâche par son ID.
    - **POST `/api/tasks` :** Ajoute une nouvelle tâche.
    - **PUT `/api/tasks/{id}` :** Met à jour la description ou l’état d’une tâche.
    - **DELETE `/api/tasks/{id}` :** Supprime une tâche par son ID.
3. Configurez les routes avec un `RouterFunction`.