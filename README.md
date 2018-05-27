kotlin-jsonq
===============
[![License: CC0-1.0](https://img.shields.io/badge/License-CC0%201.0-lightgrey.svg)](https://github.com/s4kibs4mi/kotin-jsonq/blob/master/LICENSE)

A simple Kotlin library to Query over JSON Data

### Installation

Gradle,
```gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
And
```gradle
dependencies {
    implementation 'ninja.sakib:kotlin-jsonq:v0.1'
}
```

### Usage
Let's see a quick example:

<details><summary>Sample data (data.json)</summary>
```json
{
  "name": "products",
  "description": "Features product list",
  "vendor": {
    "name": "Computer Source BD",
    "email": "info@example.com",
    "website": "www.example.com"
  },
  "users": [
    {
      "id": 1,
      "name": "Johura Akter Sumi",
      "location": "Barisal"
    },
    {
      "id": 2,
      "name": "Mehedi Hasan Nahid",
      "location": "Barisal"
    },
    {
      "id": 3,
      "name": "Ariful Islam",
      "location": "Barishal"
    },
    {
      "id": 4,
      "name": "Suhel Ahmed",
      "location": "Sylhet"
    },
    {
      "id": 5,
      "name": "Firoz Serniabat",
      "location": "Gournodi"
    },
    {
      "id": 5,
      "name": "Musa Jewel",
      "location": "Barishal",
      "visits": [
        {
          "name": "Sylhet",
          "year": 2011
        },
        {
          "name": "Cox's Bazar",
          "year": 2012
        },
        {
          "name": "Bandarbar",
          "year": 2014
        }
      ]
    }
  ],
  "products": [
    {
      "id": 1,
      "city": "bsl",
      "name": "iPhone",
      "cat": 1,
      "price": 80000.5
    },
    {
      "id": 2,
      "city": null,
      "name": "macbook pro",
      "cat": 2,
      "price": 150000.1
    },
    {
      "id": 3,
      "city": "dhk",
      "name": "Redmi 3S Prime",
      "cat": 1,
      "price": 12000.1
    },
    {
      "id": 4,
      "city": null,
      "name": "Redmi 4X",
      "cat": 1,
      "price": 15000.1
    },
    {
      "id": 5,
      "city": "bsl",
      "name": "macbook air",
      "cat": 2,
      "price": 110000.00
    },
    {
      "id": 6,
      "city": null,
      "name": "macbook air 1",
      "cat": 2,
      "price": 81000.2
    }
  ],
  "cities": [
    {
      "id": 1,
      "name": "Barishal"
    },
    {
      "id": 2,
      "name": "Noakhali"
    },
    {
      "id": 3,
      "name": "Dhaka"
    },
    {
      "id": 4,
      "name": "Rajshahi"
    },
    {
      "id": 5,
      "name": "Chittagong"
    }
  ],
  "arr": [
    1,
    2,
    3,
    4
  ]
}
```
</details>

### Examples

- [x] Initialization,
```kotlin
val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream("data.json")
jsonq = JSONQ(inputStream)
```

- [x] find,
```kotlin
val obj = jsonq.find("users.5.visits")
```
Result,
```json
[
  {
    "name": "Sylhet",
    "year": 2011
  },
  {
    "name": "Cox's Bazar",
    "year": 2012
  },
  {
    "name": "Bandarbar",
    "year": 2014
  }
]
```

- [x] whereEq,
```kotlin
val res = jsonq.from("users.5.visits").whereEq("name", "Bandarbar")
```
Result,
```json
[
  {
    "name": "Bandarbar",
    "year": 2014
  }
]
```

- [x] hasSuffix,
```kotlin
val res = jsonq.from("users").hasSuffix("name", "Sumi")
```
Result,
```json
[
  {
    "id": 1,
    "name": "Johura Akter Sumi",
    "location": "Barisal"
  }
]
```

- [x] Query Chaining
```kotlin
val res = jsonq.from("users").whereGe("id", 3).whereEq("location", "Barisal").contains("name", "Is")
```
Result,
```json
[
  {
    "id": 3,
    "name": "Ariful Islam",
    "location": "Barisal"
  }
]
```

## TODO

- [ ] Add missing methods
- [ ] Write full documentation with example

## Bugs and Issues

If you encounter any bugs or issues, feel free to [open an issue at
github](https://github.com/s4kibs4mi/kotlin-jsonq/issues).

Also, you can shoot me an email to
<mailto:root@sakib.ninja> for hugs or bugs.

## Special Mention

[Nahid Bin Azhar](https://github.com/nahid) for the original idea.

## Contribution
If you are interested to make the package better please send pull requests or create an issue so that others can fix.
[Read the contribution guide here](CONTRIBUTING.md)

## See all [contributors](https://github.com/s4kibs4mi/kotlin-jsonq/graphs/contributors)
