# archy [![Build Status](https://travis-ci.com/vicfran/archy.svg?branch=dev)](https://travis-ci.com/vicfran/archy) [![Release](https://jitpack.io/v/vicfran/archy.svg)](https://jitpack.io/#vicfran/archy) [![codecov](https://codecov.io/gh/vicfran/archy/branch/dev/graph/badge.svg)](https://codecov.io/gh/vicfran/archy) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
archy is a lightweight library which uses [kotlin extension functions](https://kotlinlang.org/docs/reference/extensions.html) to make the use of [Realm](https://realm.io/) mobile database more easy and secure, and fun!

It replaces **Realm** boilerplate providing a simple and robust scaffolding for you to build your persistence component inside your app.

Using **archy** makes the use of [Realm](https://realm.io/) as easy as never.

## Usage

Examples are based on following Realm data model :smiley_cat:, it extends **RealmObject** but your Realm entities can also implement **RealmModel** interface, works with both!:
``` kotlin
open class CatRealmObject(
    var name: String = "",
    var age: Float = 0f,
    var eyes: Int = 0,
    var isOld: Boolean = false): RealmObject()
```

At this moment, with **archy** you can do these Realm operations as easy as you can see:

#### create
``` kotlin
val aCat = CatRealmObject("Newton", 4.5f, 2, false)
aCat.save()

val otherCat = CatRealmObject("Turing", 5f, 2, false)
val oneMoreCat = CatRealmObject("Einstein", 7f, 2, true)
val cats = listOf(aCat, otherCat, oneMoreCat)
cats.save()
```

#### retrieve
``` kotlin
allOf<CatRealmObject>()
allOf<CatRealmObject>("eyes", 2)

firstOf<CatRealmObject>()
firstOf<CatRealmObject>("name", "Newton")
```

#### delete
``` kotlin
deleteAllFromRealm()
```

## Use of alpha versions
If you are brave enough to follow alpha development of archy that has not been packaged in an official release yet, you can use a **-alpha** release of the current development version of archy via [Gradle](https://gradle.org/), available on [JitPack](https://jitpack.io/#vicfran/archy)

```groovy
allprojects {
  repositories {
    google()
    jcenter()
    maven { url "https://jitpack.io" }
  }
}

dependencies {
  implementation 'com.github.vicfran:archy:vX.Y.Z-alpha'
}
```

## License

    MIT License

    Copyright (c) 2019 vicfran

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.