# At First
> 基于官方的 2.10.5 版本集成了 spring-framework 5.3.18 
>
> 解决 swagger (springfox) 在高版本的 springboot(依赖了高版本的 spring-framework)上集成失败的问题


> 如果你仅仅扫描需要有 `@Controller` 和 `@RequestMapping` 注解的类，以生成 swagger 文档，你可以使用[branch v2.11.0](https://github.com/uwoerla/springfox/tree/v2.11.0) base on [branch v2.10.5](https://github.com/uwoerla/springfox/tree/v2.10.5) ，这个分支对源代码的更改量比较小。

> 如果你需要扫描有 @Controller 和 @RequestMapping 注解的类，同时需要扫描有 @Endpoint等注解的类，以生成 swagger 文档， 你可以使用[branch v2.12.0](https://github.com/uwoerla/springfox/tree/v2.12.0) base on [branch v2.10.5](https://github.com/uwoerla/springfox/tree/v2.10.5) ，但是这个分支对源代码的更改稍微有点大。

## Update Version Number
```
vim /springfox/.version
```

## Install Snapshot To Maven
> about `-P` see dir `buildSrc`
```
# Local
gradle publishToMavenLocal -PbuildNumberFormat=-SNAPSHOT
```
## Install Release To Maven Local
> about `-P` see dir `buildSrc`
```
# Local
gradle publishToMavenLocal -PbuildNumberFormat=
```

# Springfox

[![Join the chat at https://gitter.im/springfox/springfox](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/springfox/springfox?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fspringfox%2Fspringfox.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Fspringfox%2Fspringfox?ref=badge_shield)
[ ![Download](https://api.bintray.com/packages/springfox/maven-repo/springfox/images/download.svg) ](https://bintray.com/springfox/maven-repo/springfox/_latestVersion) 
[![Project Stats](https://www.openhub.net/p/springfox/widgets/project_thin_badge.gif)](https://www.openhub.net/p/springfox)

| Build Status  | Coverage   | Code Analysis |
|---|---|---|
|[![Circle CI](https://circleci.com/gh/springfox/springfox/tree/master.svg?style=svg)](https://circleci.com/gh/springfox/springfox/tree/master)|[![codecov](https://codecov.io/gh/springfox/springfox/branch/master/graph/badge.svg)](https://codecov.io/gh/springfox/springfox) |[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=springfox_springfox&metric=alert_status)](https://sonarcloud.io/dashboard?id=springfox_springfox)|

| Sonar Cloud |
|------------ |
|[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=springfox_springfox&metric=security_rating)](https://sonarcloud.io/dashboard?id=springfox_springfox)|
|[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=springfox_springfox&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=springfox_springfox)|
|[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=springfox_springfox&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=springfox_springfox)|
|[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=springfox_springfox&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=springfox_springfox)|
|[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=springfox_springfox&metric=sqale_index)](https://sonarcloud.io/dashboard?id=springfox_springfox)|
|[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=springfox_springfox&metric=coverage)](https://sonarcloud.io/dashboard?id=springfox_springfox)|

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

### Getting Started

#### For new projects
For Maven
```xml 
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>

```

For Gradle
```gradle 
  implementation "io.springfox:springfox-boot-starter:<version>"
```
#### Migrating from earlier snapshot 
#### Spring Boot Applications
NOTE: Would love feedback to make this better
1. Remove explicit dependencies on `springfox-swagger2`
2. Remove any `@EnableSwagger2...` annotations
3. Add the `springfox-boot-starter` dependency
4. Springfox 3.x removes dependencies on guava and other 3rd party libraries (not zero dep yet! depends on spring plugin
and open api libraries for annotations and models) so if you used guava predicates/functions those will need to 
transition to java 8 function interfaces.

#### Migrating from existing 2.x version
#### Spring Boot Applications
NOTE: Would love feedback to make this better
1. Remove explicit dependencies on `springfox-swagger2`
2. Remove the `@EnableSwagger2` annotations
3. Add the `springfox-boot-starter` dependency
4. Springfox 3.x removes dependencies on guava and other 3rd party libraries (not zero dep yet! depends on spring plugin
and open api libraries for annotations and models) so if you used guava predicates/functions those will need to 
transition to java 8 function interfaces 
5. If you are using WebMvc but you don't use the [`@EnableWebMvc`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/config/annotation/EnableWebMvc.html) annotation yet, add this annotation.

#### Regular spring mvc  
NOTE: Would love feedback to make this experience better
1. Remove explicit dependencies on `springfox-swagger2`
2. Add `@EnableOpenApi` for open API (and `@EnableSwagger2WebMvc` or `@EnableSwagger2WebFlux` for older versions)  
3. Added the `springfox-oas` library 
4. Springfox 3.x removes dependencies on guava and other 3rd party libraries (not zero dep yet! depends on spring plugin
and open api libraries for annotations and models) so if you used guava predicates/functions those will need to 
transition to java 8 function interfaces 


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
