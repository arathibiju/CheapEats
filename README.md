# Cheap Eats UoA
### Developed by Shreya Singaraju and Arathi Biju
===================================


This app is a fully responsive, interactable android app deveoped using Java and Android Studio. The app is designed for University of Auckland students, as a go-to resource for students to search for the best food and drinks located around the university campus. Stores from different areas such as city campus, grafton campus and off campus (cbd) are featured on the app with the recently visited category featured on the home page. We have attempted to comply with the android material design guidelines where possible.

Introduction
------------

The main activity of the app uses a `RecyclerView` and `RecyclerViewAdapter` to update the top picks section, and `CardView` for the rest of the items.
The different category pages also use a `RecyclerView` and the same adapter to show the different stores in each category. The details view of each store is populated using various different views, including a `ViewPager2` for the images. Users can also tap on the search bar from the main view to search for stores and be taken to the corresponding details page.

Pre-requisites
--------------

- Android Target SDK v30
- Android Mimimumu SDK v24
- Android Build Tools v30.0.3
- Android Support Repository

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

Screenshots
-------------
Main Activity 
<img src="https://user-images.githubusercontent.com/62319771/120919225-8f247c00-c70c-11eb-9faf-712c1863e06b.png" height="500" alt="MainActivity"/> 

City Category
<img src="https://user-images.githubusercontent.com/62319771/120919275-ce52cd00-c70c-11eb-8f11-a1123f6c508c.png" height="500" alt="Category"/> 

Search Activity
<img src="https://user-images.githubusercontent.com/62319771/120919310-fd693e80-c70c-11eb-858d-a9165ac3f777.png" height="500" alt="SearchActivity"/> 

Details Activity of a store, showing store details
<img src="https://user-images.githubusercontent.com/62319771/120919364-4c16d880-c70d-11eb-927a-fd8f912b853e.png" height="500" alt="DetailsActivity"/> 

Acknowledgements
-------------
We would like to thank Dr Reza Shahamiri, Yuanyuan Hu, Jong Yoon Lim and Devashish Dhyani for their guidance and support throughout this project.


