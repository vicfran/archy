# archy [![Build Status](https://travis-ci.com/vicfran/archy.svg?branch=dev)](https://travis-ci.com/vicfran/archy) [![Release](https://jitpack.io/v/vicfran/archy.svg)](https://jitpack.io/#vicfran/archy) [![codecov](https://codecov.io/gh/vicfran/archy/branch/dev/graph/badge.svg)](https://codecov.io/gh/vicfran/archy) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
archy is a lightweight library which uses [kotlin extension functions](https://kotlinlang.org/docs/reference/extensions.html) to make the use of [Realm](https://realm.io/) mobile database more easy and secure, and fun!

## Using alpha versions

If you are brave enough to follow alpha development of archy that has not been packaged in an official release yet, you can use a **-alpha** release of the current development version of archy via [Gradle](https://gradle.org/), available on [JitPack](https://jitpack.io/#vicfran/archy)

```
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
