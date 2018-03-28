# Community Soundboard Project

## Project Description
  After a quick pivot, I've decided to dive into the soundboard project idea. I felt that it was an idea complex enough that it would give me a challenge and showcase my skills, but not too complex to the point where I would stress myself out too much for the spring of my senior year. This project can currently go one of two ways, the first idea was to have a board that fits the user's screen filled with buttons in close proximity. Most of the buttons will be gray, with a few being colored (more on that later). When a user presses a gray button, they are greeted with a menu that allows them to choose a color (or jpeg image) to use as the button's background as well as a mp3 file to act as the button's noise. Once they submit their button, the selected button will update to reflect the change and the mp3 file and color or jpeg file will be stored in a database. Clicking on the same button now will depress the button and play the noise for everyone on the site to hear.

## Project Design

### Integrated Technologies 

This project will use the required Spring MVC and Maven libraries, and I am planning to use a sql server to store all of the user supplied files. Additionally, I'm going to be looking into the possibility of using an array of objects to reference the stored data from the database.  

### Use Cases

1. User creates a soundboard button
2. User presses another user's soundboard button, playing the sound
3. User downloads sound from a button
4. Two users simultaneously press two buttons, playing both sounds

There will likely be more use cases than this, these are the ones off of the top of my head.

### Necessary Design Documents

None yet!

## Project Schedule

For each of the major checkpoints I want to have at least one major component of my project done, these major components being uploading files to the database, playing sounds across all concurrent users' computers, letting the users download the files from the database and then using these concepts to build the actual soundboard. These achievements will be completed in the order that I mentioned them and (hopefully) finished before the project is due. 

## Project Justification

### Novelty

This project is taking a spin on the idea of the soundboard and using crowdsourcing to make it even better. Traditional soundboards have a variety of pre-chosen sounds, but this one will let users choose to upload their own sound clips and play them together with others. Additionally, the users will be able to download the sounds that they like for their own personal use.

### Complexity

This project may sound simple on the outside, but it is going to be more complex than it sounds. Firstly, I have to find a way to not only allow users to upload their own files, but also a way to then put them into a database with a specific access key so that the button the user chooses will play the sound when pressed. Also, giving the users the ability to download the sounds will pose a challenge as well because it might be difficult to recieve the files back from the database once they've been uploaded. Lastly, the overall design seems to be a challenge because my original thought was to have a board that extended out vastly in each direction, letting each user put their sound wherever they wanted on the board and allowing for expansion as the board fills up. This might not be practical given the fact that we're not running a professional server for this, and I'm curious to see how the expansion would work since the site will likely be using a two-dimensional array to build the button board and store the data. 
