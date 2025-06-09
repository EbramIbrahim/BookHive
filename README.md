# BookHive - Android Book Discovery App 📚

![BookHive Logo](https://via.placeholder.com/200x200?text=BookHive+Logo) <!-- Replace with actual logo -->

BookHive is an Android application that helps users discover, explore, and manage their reading journey. Built with modern Android technologies, it provides seamless book browsing and detailed information.

## Features ✨
- **Comprehensive Book Search**: Find books by title, author, or keywords
- **Rich Book Details**: View covers, descriptions, ratings, publication info
- **Reading Lists**: Organize books into custom collections
- **Smooth UI Experience**: Jetpack Compose-powered interface
- **Offline Support**: Cached data for offline browsing
- **Dark/Light Theme**: Automatic theme switching based on system settings

## Screenshots 📸

### Introduction Flow
| Splash Screen | Onboarding 1 | Onboarding 2 | Onboarding 3 |
|---------------|--------------|--------------|--------------|
| ![Splash](https://via.placeholder.com/300x600?text=Splash+Screen) | ![Onboard1](https://via.placeholder.com/300x600?text=Welcome) | ![Onboard2](https://via.placeholder.com/300x600?text=Discover) | ![Onboard3](https://via.placeholder.com/300x600?text=Start+Reading) |

### Core Functionality
| Home Screen | Book Details | Search | Library |
|-------------|--------------|--------|---------|
| ![Home](https://via.placeholder.com/300x600?text=Book+Feed) | ![Details](https://via.placeholder.com/300x600?text=Book+Details) | ![Search](https://via.placeholder.com/300x600?text=Search+Results) | ![Library](https://via.placeholder.com/300x600?text=My+Library) |

## Tech Stack 🛠️
- **UI Framework**: Jetpack Compose
- **Asynchronous Programming**: Kotlin Coroutines + Flow
- **Dependency Injection**: Hilt
- **Network**: Retrofit + Moshi
- **Persistence**: Room Database
- **Testing**: JUnit, MockK, Turbine
- **CI/CD**: GitHub Actions (Build & Test Pipelines)
- **Architecture**: MVVM with Clean Architecture

## Key Components 🧩
```mermaid
graph TD
    A[UI Layer - Jetpack Compose] --> B[Domain Layer]
    B --> C[Data Layer]
    C --> D[Local Data - Room]
    C --> E[Remote Data - Retrofit]
    F[Coroutines] --> A
    F --> B
    F --> C
    G[DI - Hilt] -->|Provides| A
    G -->|Provides| B
    G -->|Provides| C
