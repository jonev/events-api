# Events API
A minor API to save events to MySQL database.  

## Development
Start application with:
`./gradlew bootRun`

Start development dependencies with:
```
cd dev-database
sudo docker-compose up
```
Manually edit data on http://localhost:8081  
User: root  
Password: example  

## Build
Docker image is build on [docker hub](https://hub.docker.com/repository/docker/jonev/events-api).

## Run in production
Change value of MYSQL_PASSWORD and CLIENT_ID in ./docker-compose.yaml
then run with:

```
sudo docker-compose up
```
This will start the API, MySQL database and Adminer (database client for viewing the data)
## Post event
Adjust `X-Client-Id` equals to CLIENT_ID, then post:
```
curl --location --request POST 'http://localhost:9000/events' \
--header 'X-Client-Id: aaa' \
--header 'Content-Type: application/json' \
--data-raw '{
    "eventType": "postmanPost",
    "appId": "postman",
    "timestamp": "2020-11-12T18:00:00.0Z",
    "userId": "MouseClicker"
    
}'
```

## Security
`X-Client-Id` must be contained in the client application, 
which means that the API is not secure.

## Documentation (only local access)
Open Api v3 documentation added.
Json file [here.](http://localhost:8080/api-docs)
Gui [here](http://localhost:8080/api-docs-ui)