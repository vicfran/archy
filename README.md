# archy
Realm extensions written in Kotlin

[![Build Status](https://travis-ci.com/vicfran/archy.svg?branch=dev)](https://travis-ci.com/vicfran/archy)

## Using alpha versions

If you are brave enough to follow alpha development of archy that has not been packaged in an official release yet, you can use a **-alpha** release of the current development version of archy via Gradle, available on [JitPack](https://jitpack.io/#vicfran/archy)

```
allprojects {
  repositories {
    google()
    jcenter()
    maven { url "https://jitpack.io" }
  }
}

dependencies {
  implementation 'com.github.vicfran:archy:v0.1.0-alpha'
}
```
