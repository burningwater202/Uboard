# Community Soundboard Project

## Project Description
  After a quick pivot, I've decided to dive into the soundboard project idea. I felt that it was an idea complex enough that it would give me a challenge and showcase my skills, but not too complex to the point where I would stress myself out too much for the spring of my senior year. This project can currently go one of two ways, the first idea was to have a board that fits the user's screen filled with buttons in close proximity. Most of the buttons will be gray, with a few being colored (more on that later). When a user presses a gray button, they are greeted with a menu that allows them to choose a color (or jpeg image) to use as the button's background as well as a mp3 file to act as the button's noise. Once they submit their button, the selected button will update to reflect the change and the mp3 file and color or jpeg file will be stored in a database. Clicking on the same button now will depress the button and play the noise for everyone on the site to hear.
  
If I have enough time at the end of the project, I want to try to add a couple extra buttons at the bottom of the page. These buttons would consist of a "random" button, which will play a random sound from the page, a "Blackout" button which will play all of the sounds, a "party" button which will play 10 random sounds and a voting system for clearing the board. 

Additionally, I'd like to have a "high score" page which would show the top 5 most pressed buttons on the page. 

## Project Design

The overall design of the project relies heavily on a pre-sized 27 by 10 grid of buttons that allows for users to upload their unique sound and play it out. 

### Integrated Technologies 

This project will use the required Spring MVC and Maven libraries, and I am planning to use a sql server to store all of the user supplied files. Additionally, I'm going to be looking into the possibility of using an array of objects to reference the stored data from the database.  

I will use the javascript File API in order to allow users to upload/download files. The website will be built mostly from HTML and CSS, with Javascript to fill in the cracks. 

### Use Cases

1. User creates a soundboard button
2. User presses another user's soundboard button, playing the sound
3. User downloads sound from a button
4. Two users simultaneously press two buttons, playing both sounds

### Necessary Design Documents

None yet!

## Project Schedule

Checkpoint 1: Have the HTML done for the soundboard and begin building the server

Checkpoint 2: Add support for adding sounds to buttons/downloading the sounds

Checkpoint 3: Finalize the "sessions" system to allow multiple users to access at once

Final Checkpoint: Clean up & make final adjustments

## Project Justification

I felt as though this project would be not only a good way to test my skills, but a creative one as well. Similar concepts have been applied, such as soundboard.com that allows users to build and share soundboards with others. My concept differs in the sense that it is letting users upload to a community soundboard and play sounds on the website for anyone who is online to hear. 

### Novelty

This project is taking a spin on the idea of the soundboard and using crowdsourcing to make it even better. Traditional soundboards have a variety of pre-chosen sounds, but this one will let users choose to upload their own sound clips and play them together with others. Additionally, the users will be able to download the sounds that they like for their own personal use.

### Complexity

This project may sound simple on the outside, but it is going to be more complex than it sounds. Firstly, I have to find a way to not only allow users to upload their own files, but also a way to then put them into a database with a specific access key so that the button the user chooses will play the sound when pressed. Also, giving the users the ability to download the sounds will pose a challenge as well because it might be difficult to recieve the files back from the database once they've been uploaded. Lastly, the overall design seems to be a challenge because my original thought was to have a board that extended out vastly in each direction, letting each user put their sound wherever they wanted on the board and allowing for expansion as the board fills up. This might not be practical given the fact that we're not running a professional server for this, and I'm curious to see how the expansion would work since the site will likely be using a two-dimensional array to build the button board and store the data. 
