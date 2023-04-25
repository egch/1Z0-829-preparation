# Building Blocks


java directly on .java file, no need to call javac.
```shell
$ java HelloWorld.java
```
## packages
From project root folder
```shell
$ javac  -d target/classes  ./src/main/java/org/enricogiurin/ocp17/ch1/*.java

$ java -cp target/classes org.enricogiurin.ocp17.ch1.HelloWorld
```
We have to specify all the single packages if present.

### Alternative cp
```shell
$ java -cp target/classes org.enricogiurin.ocp17.ch1.HelloWorld
$ java -classpath target/classes org.enricogiurin.ocp17.ch1.HelloWorld
$ java --class-path target/classes org.enricogiurin.ocp17.ch1.HelloWorld
```