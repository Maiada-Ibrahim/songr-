# SONGR

## Spring boot lab
# Lab 11:Building Full-Stack Web Apps
In this Lab I will use the Spring Initializr to create a new application with artifact songr with Web and Thymeleaf (and optionally Devtools) dependencies. This is a simple web site which uses a backend written in Java.

The site has this routs : /hello , /capitalize/{word} and /albums.

## Instructions:
1. Clone this repo
2. Build with gradle
3. run it with spring boot and navigate to "/"
4. navigate the app


# Lab: 12 - Spring and REST
in this part we created a database and that access that we access it and store data on it once the post resourse invoked by submit the form.
 Also, we render the data in the database using template .

##### Feature :
- The Album model were updated so that it can be saved in a database.
- Add new feature to add album (/addAlbum) route on which you will a form then submit it which will  invoke the post request that will create modle and save it in the database.


### Step Soultion :
1. fill the form at infromation after add (submit) it will send requst at route (/addAlbum)
2. add the album to the data base 
3. Redirect at another route to get data again useig CrudRepository and show it at albums.html

