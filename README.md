# My Personal Project

## What will the application do?

- The application will allow the **user** to enter their records for each phase of a **hyrox competition**.

- **User** can add their records for a complete hyro instant, phase by phase as well in case they wanted to try out a compelte

- **User** will be asked to fill out a brief of their personal information such as full name, age, gender, weight, and height.

- Various **Hyrox Competitions** could be added to the competitions archive with *gender* (if any criteria), *weight class*, and *minimum records* required to enter

## Who will use it?

- This program will be used by athletes that are training to take part in a **hyrox competition**
- It will help them understand if they could take part in the competitions that they are aiming for or not
- It could also be used by hyrox training academies to keep track of their athletes' progress

## Why is this project of interest to you?

- I have a coworker that trains for hyrox and when he was telling me about these competitions, I noticed thaat is there are weight and gender classes, and most significantly minimum record criterias, it might be confusing for the athletes to see which competition to participate in.

- Also, keeping track of all of the **competitions** with their requirments will be helpful for the athletes so they do not have ot jump around hyrox holders' websites for information.

## User Stories

- As a user I want to be able to add a hyrox instant with time records for each of the 8 phases plus sum of the runs in the competition.
- As a user I want ot be able to add a competition with a title, weight class, gender, and minimum records needed to participate.
- As a user I want to be able to view the list of the hyrox competitions that I want to participate in.
- As a user I want to be able to see if I meet the criteria to participate in hyroxs and add them to my wishlist competitions.
- As a user I want to be given the option to save the data I recorded in my program including the hyroxs, my practice run times, and my wishlist of competitions I want to participate
- As a user I want to be able to load my saved data from previous uses.

## Instructions for End User

- You can view the panel that displays the competitions that have already been added to the wishlist by going to the Wishlist menu and sleect view from the options provided.
- You can generate the first required action related to the user story "adding a new hyrox to competitions" by going to Add menu and select Hyrox,
then you can record the title, wieght class, gender, and the minimum record required and then select Add.
- You can generate the second required action related to the user story "adding a new instance to instants history" by going  to Add menu and slect Intance, then you can recrod your time for all the phases seperately under a title, and then press Add button.
- You can update the wishlist with the competitions that you are eligible to participate in by going to the Wishlist menu and click on Update.
- You can qui the application by goig to the Quit menu and cliock on Quit.
- You can locate my visual component in the landing page of the app. Notice the button-like graphics are only for visualizations.
- You can save the state of my application by going to the File menu and clicking on Save.
- You can reload the state of my application by going to the File menu and clicking on Load.

## Phase 4: Task 2

Tue Aug 11 04:56:33 PDT 2026   
Hyrox: Open, has been added to Competetitions  
Tue Aug 11 04:56:57 PDT 2026  
Hyrox: NorthShore, has been added to Competetitions  
Tue Aug 11 04:57:10 PDT 2026  
Practice instance Julyhas been added to the history  
Tue Aug 11 04:57:21 PDT 2026  
Practice instance Augusthas been added to the history  
Tue Aug 11 04:57:23 PDT 2026  
Eligible hyrox competitions has been added to wishlist  

## Phase 4: Task 3

The first thing I would do to make the structure of my design stronger, is to avoid any duplications. There is a  
There is a significant amount of duplication seen in classes `Competitions` and `InstantsHistory`, these could be put  
in a hierarchy system to handle their duplications. Also when adding the implementing the `windowListener` in  
`HyroxAppGUI`, there are 6 out of 7 methods that are unused, for that prupose, I would add an inner class so it can help  
me with tha empty implementation of the unused methods there.  
Also, for he `toJson` methods in classes: `Hyrox`, `Competitions`, `InstantHyrox`, `InstantsHistory`, and `Wishlist`,  
there is a lot of duplicate code which are very similar to each other, My idea to refactor those is to have a helper  
method that takes the `Json` specific components as arguments and writes them into the `.json` file, this way with every  
change I do not have to go ahead and fix each of those 5 methods one by one.