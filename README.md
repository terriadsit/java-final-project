# java-final-project

#cURL requests to test endpoints:
Post Restaurant

curl -X POST localhost:3001/restaurant/add -H "Content-Type: application/json" -d "{\"name\":\"Fork and Knife\", \"dairyReview\":3,\"eggReview\":3,\"peanutReview\":3}"

Get Restaurant
curl "localhost:3001/restaurant/1"

Get Restaurant by zip, allergy
curl "localhost:3001/restaurant/search?zip=54220&allergy=egg"

Get Person by displayName
curl "localhost:3001/person/search?displayName=Terri"

Add Person
curl -X POST localhost:3001/person/add -H "Content-Type: application/json" -d "{\"displayName\":\"Michael Jr.\",\"city\":\"Manitowoc Rapids\",\"state\":\"WI\",\"zip\":\"54220\",\"eggInterest\":\"true\",\"peanutInterest\":\"true\",\"dairyInterest\":\"true\",\"admin\":\"false\"}"

Update Person
curl -X PUT localhost:3001/person/1 -H "Content-Type: application/json" -d "{\"displayName\":\"Michael Jr.\",\"city\":\"Sheboygan Falls\",\"state\":\"WI\",\"zip\":\"54220\",\"eggInterest\":\"false\",\"peanutInterest\":\"false\",\"dairyInterest\":\"false\",\"admin\":\"false\"}"