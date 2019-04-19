# myretail-pricing-service

APIs

1. GET price information
Req URL : http://localhost:8080/pricing/product/15117730/price
Req Type : GET

2. SET pricing information
Req URL : http://localhost:8080/pricing/product/15117730/price
Req Type : POST
Req  Body : { "price": 105.00, "currency": "INR" }

3. UPDATE pricing information
Req URL : http://localhost:8080/pricing/product/15117730/price
Req Type : PUT
Req  Body : { "price": 105.00, "currency": "INR" }