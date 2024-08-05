AuthServer Run Instructions

Members: Andre Khachatryan, Khachik Astoyan

Clone the repo [https://github.com/khachatryandre/CS392AuthenticationServer]
Run all the Microservices one by one, use UI to see the results (you can also test with Postman on port 8081 if you don’t want to use UI)

#### Deployed to VM

You can access the app on http://35.223.214.147:3000/
The backend can be accessed through http://35.223.214.147:8085/

Main application runs on port 8085
AuthServer runs on port 8082
ResourceServer runs on port 8083
UI runs on port 3000
For UI run
`npm install`
`npm run dev`
Make sure to kill processes on these ports before running

### UPDATED

Run the docker-compose file in the base folder, access the UI from localhost:3000, use Postman for only backend with the localhost:8085 url
