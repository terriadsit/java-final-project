# java-final-project
A final project assigned by CodeCademy using Java with Spring-Boot to make a server, a REST api.

## Why I made this code as it is:
CodeCademy used a KanBan board to assign tasks which I could then complete. No code for this project was provided by CodeCademy.

The server allows users to add people, restaurants and reviews. Then query or make updates to these. 

## CURL requests to test endpoints:
After installing, compiling and running this code, you are able to test the server paths using the following CURL commands in a Bash terminal.

### Add Restaurant
curl -X POST localhost:3001/restaurant/add -H "Content-Type: application/json" -d "{\"name\":\"Four Forks\", \"zip\":\"54222\",\"dairyReview\":null,\"eggReview\":3,\"peanutReview\":3}"

### Get Restaurant
This GET request includes the id of the restaurant in its path.

curl "localhost:3001/restaurant/1"

### Get Restaurant by zip, allergy
This Get request is a search by zip and allergy interest.

curl "localhost:3001/restaurant/search?zip=54222&allergy=dairy"

### Get Person by displayName
curl "localhost:3001/person/search?displayName=Terri"

### Add Person
curl -X POST localhost:3001/person/add -H "Content-Type: application/json" -d "{\"displayName\":\"Terri\",\"city\":\"Manitowoc Rapids\",\"state\":\"WI\",\"zip\":\"54220\",\"eggInterest\":\"true\",\"peanutInterest\":\"true\",\"dairyInterest\":\"true\",\"admin\":\"true\"}"

### Update Person
This update will allow all fields except displayName and id to be updated.

curl -X PUT localhost:3001/person/1 -H "Content-Type: application/json" -d "{\"displayName\":\"Terri\",\"city\":\"Sheboygan Falls\",\"state\":\"WI\",\"zip\":\"54220\",\"eggInterest\":\"false\",\"peanutInterest\":\"false\",\"dairyInterest\":\"false\",\"admin\":\"True\"}"


### Add Review
Reviews should be added with "PENDING" status. Admin are able to update this status to "APPROVED" or "REJECTED".

curl -X POST localhost:3001/review/add -H "Content-Type: application/json" -d "{\"displayName\":\"Terri\",\"restaurantId\":1,\"peanut\":5,\"egg\":5,\"dairy\":5,\"commentary\":\"my comments\",\"status\":\"PENDING\"}"

### Get Reviews by Restaurant
This GET request includes the Review id in its path.

curl "localhost:3001/review/2"

### Get Pending Reviews if Admin
This GET request includes the id or the Person in its path and returns PENDING reviews if the person is an admin.

curl "localhost:3001/review/admin/1"


### Update Pending Reviews if Admin
This PUT request includes the id of the Person in its path and is allowed if the person is an admin.

curl -X PUT localhost:3001/review/admin/1 -H "Content-Type: application/json" -d "{\"id\":4,\"displayName\":\"Terri\",\"restaurantId\":1,\"peanut\":5,\"egg\":4,\"dairy\":5,\"commentary\":\"my comments\",\"status\":\"APPROVED\"}"
