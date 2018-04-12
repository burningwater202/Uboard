# Community Soundboard Project

## Project Description
*original description*

After a quick pivot, I've decided to dive into the soundboard project idea. I felt that it was an idea complex enough that it would give me a challenge and showcase my skills, but not too complex to the point where I would stress myself out too much for the spring of my senior year. This project can currently go one of two ways, the first idea was to have a board that fits the user's screen filled with buttons in close proximity. Most of the buttons will be gray, with a few being colored (more on that later). When a user presses a gray button, they are greeted with a menu that allows them to choose a color (or jpeg image) to use as the button's background as well as a mp3 file to act as the button's noise. Once they submit their button, the selected button will update to reflect the change and the mp3 file and color or jpeg file will be stored in a database. Clicking on the same button now will depress the button and play the noise for everyone on the site to hear. In order to do this each user will have to be logged in a session, allowing for each user to be pinged with a sound when a button is pressed. 

*Update for checkpoint 2*

After the most recent design phase I have noticed that I may not have enough time to create the project as I have described it above. As a substitution for the users all hearing the sound at the same time, I have created a way for users to create a soundboard that is their choice of number of rows and columns as well as the title of the soundboard and the color of the background of the page. These attributes will be stored in a sql database and populate a spinner on the index page of Uboard. From there, the data passed through the URL will allow for the page to be initialized, while pulling the references to the location of the existing soundboard buttons from the database to the populated soundboard. From there, users will be greeted with a number of gray buttons. Pressing a button will send the user to a page where they can upload a sound for the button as well as select a color to make the button become. This will dynamically update when the user presses submit. 

## Project Design

### Integrated Technologies 

*original integrated technologies statement*

This project will utilize Spring MVC and Maven to run the server and connect to a relational database to store references to the files and the included information about each file. The HTML side of the equation is a re-sizeable soundboard that can have a different length and width, but will be defaulted by 27x9 to start. I will also implement a login function from one of many availible login APIs and use this to monitor user sessions. The upload/download mechanic will be using the javascript File API in order to give the users access to uploading and downloading files.

*Statement update for chekpoint 2*

After the most recent checkpoint, I realized there was some more information needed in order for this all to work the way I wanted it to. The upload/download mechanic relies on the use of Spring MVC, and the issue with default size for the soundboard has been worked out through the use of some Javascript. The login functionality has been scrapped due to the issues my fellow classmates have been having trying to use the Spring login authentication, so I figured rather than beating myself up trying to get that to work I would focus my resources on more important aspects of the project. 

### Use Cases

1. User uploads a sound to the soundboard
2. User presses another user's soundboard button, playing the sound
3. User downloads sound from a button
4. User creates a soundboard
5. User views another soundboard

To reflect the changes in the project specification the login/logout cases have been removed and replaced with the user created soundboard cases. 

### Necessary Design Documents

Nothing as of 1st checkpoint

## Project Schedule

1. Checkpoint 1: Make HTML page and learn how to use Spring/start work on spring server
2. Checkpoint 2: Work on Upload/Download functionality and sound playing. Create the "soundboard maker" javascript code for user generated soundboards
3. Checkpoint 3: Modify the upload/download functions in order to get them to fit with the soundboard. Modify the javascript behind the user generated soundboard so that it determines whether or not a particular button is pre-populated with a sound based on its unique ID. This will require full SQL integration.
4. Final Checkpoint: Refactor redundant code and clean up the project. Prepare for deployment and finalize any features.

## Project Justification

### Novelty

*Original Novelty Statement*

This project is taking a spin on the idea of the soundboard and using crowdsourcing to make it even better. Traditional soundboards have a variety of pre-chosen sounds, but this one will let users choose to upload their own sound clips and play them together with others. Additionally, the users will be able to download the sounds that they like for their own personal use.

*statement updated for checkpoint 2*

After further testing and work, the novelty of the project has shifted slightly. It still retains the "allowing users to upload their own sound clips", however playing together with others has been replaced with populating the board with other anonymous users. The anonymity adds a bit of a layer of novelty as anyone can add to any soundboard with any sound, leading to some potentially wacky combinations.


### Complexity

*original complexity statement*

This project may sound simple on the outside, but it is going to be more complex than it sounds. Firstly, I have to find a way to not only allow users to upload their own files, but also a way to then put them into a database with a specific access key so that the button the user chooses will play the sound when pressed. Also, giving the users the ability to download the sounds will pose a challenge as well because it might be difficult to recieve the files back from the database once they've been uploaded. Lastly, the overall design seems to be a challenge because my original thought was to have a board that extended out vastly in each direction, letting each user put their sound wherever they wanted on the board and allowing for expansion as the board fills up. This might not be practical given the fact that we're not running a professional server for this, and I'm curious to see how the expansion would work since the site will likely be using a two-dimensional array to build the button board and store the data. 

*statement updated for checkpoint 2*

The complexity idea has not changed quite as significantly as the others. One of the major hurdles I had seen before in terms of giving the user the ability to create their own soundboard with varying size has been overcome with some relatively simple javascript. The database part still perplexes me and I'm interested in seeing how I'm going to implement that in checkpoint 3, because that's essentially going to be the entire backbone of this project. 
