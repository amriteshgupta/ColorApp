
# Color Tracker App

## Overview

Color Tracker is an Android application designed to manage a list of colors with offline capabilities and synchronization with a cloud database. The app uses Jetpack Compose for UI, RoomDB for local storage, and Firebase for cloud synchronization. It follows the MVVM (Model-View-ViewModel) architecture pattern for a clean and maintainable codebase.

## Features

- **Offline Access**: View and manage colors even when there is no internet connectivity.
- **Local Storage**: Store colors locally using RoomDB.
- **Cloud Synchronization**: Sync local color data with Firebase Realtime Database.
- **Dynamic Color Generation**: Add new random colors with a click of a button.
- **Sync Status Indicator**: Display the number of pending entries to be synced.

## Screens

- **Color List Screen**: Displays the list of colors fetched from the local RoomDB or the cloud database. The design follows the provided Figma link.

## Architecture

The app follows the MVVM architecture pattern:

- **Model**: Represents the data structure and business logic. It includes data classes and repository for data operations.
- **View**: Composed of UI elements built using Jetpack Compose.
- **ViewModel**: Manages UI-related data in a lifecycle-conscious way. It communicates with the repository to fetch or update data.

## Implementation

### 1. **UI Design**

- **Color List Screen**: Designed using Jetpack Compose. [Figma Link](#)

### 2. **Data Storage**

- **RoomDB**: Local database for storing color data when offline.
- **Firebase Realtime Database**: Cloud database for syncing color data.

### 3. **Features**

- **Add Color**: Generates a new random color with parameters `{ color : "#AABBFF" , time : 1683798291864 }` and stores it in RoomDB.
- **Sync Button**: Sends the color entries from local RoomDB to Firebase.
- **Sync Status**: Shows the number of pending entries beside the sync icon.

## Setup and Installation

1. **Clone the Repository**

    ```bash
    git clone https://github.com/yourusername/color-tracker-app.git
    cd color-tracker-app
    ```

2. **Open the Project**

    Open the project in Android Studio.

3. **Configure Firebase**

    - Go to the [Firebase Console](https://console.firebase.google.com/).
    - Create a new project or use an existing one.
    - Add your Android app to the Firebase project and follow the setup instructions.
    - Download the `google-services.json` file and place it in the `app` directory.

4. **Sync Gradle**

    Ensure Gradle and dependencies are up-to-date. Run the following command in Android Studio:

    ```bash
    ./gradlew build
    ```

## Usage

1. **Run the App**

    Build and run the app on an Android device or emulator.

2. **Add a Color**

    Click on the “Add Color” button to generate and save a new color in the local database.

3. **Sync Colors**

    Click on the “Sync” button to upload local colors to Firebase. The number beside the sync icon will update to reflect the number of pending entries.

## Contributing

Feel free to open issues or submit pull requests. Please ensure your code follows the existing style and conventions.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [RoomDB](https://developer.android.com/training/data-storage/room)
- [Firebase](https://firebase.google.com/docs/android/setup)

---

This README covers the essential aspects of your application and should provide a good starting point for users and contributors. Adjust the content as needed to better fit your specific project details and setup instructions.







#This App I build as an assignment for Janitri Innovations Private Limited for the Role of Android Development Intern.



![image](https://github.com/user-attachments/assets/b753b1f5-e1a0-424d-9cfb-29cc57cfe12d)

