# desafioMeta
desafio da Meta

This is a Challenge Application.


You should be able to use this 2 microsservices, running the frontend application and the backend aplication.

I'm not be able to know how the http://api.worldbank.org/v2/country works porperly, to get the total of results using the pagination system, maybe I have to use a POST request using a attibute to get the other pages, with the others countries names and codes.

The frontEnd application isn't working properly, I have a trouble with the parse data to create a table with the information.

## Commands to start and run application on docker
On the root of this project you should be run:
> docker build -t desafio-meta .
After build you can check if the docker image was created running this command:
> docker images
And you can see the desafio-meta container on your terminal, After this you should be start your container using this command:
> docker run -p 8080:8080 desafio-meta
