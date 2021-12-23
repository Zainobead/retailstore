<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="RetailsStore"></a>Retails Store Assignment</h1>

<h2 class="code-line" data-line-start=6 data-line-end=7 ><a id="This_Retails_Project_Build_using__6"></a>This Retail Project Build using :</h2>
<ul>
<li class="has-line-data" data-line-start="7" data-line-end="8">Spring Boot</li>
<li class="has-line-data" data-line-start="9" data-line-end="10">Rest Controllers to handle the api calls</li>
<li class="has-line-data" data-line-start="10" data-line-end="11">Spring Data ( JPA) to handle the database operations</li>
</ul>
<h2 class="code-line" data-line-start=13 data-line-end=14 ><a id="Features_13"></a>Features</h2>
<ul>
<li class="has-line-data" data-line-start="15" data-line-end="16">Create and add new Users to the system with two types : 
A- Normal users
B- Employee users</li>
<li class="has-line-data" data-line-start="16" data-line-end="17">Add new Bill and calculate the bill price after discount depened on these rules : 
A- 10% discount if the user is normal user
B- 30% discount if the user is employee
C- on every 100$ of the bill he will got 5$ discount</li>
<h2 class="code-line" data-line-start=22 data-line-end=23 ><a id="Installation_and_run_on_your_local_mashine_22"></a>Installation and run on your local machine</h2>
<ul>
<li class="has-line-data" data-line-start="24" data-line-end="25">Clone the source code for server app</li>
<li class="has-line-data" data-line-start="25" data-line-end="26">The project build and connect to mysql DB so you should have MYSQL on your device</li>
<li class="has-line-data" data-line-start="26" data-line-end="27">You should edit the DB configuration on application.properties file on server app</li>
<li class="has-line-data" data-line-start="27" data-line-end="28">you should go to your mysql and create a new schema with the proper name that you put in the app properties</li>
<li class="has-line-data" data-line-start="33" data-line-end="34">You should now do : 
A- mvn clean install on the command line to build the  project</li>
<li class="has-line-data" data-line-start="28" data-line-end="29">After edit the DB configurations now you should run the server app by go to main class and run it as java application because it is a spring boot app and it does not need any extra effort to run.</li>
<li class="has-line-data" data-line-start="29" data-line-end="30">The server will start on port 8080</li>
<li class="has-line-data" data-line-start="30" data-line-end="31">After the server run successfully you should see on your MYSQL schemas that the application create a tables on it automatically using the JPA features</li>
<li class="has-line-data" data-line-start="33" data-line-end="34">You should now go to swagger ui to see all API requests that you can do on this url : 
http://localhost:8080/swagger-ui</li>
<li class="has-line-data" data-line-start="38" data-line-end="40">now you are ready to go and check our simple system !</li>
</ul>
