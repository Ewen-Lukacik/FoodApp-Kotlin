# FoodApp Kotlin

Une application Android moderne de recettes construite avec **Jetpack Compose** et **Material Design 3**.

## Fonctionnalités

- Parcourir des fiches recettes avec nom, description, durée, difficulté et prix en euros
- Sections par catégories pour regrouper les recettes (ex. "Classiques Italiens")
- Barre de navigation inférieure avec 4 onglets : Accueil, Recherche, Favoris, Profil
- Page de recherche avec barre de recherche et listing de catégories
- Page détail d'un plat avec description, ingrédients et ajout aux favoris
- Page favoris avec grille de recettes sauvegardées
- Page profil avec statistiques et menu utilisateur
- Affichage bord à bord (edge-to-edge)

## Stack technique

| Couche       | Technologie                              |
|--------------|------------------------------------------|
| Langage      | Kotlin 2.0.21                            |
| Interface    | Jetpack Compose + Material 3             |
| Architecture | Single Activity + écrans Composable      |
| Build        | Gradle 8 (KTS) + Version Catalog         |
| SDK minimum  | 24 (Android 7.0)                         |
| SDK cible    | 36 (Android 15)                          |

## Structure du projet

```
app/src/main/java/com/example/foodapp_kotlin/
├── MainActivity.kt                  # Point d'entrée + navigation
└── ui/
    ├── components/
    │   ├── MainScaffold.kt          # Conteneur principal (TopBar + BottomBar + contenu)
    │   ├── TopBar.kt                # Barre supérieure
    │   ├── BottomBar.kt             # Navigation inférieure (Accueil, Recherche, Favoris, Profil)
    │   ├── FoodSection.kt           # Section catégorie avec lien "Voir tout"
    │   ├── RecipeCard.kt            # Fiche recette (image, titre, durée, difficulté, prix)
    │   └── CategoryCard.kt          # Fiche catégorie (image, nom, nombre de recettes)
    ├── screens/
    │   ├── HomeScreen.kt            # Écran principal avec sections de recettes
    │   ├── SearchScreen.kt          # Recherche + listing catégories
    │   ├── DishScreen.kt            # Détail d'un plat
    │   ├── FavoritesScreen.kt       # Recettes sauvegardées
    │   └── ProfileScreen.kt         # Profil utilisateur
    └── theme/
        ├── Theme.kt
        ├── Color.kt
        └── Type.kt
```

## Démarrage

1. Cloner le dépôt
   ```bash
   git clone https://github.com/Ewen-Lukacik/FoodApp-Kotlin.git
   ```
2. Ouvrir le projet dans **Android Studio Hedgehog** ou une version plus récente
3. Synchroniser Gradle et lancer sur un émulateur ou appareil physique (API 24+)

## Dépendances

- `androidx.core:core-ktx`
- `androidx.lifecycle:lifecycle-runtime-ktx`
- `androidx.activity:activity-compose`
- `androidx.compose:compose-bom:2024.09.00`
- `androidx.compose.material3`
- `androidx.navigation:navigation-compose`
