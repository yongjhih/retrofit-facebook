# retrofit-facebook

[![JitPack](https://img.shields.io/github/tag/yongjhih/retrofit-facebook.svg?label=JitPack)](https://jitpack.io/#yongjhih/retrofit-facebook)
[![javadoc](https://img.shields.io/github/tag/yongjhih/retrofit-facebook.svg?label=javadoc)](https://jitpack.io/com/github/yongjhih/retrofit-facebook/-SNAPSHOT/javadoc/)
[![Build Status](https://travis-ci.org/yongjhih/retrofit-facebook.svg)](https://travis-ci.org/yongjhih/retrofit-facebook)
[![Join the chat at https://gitter.im/yongjhih/retrofit-facebook](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/yongjhih/retrofit-facebook?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Unofficial Graph facebook SDK.

## Usage

```java
Facebook facebook = Facebooks.create(token);

facebook.me().subscribe(me -> {
    System.out.println(me.name);
});
```

## Installation

Or via jitpack.io

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.yongjhih:retrofit-facebook:-SNAPSHOT'
}
```

## LICENSE

Copyright 2015 8tory, Inc.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
