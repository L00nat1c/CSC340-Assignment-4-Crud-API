# Assignment-4-CRUD-API

  Demo for a CRUD API project.

## Installation
- Get the project
    - clone or download zip

- Open the project in InteliJ
- [`/src/main/resources/application.properties`] (https://github.com/L00nat1c/CSC340-Assignment-4-Crud-API/blob/master/demo/src/main/resources/application.properties) file  is the configuration for the MySQL database on your localhost.
    - the database name is on the `datasource.url` property between the last `/` and the `?`. In this case the database name is `f24-340`.
    - You MUST have the database up and running before running the project! 
      - Open your XAMPP Control Panel.
      - Start the Apache server.
      - Start MySQL.
      - Click on MySQL "Admin" to open up the DBMS.
      - Ensure the database that you need is available.
    - Build and run the main class. You should see 2 new tables created in the aforementioned database.
 
## API Endpoints
Use POSTMAN to try the following endpoints:

## Get list of Animals

### Request

    `GET /animals/all`

    `http://localhost:8080/animals/all`

### Response

[

    {
        "animalID": 2,
        "name": "Marlin",
        "scientificName": "Amphiprioninae",
        "species": "Clownfish",
        "habitat": "Coral Reefs",
        "description": "description1"
    },
    
    {
        "animalID": 3,
        "name": "Blue Jay",
        "scientificName": "Cyanocitta cristata",
        "species": "Bird",
        "habitat": "forests",
        "description": "a blue bird"
    },
    
    {
        "animalID": 4,
        "name": "Blue poison dart frog",
        "scientificName": "Dendrobates tinctorius azureus",
        "species": "Frog",
        "habitat": "forest islands",
        "description": "a poison frog"
    },
    
    {
        "animalID": 52,
        "name": "Fennec fox",
        "scientificName": "Vulpes zerda",
        "species": "Fox",
        "habitat": "desert",
        "description": "fox native to North Africa."
    },
    
    {
        "animalID": 8800,
        "name": "Emperor Scorpion",
        "scientificName": "Scorpiones",
        "species": "Scorpion",
        "habitat": "desert",
        "description": "Predatory arachnids."
    },
    
    {
        "animalID": 8880,
        "name": "Nemo",
        "scientificName": "Amphiprioninae",
        "species": "Clownfish",
        "habitat": "Coral Reefs",
        "description": "Orange and white striped fish."
    },
    
    {
        "animalID": 8888,
        "name": "Asiatic Lion",
        "scientificName": "Panthera Leo",
        "species": "Lion",
        "habitat": "Savanna",
        "description": "Large, powerfully built cat. The second largest cat species."
    }
]


## Get a specific Animal by ID

### Request

  `GET /animals/{animalID}`

  `http://localhost:8080/animals/8888`

###Response

{

    "animalID": 8888,
    "name": "Asiatic Lion",
    "scientificName": "Panthera Leo",
    "species": "Lion",
    "habitat": "Savanna",
    "description": "Large, powerfully built cat. The second largest cat species."
    
}

## Add a new animal

### Request

  `POST /animals/new`

  `http://localhost:8080/animals/new --data
      {
          "name": "TestName",
          "scientificName": "TestScienceName",
          "species": "TestSpecies",
          "habitat": "TestHabitat",
          "description": "TestDescription"
      }`

### Response 

  `This will post a list of all Animals + the new Animal`

    {
        "animalID": "animalID"
        "name": "TestName",
        "scientificName": "TestScienceName",
        "species": "TestSpecies",
        "habitat": "TestHabitat",
        "description": "TestDescription"
    }

## Update an existing animal

### Request

    `PUT /animals/update/{animalID}`

    `http://localhost:8080/animals/update/8888 --data
    {
    "name": "Asiatic Leo",
    "scientificName": "Panthera Leo",
    "species": "Lion",
    "habitat": "Savanna",
    "description": "Large, powerfully built cat. The second largest cat species."
    }`

### Response

{

    "animalID": 8888,
    "name": "Asiatic Leo",
    "scientificName": "Panthera Leo",
    "species": "Lion",
    "habitat": "Savanna",
    "description": "Large, powerfully built cat. The second largest cat species."
    
}

## Delete an existing Animal

### Request

`DELETE /animals/delete/{animalID}`

`http://localhost:8080/animals/delete/8888`

### Response

A list of all Animals minus the delete Animal.

## Get all animals of a given species

### Request

    `GET /animals/species?species=Frog`

    `http://localhost:8080/animals/species?species=Frog`

### Response

[

    {
        "animalID": 4,
        "name": "Blue poison dart frog",
        "scientificName": "Dendrobates tinctorius azureus",
        "species": "Frog",
        "habitat": "forest islands",
        "description": "a poison frog"
    }
    
]

## Get animals whose name contains a string

### Request

    `GET /animals/name?name=blue`

    `http://localhost:8080/animals/name?name=blue`

### Response

[

    {
        "animalID": 3,
        "name": "Blue Jay",
        "scientificName": "Cyanocitta cristata",
        "species": "Bird",
        "habitat": "forests",
        "description": "a blue bird"
    },
    
    {
        "animalID": 4,
        "name": "Blue poison dart frog",
        "scientificName": "Dendrobates tinctorius azureus",
        "species": "Frog",
        "habitat": "forest islands",
        "description": "a poison frog"
    }
    
]
