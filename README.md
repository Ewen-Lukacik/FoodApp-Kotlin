# FoodApp Kotlin

Projet Android réalisé dans le cadre d'un cours, par un groupe de 3 :
**Imene Bentifraouine, Lyam Matic, Ewen Lukacik**

L'idée c'était de faire une appli de recettes de cuisine, avec une interface propre en Jetpack Compose. On a essayé de rendre ça le plus complet possible côté UI même si la partie données est encore statique pour l'instant.

---

## Ce que fait l'appli

- Un écran d'accueil avec des recettes organisées par catégorie
- Une recherche avec listing de catégories
- Une page détail pour chaque plat (description, ingrédients, infos)
- Une page favoris
- Un profil utilisateur avec stats et menu (modifier profil, favoris, contact, déconnexion)
- Navigation avec une barre en bas (Accueil, Recherche, Favoris, Profil)
- Écrans de connexion et inscription

---

## Stack

- **Kotlin** avec **Jetpack Compose** pour toute l'UI
- **Material Design 3**
- **Navigation Compose** pour les routes
- Une seule Activity, tout le reste c'est des écrans Composable
- Gradle 8 (KTS) + La version Catalog
- SDK min 24, cible 36

---

## Structure

```
app/src/main/java/com/example/foodapp_kotlin/
├── MainActivity.kt               # point d'entrée + nav
└── ui/
    ├── components/
    │   ├── MainScaffold.kt       # wrapper avec topbar + bottombar
    │   ├── TopBar.kt
    │   ├── BottomBar.kt
    │   ├── FoodSection.kt        # section avec titre + "voir tout"
    │   ├── RecipeCard.kt         # carte recette
    │   └── CategoryCard.kt       # carte catégorie
    ├── screens/
    │   ├── SplashScreen.kt           # écran de lancement avec logo, redirige vers login
    │   ├── LoginScreen.kt            # connexion avec email/mot de passe
    │   ├── RegisterScreen.kt         # création de compte
    │   ├── HomeScreen.kt             # accueil avec recettes en vedette et sections par catégorie
    │   ├── SearchScreen.kt           # barre de recherche + liste des catégories
    │   ├── DishScreen.kt             # détail complet d'un plat (description, ingrédients, prix)
    │   ├── FavoritesScreen.kt        # grille des recettes sauvegardées
    │   ├── ProfileScreen.kt          # profil utilisateur avec stats et menu
    │   ├── EditProfileScreen.kt      # formulaire pour modifier les infos du profil
    │   ├── ContactScreen.kt          # formulaire de contact
    │   ├── AllRecipesScreen.kt       # toutes les recettes d'une catégorie
    │   └── CategoryDetailScreen.kt   # détail d'une catégorie avec filtres
    └── theme/
        ├── Theme.kt
        ├── Color.kt
        └── Type.kt
```

---

## Lancer le projet

1. Cloner le repo
   ```bash
   git clone https://github.com/Ewen-Lukacik/FoodApp-Kotlin.git
   ```
2. Ouvrir dans **Android Studio** (Hedgehog ou plus récent)
3. Sync Gradle puis lancer sur un émulateur ou un vrai téléphone (API 24+)

---

## Ce qui reste à faire

- Connecter une vraie base de données (Room ou Firebase)
- Rendre les favoris persistants
- Implémenter la recherche pour de vrai
- Peut-être ajouter un système d'auth réel

---

*Projet scolaire — Imene Bentifraouine, Lyam Matic, Ewen Lukacik*
