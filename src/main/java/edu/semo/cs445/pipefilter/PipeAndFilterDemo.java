package edu.semo.cs445.pipefilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.cli.*;

/**
 * This is hopefully a very straightforward sort of architecture. You have a
 * stream of data (usually text) flowing in, your program processes the text and
 * sends another stream of data out the other side. These streams are called the
 * input stream and output stream conveniently in Java. There's a third stream
 * called the error stream that's written to whenever there's some sort of
 * data that you want communicated but don't want to muck up the output data.
 * <br/><br/>
 * Basically this is all something that if you've taken introductory programming
 * you've seen before, there's just conventions on what and when to do stuff.
 * There's also some code that is done more the way that a professional Java dev
 * would than a teacher would and I try to add explanatory comments where needed.
 *
 */
public class PipeAndFilterDemo {
	/**
	 * This is an object that holds the configuration of the options that are
	 * available to users. This object is used both by a CommandLineParser to
	 * parse the line containing the options and a HelpFormatter to print a help
	 * message.
	 * <br/><br/>
	 * The options are built using a builder which allows for complex configuration
	 * during object construction. This is a full design pattern which you can read
	 * about online but for our purposes, it's a way to construct object instances
	 * without needing big constructor methods with a dozen or more parameters.
	 * <br/><br/>
	 * This also uses a pattern called method chaining to allow for a more compact
	 * writing of the options. Notice that each addOption() call returns the
	 * original options object so that we can call addOption() immediately again
	 * or simply assign the options object itself to the variable. Each builder
	 * call like longOpt(), desc() or hasArg() returns the builder while build()
	 * returns the built option. I recommend looking at this in an editor like
	 * IntelliJ IDEA to see what's actually going on. It's admittedly really opaque
	 * at first but once it clicks it's as easy to read as the conventional way.
	 */
	private static final Options options = new Options()
			.addOption(Option.builder("d")
					.longOpt("duplicate")
					.desc("Prints each line input to output twice.")
					.hasArg(false)
					.build())
//			.addOption(Option.builder("r")
//					.longOpt("random")
//					.desc("Prints the lines from the input to the output in somewhat random order.")
//					.hasArg(false)
//					.build())
			.addOption(Option.builder("h")
					.longOpt("help")
					.desc("Prints this help text")
					.hasArg(false)
					.build())
			;

	/**
	 * We're actually going to do something with the args for once! Since we're
	 * not directly interacting with the user, the way to specify what the program
	 * should do exactly. For example with the "ls" Unix utility, passing in
	 * "ls -a" prints all the hidden files as well as the regular files in the
	 * directory. We use a library for argument parsing because it's simpler and
	 * more straightforward than getting parsing right on our own.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine commandLine = parser.parse(options, args);
			// Generally there's a help flag which just prints the help like so
			boolean printHelp = commandLine.hasOption("h");
			if (printHelp) {
				printHelp();
				return;
			}
			boolean duplicate = commandLine.hasOption("d");
			processStream(duplicate);
		} catch (IOException e) {
			// This prints all the information needed to debug a thrown exception
			// We are treating this type of exception differently from an options
			// ParseException because this isn't normally caused by user actions
			e.printStackTrace();
		} catch (ParseException e) {
			// Note that any error messages go to the error stream so they don't
			// get mixed in with the data being processed
			System.err.println(e.getMessage());
			printHelp();
		}
	}

	private static void processStream(boolean duplicate) throws IOException {

		// This is called a try-with-resources. It's basically a try-catch-finally
		// block that automatically does the finally part for you.
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			String line = null;
			// This somewhat confusing while loop is the usual shorthand for reading
			// a line, checking whether it's null or not and then doing something if
			// it's not.
			// This also doesn't end until it encounters an EOF character. On the
			// command line that is produced using Control+D. In a file or stream, it's
			// just the character that signals it's the end of file (hence EOF)
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				// If duplicate we print the line a second time
				if (duplicate) {
					System.out.println(line);
				}
			}
		}
	}

	/**
	 * This is a helper method that simply prints out the help text for the
	 * program. The main thing that the method uses is an object called
	 * HelpFormatter which formats the help text. It's a good example of
	 * object-oriented design.
	 */
	private static void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(
				"demo",
				"Demonstrates the basics of what a pipe-and-filter application is structured like",
				options,
				"This is a footer",
				true);
	}
}
