# zhihuDaily-sdk
[![Build Status](https://travis-ci.org/ndrlslz/zhihuDaily-sdk.svg?branch=master)](https://travis-ci.org/ndrlslz/zhihuDaily-sdk)
[![codecov](https://codecov.io/gh/ndrlslz/zhihuDaily-sdk/branch/master/graph/badge.svg)](https://codecov.io/gh/ndrlslz/zhihuDaily-sdk)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ndrlslz/zhihuDaily-sdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ndrlslz/zhihuDaily-sdk)

This is a Java SDK for zhihuDaily

# Quick Start
Firstly, get client by invoking `ZhihuDailyClient.create()`
```
ZhihuDaily zhihuDaily = ZhihuDailyClient.create();
```

You can use the client to call API with `synchronous` and `asynchronous` way.

To do a synchronous call, you need to invoke `execute()`.
```
DailyNews dailyNews = zhihuDaily.getLatestNews().execute();
dailyNews.getStories().forEach(System.out::println);
```

To do a asynchronous call, you need to invoke `enqueue()`
```
zhihuDaily.getLatestNews().enqueue(new ServiceCallback<DailyNews>() {
    @Override
    public void onResponse(DailyNews object) {
        object.getStories().forEach(System.out::println);
    }

    @Override
    public void onFailure(HttpException exception) {
        System.out.println(exception.getMessage());
    }
});
```

# Example
You can find more examples from here: [examples](https://github.com/ndrlslz/zhihuDaily-sdk/blob/master/zhihuDaily-java-examples/src/main/java/com/github/ndrlslz/Examples.java)

# Installation

**Maven**:
```
<dependency>
    <groupId>com.github.ndrlslz</groupId>
    <artifactId>zhihuDaily-java-client</artifactId>
    <version>0.1.2</version>
</dependency
```

**Gradle**:
```
compile 'com.github.ndrlslz:zhihuDaily-java-client:0.1.2'
```

