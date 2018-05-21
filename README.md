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
You can start Query your data using the various query methods such as **Find**, **Where**, **OrWhere**, **WhereIn**, **WhereStartsWith**, **WhereEndsWith**, **WhereContains** and so on. Also you can aggregate your data after query using **Sum**, **Count**, **GroupBy**, **Max**, **Min** etc.

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
      "price": 150000
    },
    {
      "id": 3,
      "city": "dhk",
      "name": "Redmi 3S Prime",
      "cat": 1,
      "price": 12000
    },
    {
      "id": 4,
      "city": null,
      "name": "Redmi 4X",
      "cat": 1,
      "price": 15000
    },
    {
      "id": 5,
      "city": "bsl",
      "name": "macbook air",
      "cat": 2,
      "price": 110000
    },
    {
      "id": 6,
      "city": null,
      "name": "macbook air 1",
      "cat": 2,
      "price": 81000
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

**Example:**
```kotlin
val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream("data.json")
val jsonq = JSONQ(inputStream)
val name = jsonq.find("users.2.location")
```
**Output:**
```
Barishal
```

Let's explore the full API to see what else magic this library can do for you.
Shall we?

## API

Following API examples are shown based on the sample JSON data given above. To get a better idea of the examples see that JSON data first.

**List of API:**

* [JSONQ(json: JsonObject)](#)
* [File](#file)
* [JSONString](#jsonstring)
* [Reader](#reader)
* [Get](#get)
* [Find](#find)
* [From](#from)
* [Where](#wherekey-op-val)
* [OrWhere](#orwherekey-op-val)
* [WhereIn](#whereinkey-val)
* [WhereNotIn](#wherenotinkey-val)
* [WhereNil](#wherenilkey)
* [WhereNotNil](#wherenotnilkey)
* [WhereEqual](#whereequalkey)
* [WhereNotEqual](#wherenotequalkey)
* [WhereStartsWith](#wherestartswithkey-val)
* [WhereEndsWith](#whereendswithkey-val)
* [WhereContains](#wherecontainskey-val)
* [WhereStrictContains](#wherestrictcontainskey-val)
* [Sum](#sumproperty)
* [Count](#count)
* [Max](#maxproperty)
* [Min](#minproperty)
* [Avg](#avgproperty)
* [First](#first)
* [Last](#last)
* [Nth](#nthindex)
* [GroupBy](#groupbyproperty)
* [Sort](#sortorder)
* [Reset](#resetdata)
* [Only](#only)
* [Pluck](#pluck)

### `Get()`

This method will execute queries and will return the resulted data. You need to call it finally after using some query methods. Details can be found in other API examples.

### `Find(path)`

* `path` -- the path hierarchy of the data you want to find.

You don't need to call `Get()` method after this. Because this method will fetch and return the data by itself.

**caveat:** You can't chain further query methods after it. If you need that, you should use `From()` method.

**example:**

Let's say you want to get the value of _'items'_ property of your JSON Data. You can do it like this:


If you want to traverse to more deep in hierarchy, you can do it like:

### `From(path)`

* `path` (optional) -- the path hierarchy of the data you want to start query from.

By default, query would be started from the root of the JSON Data you've given. If you want to first move to a nested path hierarchy of the data from where you want to start your query, you would use this method. Skipping the `path` parameter or giving **'.'** as parameter will also start query from the root Data.

Difference between this method and `Find()` is that, `Find()` method will return the data from the given path hierarchy. On the other hand, this method will return the Object instance, so that you can further chain query methods after it.

**Example:**

Let's say you want to start query over the values of _'items'_ property of your Json Data. You can do it like this:


If you want to traverse to more deep in hierarchy, you can do it like:

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
