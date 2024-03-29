README.txt

This is an example of a few common things that you'll run into when developing
software packaged together with a simple strategy implementation, so you can see
what that's about.

First, this is built using Gradle. Most real software projects use some sort of
build system to perform all the tasks necessary for building software. There are
several build systems for Java with their own advantages and disadvantages and I
went with the most common build system that doesn't use XML. This also makes it
easier to include actual libraries, so I've included one for a demonstration of
the pipe-and-filter architecture.

Second, this uses JUnit to perform automated tests. I've included a couple of
classes that test two of the three strategies that I've included. One of these
has a broken test case that needs to be fixed to work properly.

I have also included a demonstration of three different design patterns as found
in Java 17's new java.util.random package. These are worth looking at to
understand how these patterns are used in practice instead of the theoretical
"Just use them wherever" that the slides give the impression of.

Finally, this has a very basic demonstration of the strategy design pattern.
There are three different strategies for turning a String into an OptionalInt
that are tried in turn. The strategies all implement the ParserStrategy
interface and are called by the StrategyDemonstration class.

ELEMENTS

*   edu.semo.cs445.factorymethod -- A work in progress demonstration of how the
    Factory Method design pattern can be used
*   edu.semo.cs445.pipefilter -- A small demonstration of a program fitting the
	pipe-and-filter architecture
*   edu.semo.cs445.rng -- A demonstration of the various design patterns that
	the java.util.random classes implement.
*   edu.semo.cs445.strategy -- A demonstration of the strategy pattern, part of
	homework HW4. Also includes some JUnit tests.
*   edu.semo.cs445.junit -- A demonstration of some basics of the JUnit testing
	framework.

STEPS

1. Have a recent version of the JDK installed, at least 17. There's more recent
   ones out but this will do for our purposes. If you have an older version
   installed for another class, you can have multiple versions installed but
   will need to set the JAVA_HOME environment variable for your computer. There
   are existing tutorials for how to set it depending on the operating system
   you use.
2. Take a look through the directory structure of the project. The project root
   contains the build file "build.gradle.kts" and a pair of gradle wrappers that
   allow the project to be built without Gradle installed. These are "gradlew"
   and "gradlew.bat". There's also a "src" directory with "main" and "test"
   underneath it. These are the source directories for the project. I've left
   some other directories that aren't strictly necessary but demonstrate the
   "standard" directory structure for the project.
3. Open the command line at the root directory of the project. This is the
   directory containing gradlew and gradlew.bat. If you're on Windows the next
   steps will involve gradlew.bat while on Linux or macOS you will be executing
   ./gradlew for the commands.
4. Run "./gradlew tasks" or "gradlew.bat tasks" to get a list of tasks that can
   be run by gradle. It'll take a while to run the first time since it's getting
   the dependencies. This gives a list of all the tasks that can be run.
5. Run "./gradlew test" to run the unit tests. One of the tests will fail and it
   will give information related to where it failed. Try and find the error and
   fix it.
6. Open the project in IntelliJ IDEA if you have it installed to see how the
   project looks in there.
