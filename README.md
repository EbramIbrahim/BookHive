# BookHive - Android Book Discovery App 📚

BookHive is an Android application that helps users discover, explore, and manage their reading journey. Built with modern Android technologies, it provides seamless book browsing and detailed information.

## Features ✨
- **Comprehensive Book Search**: Find books by title, author, or keywords
- **Rich Book Details**: View covers, descriptions, ratings, publication info
- **Reading Lists**: Organize books into custom collections
- **Smooth UI Experience**: Jetpack Compose-powered interface
- **Unit Testing**: ensure app robustness

## Screenshots 📸

### Introduction Flow
| Splash Screen | Onboarding 1 | Onboarding 2 | Onboarding 3 |
|---------------|--------------|--------------|--------------|
| ![Splash](https://github.com/user-attachments/assets/72ac9c19-47a6-43c6-94cf-4490058e6f7b) | ![Onboard1](https://github.com/user-attachments/assets/4746b852-4c64-436e-814c-d4b3d2dd6f3d) | ![Onboard2](https://github.com/user-attachments/assets/d9d06fe1-d682-4378-8039-540fb1cb4e12) | ![Onboard3](https://github.com/user-attachments/assets/1b89e0a6-5605-497a-92e3-012439b55a75) |

### Core Functionality
| Home Screen | Book Details | Search | Library |
|-------------|--------------|--------|---------|
| ![Home](https://github.com/user-attachments/assets/327a5c5c-4094-4f9c-bfb6-a95bc8e48878) | ![Details](https://via.placeholder.com/300x600?text=Book+Details) | ![Search](https://via.placeholder.com/300x600?text=Search+Results) |

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
