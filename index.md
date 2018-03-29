# Community Soundboard Project

## Project Description
After a quick pivot, I've decided to dive into the soundboard project idea. I felt that it was an idea complex enough that it would give me a challenge and showcase my skills, but not too complex to the point where I would stress myself out too much for the spring of my senior year. This project can currently go one of two ways, the first idea was to have a board that fits the user's screen filled with buttons in close proximity. Most of the buttons will be gray, with a few being colored (more on that later). When a user presses a gray button, they are greeted with a menu that allows them to choose a color (or jpeg image) to use as the button's background as well as a mp3 file to act as the button's noise. Once they submit their button, the selected button will update to reflect the change and the mp3 file and color or jpeg file will be stored in a database. Clicking on the same button now will depress the button and play the noise for everyone on the site to hear. In order to do this each user will have to be logged in a session, allowing for each user to be pinged with a sound when a button is pressed. 

## Project Design

### Integrated Technologies 

This project will utilize Spring MVC and Maven to run the server and connect to a relational database to store references to the files and the included information about each file. The HTML side of the equation is a re-sizeable soundboard that can have a different length and width, but will be defaulted by 27x9 to start. I will also implement a login function from one of many availible login APIs and use this to monitor user sessions. The upload/download mechanic will be using the javascript File API in order to give the users access to uploading and downloading files.

### Use Cases

1. User creates a soundboard button
2. User presses another user's soundboard button, playing the sound
3. User downloads sound from a button
4. Two users simultaneously press two buttons, playing both sounds
5. User can login
6. User can logout

### Necessary Design Documents

Nothing as of 1st checkpoint

## Project Schedule

1. Checkpoint 1: Make HTML page and learn how to use Spring/start work on spring server
2. Checkpoint 2: Get upload/download mechanic working, get sound playing functionality down
3. Checkpoint 3: Implement login function with an API & create "sessions" system
4. Final Checkpoint: Clean up code/interface, implement multithreading if possible and finalize project.

## Project Justification

### Novelty

This project is taking a spin on the idea of the soundboard and using crowdsourcing to make it even better. Traditional soundboards have a variety of pre-chosen sounds, but this one will let users choose to upload their own sound clips and play them together with others. Additionally, the users will be able to download the sounds that they like for their own personal use.

### Complexity

This project may sound simple on the outside, but it is going to be more complex than it sounds. Firstly, I have to find a way to not only allow users to upload their own files, but also a way to then put them into a database with a specific access key so that the button the user chooses will play the sound when pressed. Also, giving the users the ability to download the sounds will pose a challenge as well because it might be difficult to recieve the files back from the database once they've been uploaded. Lastly, the overall design seems to be a challenge because my original thought was to have a board that extended out vastly in each direction, letting each user put their sound wherever they wanted on the board and allowing for expansion as the board fills up. This might not be practical given the fact that we're not running a professional server for this, and I'm curious to see how the expansion would work since the site will likely be using a two-dimensional array to build the button board and store the data. 
