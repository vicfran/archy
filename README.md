# archy [![Build Status](https://travis-ci.com/vicfran/archy.svg?branch=dev)](https://travis-ci.com/vicfran/archy) [![Release](https://jitpack.io/v/vicfran/archy.svg)](https://jitpack.io/#vicfran/archy)
archy is a lightweight library which uses [kotlin extension functions](https://kotlinlang.org/docs/reference/extensions.html) to make the use of [Realm](https://realm.io/) more easy and secure, and fun!

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
  implementation 'com.github.vicfran:archy:v0.1.0-alpha'
}
```
