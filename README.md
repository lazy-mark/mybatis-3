MYBATIS Data Mapper Framework
=============================

[![Build Status](https://travis-ci.org/mybatis/mybatis-3.svg?branch=master)](https://travis-ci.org/mybatis/mybatis-3)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis)
[![Apache 2](http://img.shields.io/badge/license-Apache%202-red.svg)](http://www.apache.org/licenses/LICENSE-2.0)

![mybatis](http://mybatis.github.io/images/mybatis-logo.png)

The MyBatis data mapper framework makes it easier to use a relational database with object-oriented applications.
MyBatis couples objects with stored procedures or SQL statements using a XML descriptor or annotations.
Simplicity is the biggest advantage of the MyBatis data mapper over object relational mapping tools.

Essentials
----------

* [See the docs](http://mybatis.github.io/mybatis-3)
* [Download Latest](https://github.com/mybatis/mybatis-3/releases)

基础功能包：为其它包提供一些外围基础功能，如文件读取功能，反射操作功能等。特点是功能相对独立，与业务耦合小。
<br>
其中exception、io、reflection、type、annotation、parsing、logging、lang包属于基础功能包。

<br>
配置解析包：用来完成配置解析、存储等工作。这些包中的方法主要在系统初始化阶段运行。
<br>
其中builder、mapping、binding、scripting、datasource包属于配置解析包。

<br/>
核心操作包：用来完成数据库操作，这些包可能会依赖基础功能包提供的基础功能和配置解析包提供的配置信息。
这些包中的方法主要在数据库操作阶段运行。
<br/>其中session、cache、executor、jdbc、cursor、transaction、plugin包数据核心操作包。

源码阅读顺序可从配置解析开始--->核心操作包.【对于中间使用到的基础功能包,再逐一分析,逐个击破】