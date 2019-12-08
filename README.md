# ToDo Mobile App

## Business Requirement

  * Fetch list of ToDo item from Server
  * Save list in local DB for caching
  
## Project Specification

  Project is developed using MVVM clean architecture in Kotlin language. App is following a offline first architecture. Room DB is used for
  offline caching of ToDo Items. App is continuously monitoring local storage and only fetches data from Api if not available locally. Pagination library is used for better performance.
  
## Libraries Used
  
  * Retrofit
  * Koin
  * Mockito
  * Room
  * Coroutine
  * Paging
  
## Improvements/ Not Implemented

  * Code coverage can be improved with more unit test cases
  * Swipe to refresh
  * Local DB cache refresh based on business requirement


