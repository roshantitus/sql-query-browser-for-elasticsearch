# Sql Query Browser for Elasticsearch (Under development)

**sql-query-browser-for-elasticsearch** is a web based query tool for querying Elasticsearch using standard SQL syntax. 


## Features
**Browser-Based UI**
Sql Query Browser is entirely browser-based and securely connects to your data from anywhere in the world—with nothing to install on your system.

## Running Sql Query Browser for Elasticsearch locally

```
git clone https://github.com/roshantitus/sql-query-browser-for-elasticsearch.git
mvn jetty:run
```

You can then access query browser here: http://localhost:8080/query-tool/

## In case you find a bug/suggested improvement for Sql Query Browser for Elasticsearch

Our issue tracker is available here: 

```
https://github.com/roshantitus/sql-query-browser-for-elasticsearch/issues
```
## Working with Query Browser for Elasticsearch in Eclipse/STS

### Pre requisites:
The following items should be installed in your system:

* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/


### Steps:

1) In the command line

```
git clone https://github.com/roshantitus/sql-query-browser-for-elasticsearch.git
```

2) Inside Eclipse

```
File -> Import -> Maven -> Existing Maven project
```

## Interaction with other open source projects

The project uses [JSqlParser](https://github.com/JSQLParser/JSqlParser) as the undelying SQL parser. JSqlParser parses an SQL statement and translate it into a hierarchy of Java classes. The generated hierarchy is navigated using Visitor Pattern to generate Elasticsearch specific queries.
