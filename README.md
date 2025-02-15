# Branch v2.11.0
> 基于官方的 2.10.5 版本集成了 spring-framework 5.3.18 
>
> 解决 swagger (springfox) 在高版本的 springboot(依赖了高版本的 spring-framework)上集成失败的问题
>
> 这个 feature 分支仅仅扫描有 `@Controller` 和 `@RequestMapping` 注解的类，以生成 swagger 文档
>
> see [branch v2.11.0](https://github.com/uwoerla/springfox/tree/v2.11.0) base on [branch v2.10.5](https://github.com/uwoerla/springfox/tree/v2.10.5)

# Use Demo
使用 ANT_PATH_MATCHER 作为 spring mvc path match 的策略
```
spring:
  mvc:
    pathmatch:
      matching-strategy: ANT_PATH_MATCHER
```
> see more [demo](https://github.com/uwoerla/app-with-swagger-docs-demo/tree/springboot-2.6.6-springfox-2.11.0)

## Update Version Number
```
vim /springfox/.version
```

## Install Snapshot To Maven
> about `-P` see dir `buildSrc`
```
# Local
./gradlew clean publishToMavenLocal -PbuildNumberFormat=-SNAPSHOT

# Nexus
./gradlew clean publish -PbuildNumberFormat=-SNAPSHOT
```
## Install Release To Maven
> about `-P` see dir `buildSrc`
```
# Local
./gradlew clean publishToMavenLocal -PbuildNumberFormat=

# Nexus
./gradlew clean publish -PbuildNumberFormat=
```

# Springfox

[![Join the chat at https://gitter.im/springfox/springfox](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/springfox/springfox?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fspringfox%2Fspringfox.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Fspringfox%2Fspringfox?ref=badge_shield)
[ ![Download](https://api.bintray.com/packages/springfox/maven-repo/springfox/images/download.svg) ](https://bintray.com/springfox/maven-repo/springfox/_latestVersion) 
[![Project Stats](https://www.openhub.net/p/springfox/widgets/project_thin_badge.gif)](https://www.openhub.net/p/springfox)
[![Stories in Ready](https://badge.waffle.io/springfox/springfox.png?label=in%20progress&title=In%20Progress)](https://waffle.io/springfox/springfox)

| Build Status  | Coverage   |
|---|---|
|[![Circle CI](https://circleci.com/gh/springfox/springfox/tree/master.svg?style=svg)](https://circleci.com/gh/springfox/springfox/tree/master)|[![codecov](https://codecov.io/gh/springfox/springfox/branch/master/graph/badge.svg)](https://codecov.io/gh/springfox/springfox) |

### About
For more information on this project visit the [Springfox Website](http://springfox.io) or
 [http://springfox.github.io/springfox/](http://springfox.github.io/springfox/)

### Useful links
- [Reference Documentation](http://springfox.io)
- [Examples repository](https://github.com/springfox/springfox-demos)
- [Contribution Guidelines](https://github.com/springfox/springfox/wiki/Contribution-guidelines)
- [Core contributors](http://springfox.github.io/springfox/contributors.html)
- [Development and contribution guidelines](https://github.com/martypitt/swagger-springmvc/wiki/Development)
- [Change log](docs/release-notes.md)
- [Development Environment](http://springfox.github.io/springfox/docs/current/#development-environment)
- [Release Instructions](http://springfox.github.io/springfox/docs/current/#releasing)

## Transitioning to 2.x
Here is [some preliminary documentation](docs/transitioning-to-v2.md) to help transition to 2.x

License
-------

Copyright 2015 Marty Pitt - [@martypitt](https://github.com/martypitt), Dilip Krishnan - [@dilipkrish](https://github.com/dilipkrish),
Adrian Kelly -  [@adrianbk](https://github.com/adrianbk),

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at [apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fspringfox%2Fspringfox.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fspringfox%2Fspringfox?ref=badge_large)