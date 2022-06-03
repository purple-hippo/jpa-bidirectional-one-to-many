
Before running the project you have to set up the database.  
On the root of the project run the following commands (you'll need to have docker engine installed):  
  
to start the container set up in the docker-compose.yml file: 
`docker-compose up -d`    
to stop the container:
`docker-compose down`  
  
These commands will create a postgres image and spin up a container from it. 
The spring boot app will connect to this container.

You can also connect to this db instance from the Intellij Database tool window  
with credentials  
`user: postgres`  
`password: password`  
to see the created tables and the test records.  
