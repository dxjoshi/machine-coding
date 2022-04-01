Cache(keys=5)
SET(“A”, 100)
SET(“B”, 200)
SET(“C”, “Hello”, 60)
GET B				o/p -> 200
GET C				o/p -> Hello
GET D				o/p -> null		(key does not exist case)
DEL B				o/p -> 1
GET B				o/p -> null
DEL B				o/p -> 0
GET_TTL A			o/p -> -1
GET_TTL C			o/p -> 30		(let’s say 30 seconds are remaining)




Cache 5
SET A 100
SET B 200
SET C "Hello" 60
GET B
GET C
GET D
DEL B
GET B
DEL B
GET_TTL A
GET_TTL C


Cache 5
SET A 100
SET B 200000000000
SET C Hello 30
SET D true
SET E 50.1234567890

GET B
GET C
GET E
GET A

SET F false
GET D

GET C

Cache(keys=5)

SET(“A”, 100)
SET(“B”, 200000000000)
SET(“C”, “Hello”, 30)
SET(“D”, true)
SET(“E”, 50.1234567890)

GET B				o/p -> 200000000000
GET C				o/p -> Hello
GET E				o/p -> 50.1234567890
GET A				o/p -> 100

SET(“F”, false)
GET D				o/p -> null		(Key “D” should have been evicted)

GET C				o/p -> null		(Key “C” should have been evicted 
 due to past expiry, let’s say 30   
 seconds has been past)