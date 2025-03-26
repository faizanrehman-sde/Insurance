# Insurance API Documentation

This project provides REST APIs for managing insurance policies.

##  Create Insurance
Use the following `curl` command to create a new insurance entry:


curl -X POST http://localhost:8080/api/v1/insurance/create \
     -H "Content-Type: application/json" \
     -d '{  

             
          "name": "Senior Secure",
          "type": "Health",
          "coverage": "75000",
          "premium": "400",
          "minAge": "60",
          "maxAge": "80",
          "gender": "MALE",
          "price": "100000"
           
}'

Response (201 created)
{
    "insuranceId": 1,
    "name": "Senior Secure",
    "type": "Health",
    "coverage": "75000",
    "premium": "400",
    "minAge": "60",
    "maxAge": "80",
    "gender": "MALE",
    "price": "100000"
}

 ## Get All Insurance
curl -X GET http://localhost:8080/api/v1/insurance/

Response (200 ok)
[
    {
        "insuranceId": 1,
        "name": "Basic Health",
        "type": "Health",
        "coverage": "50000",
        "premium": "200",
        "minAge": "18",
        "maxAge": "60",
        "gender": "MALE",
        "price": 100000
    },
    {
        "insuranceId": 2,
        "name": "Women Wellness",
        "type": "Health",
        "coverage": "85000",
        "premium": "300",
        "minAge": "25",
        "maxAge": "55",
        "gender": "FEMALE",
        "price": 150000
    },
    {
        "insuranceId": 3,
        "name": "Child Secure",
        "type": "Health",
        "coverage": "30000",
        "premium": "150",
        "minAge": "1",
        "maxAge": "18",
        "gender": "MALE",
        "price": 650000
    },
    {
        "insuranceId": 4,
        "name": "Comprehensive Care",
        "type": "Health",
        "coverage": "100000",
        "premium": "500",
        "minAge": "21",
        "maxAge": "65",
        "gender": "FEMALE",
        "price": 120000
    },
    {
        "insuranceId": 5,
        "name": "Senior Secure",
        "type": "Health",
        "coverage": "75000",
        "premium": "400",
        "minAge": "60",
        "maxAge": "80",
        "gender": "MALE",
        "price": "100000"
    }
]

##  Get All insurance based on gender (MALE,FEMALE, OTHER)
curl -X GET http://localhost:8080/api/v1/insurance/byGender?gender=MALE

Response (200 Ok)
[
    {
        "insuranceId": 1,
        "name": "Basic Health",
        "type": "Health",
        "coverage": "50000",
        "premium": "200",
        "minAge": "18",
        "maxAge": "60",
        "gender": "MALE",
        "price": 100000
    },
    {
        "insuranceId": 3,
        "name": "Child Secure",
        "type": "Health",
        "coverage": "30000",
        "premium": "150",
        "minAge": "1",
        "maxAge": "18",
        "gender": "MALE",
        "price": 500000
    }
]

## Get all insurances based on age, Retrieves List of insurance if age lies between minAge and maxAge

curl -X GET http://localhost:8080/api/v1/insurance/byAge?age=18

Response (200 Ok)
[
    {
        "insuranceId": 1,
        "name": "Basic Health",
        "type": "Health",
        "coverage": "50000",
        "premium": "200",
        "minAge": "18",
        "maxAge": "60",
        "gender": "MALE",
        "price": 100000
    },
    {
        "insuranceId": 3,
        "name": "Child Secure",
        "type": "Health",
        "coverage": "30000",
        "premium": "150",
        "minAge": "1",
        "maxAge": "18",
        "gender": "MALE",
        "price": 650000
    }
]

## Download police of a particular insurance by providing policyId
curl -X GET http://localhost:8080/api/v1/policies/download/4
Response (200 ok ) -  file will be downloaded from the static folder




## Download receipt when insurance is purchased
must provide userId first and then insuranceId in the uri
curl -X POST  http://localhost:8080/api/v1/purchases/6/5 

Response (200 ok)
{
    "purchaseDate": "2025-03-27T02:17:02.110995",
    "userId": 6,
    "insuranceId": "5",
    "insuranceName": "Senior Secure",
    "insuranceType": "Health",
    "coverage": "75000",
    "premium": "400",
    "status": "Successfully purchased !!",
    "payment": "100000",
    "recieptId": "Tx-12852851"
}
