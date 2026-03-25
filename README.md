# FoodApp Kotlin

A modern Android recipe app built with **Jetpack Compose** and **Material Design 3**.

## Features

- Browse recipe cards with name, description, duration, difficulty, and price
- Category sections to group recipes (e.g. "Italian Classics")
- Bottom navigation bar with 4 tabs: Home, Search, Favorites, Profile
- Top bar branding "Tasty Recipes"
- Light / Dark theme support (Material You dynamic colors on Android 12+)
- Edge-to-edge display

> **Note:** Search, Favorites, and Profile screens are currently empty placeholders.

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin 2.0.21 |
| UI | Jetpack Compose + Material 3 |
| Architecture | Single Activity + Composable screens |
| Build | Gradle 8 (KTS) + Version Catalog |
| Min SDK | 24 (Android 7.0) |
| Compile SDK | 36 (Android 15) |

## Project Structure

```
app/src/main/java/com/example/foodapp_kotlin/
├── MainActivity.kt              # Entry point
└── ui/
    ├── components/
    │   ├── MainScaffold.kt      # Layout wrapper (TopBar + BottomBar + content)
    │   ├── TopBar.kt            # Orange header bar
    │   ├── BottomBar.kt         # Bottom navigation (Home, Search, Favorites, Profile)
    │   ├── FoodSection.kt       # Category section with "Find more" link
    │   └── RecipeCard.kt        # Recipe card (image, title, duration, difficulty, price)
    ├── screens/
    │   ├── HomePage.kt          # Main screen with scrollable food sections
    │   ├── SearchPage.kt        # Placeholder
    │   ├── FavoritesPage.kt     # Placeholder
    │   └── ProfilePage.kt       # Placeholder
    └── theme/
        ├── Theme.kt
        ├── Color.kt
        └── Type.kt
```

## Getting Started

1. Clone the repository
   ```bash
   git clone https://github.com/Ewen-Lukacik/FoodApp-Kotlin.git
   ```
2. Open the project in **Android Studio Hedgehog** or later
3. Sync Gradle and run on an emulator or physical device (API 24+)

## Dependencies

- `androidx.core:core-ktx`
- `androidx.lifecycle:lifecycle-runtime-ktx`
- `androidx.activity:activity-compose`
- `androidx.compose:compose-bom:2024.09.00`
- `androidx.compose.material3`
