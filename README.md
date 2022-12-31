## java-final-project
A final project assigned by CodeCademy using with Spring-Boot to make a server.

# Why I made this code as it is:
CodeCademy used a KanBan board to assign tasks which I could then complete. No code was provided by CodeCademy.

# CURL requests to test endpoints:
After installing, compiling and running this code, you are able to test the server paths using the following CURL commands in a Bash terminal.

# Add Restaurant
curl -X POST localhost:3001/restaurant/add -H "Content-Type: application/json" -d "{\"name\":\"Four Forks\", \"zip\":\"54222\",\"dairyReview\":null,\"eggReview\":3,\"peanutReview\":3}"

# Get Restaurant
curl "localhost:3001/restaurant/1"

# Get Restaurant by zip, allergy
curl "localhost:3001/restaurant/search?zip=54222&allergy=dairy"

# Get Person by displayName
curl "localhost:3001/person/search?displayName=Terri"

# Add Person
curl -X POST localhost:3001/person/add -H "Content-Type: application/json" -d "{\"displayName\":\"Terri\",\"city\":\"Manitowoc Rapids\",\"state\":\"WI\",\"zip\":\"54220\",\"eggInterest\":\"true\",\"peanutInterest\":\"true\",\"dairyInterest\":\"true\",\"admin\":\"true\"}"

# Update Person
curl -X PUT localhost:3001/person/1 -H "Content-Type: application/json" -d "{\"displayName\":\"Terri\",\"city\":\"Sheboygan Falls\",\"state\":\"WI\",\"zip\":\"54220\",\"eggInterest\":\"false\",\"peanutInterest\":\"false\",\"dairyInterest\":\"false\",\"admin\":\"True\"}"


# Add Review
curl -X POST localhost:3001/review/add -H "Content-Type: application/json" -d "{\"displayName\":\"Terri\",\"restaurantId\":1,\"peanut\":5,\"egg\":5,\"dairy\":5,\"commentary\":\"my comments\",\"status\":\"PENDING\"}"

# Get Reviews by Restaurant
curl "localhost:3001/review/2"

# Get Pending Reviews if Admin
curl "localhost:3001/review/admin/1"


# Update Pending Reviews if Admin
curl -X PUT localhost:3001/review/admin/1 -H "Content-Type: application/json" -d "{\"id\":4,\"displayName\":\"Terri\",\"restaurantId\":1,\"peanut\":5,\"egg\":4,\"dairy\":5,\"commentary\":\"my comments\",\"status\":\"APPROVED\"}"
