# CryptoViewer
Небольшое приложение для просмотра криптовалют и их значений.
На основном экране расположен список всех криптовалют, их цена и изменение за сутки в процентах.
При нажатии на криптовалюту открывается детальный экран отдельной криптовалюты с информацией о ней.

## Стек

1) Kotlin
2) Single Activity
3) Jetpack Compose
4) Clean Architecture, MVVM
5) Coroutines
6) Retrofit, OkHttp
7) GSon
8) Room
9) Koin
10) Coil


## Процесс разработки и ожидаемые сроки

1) Ознакомление с дизайном, API, требованиями - 1 час
2) Создание репозитория, связь с локальным репозиторием, разделение на модули (app, presentation, data, domain), добавление необходимых зависимостей - 1 час
3) Добавление основных компонентов UI Kit (атомов и молекул) - 1 час
4) Добавление основного экрана, тестирование его функционала (пока что на моковых данных), параллельно с этим создание viewModel и repository для корректного следования архитектуре - 3 часа
5) Добавление экрана детализации криптовалюты - 1 час
6) Создание навигации между экранами - 30 минут
7) Добавление в проект dependency injection, зависимости теперь передаются через koin - 1 час 30 минут
8) Связь проекта с сервером через retrofit, удаление моковых данных с экранов - 3 часа
9) Добавление в проект локальной базы данных Room - 2 часа
10) Добавление в проект swipe refresh - 1 час
11) Проверка кода, проверка на соответствие с дизайном, при необходимости корректировки - 1 час

### Итого - 16 часов

## Финальное время разработки - 17 часов

Немного дольше возился с retrofit и стейтами, а room и koin подключил немного быстрее, чем планировал изначально.

## ScreenShots 

### Главный экран
![ScreenShot](https://i.postimg.cc/kgtwdMsJ/Loading-Main-Screen.png)
![ScreenShot](https://i.postimg.cc/gk745Lvt/Main-Screen.png)
![ScreenShot](https://i.postimg.cc/wvzw2Kh6/Main-Screen-Error.png)

### Детальный экран монеты
![ScreenShot](https://i.postimg.cc/nV034PMJ/Loading-Detail-Screen.png)
![ScreenShot](https://i.postimg.cc/kG1w7BL4/Detail-Screen1.png)
![ScreenShot](https://i.postimg.cc/j2dZVzgm/Detail-Screen2.png)
![ScreenShot](https://i.postimg.cc/50mnkP38/Detail-Screen-Error.png)

### Swipe Refresh MainScreen
![ScreenShot](https://i.postimg.cc/bNr33922/Refreshing-Main-Screen.png)
![ScreenShot](https://i.postimg.cc/QM16cNK4/Refreshing-Error.png)
