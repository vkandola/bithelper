package me.vkandola;

import me.vkandola.generator.*;
import org.apache.commons.cli.*;

public class Main {
    private static final String PROGRAM_NAME = "bithelper";

    // Option constant defines
    private static final String OPT_XOR_TABLE = "xt";
    private static final String OPT_RANGE_START = "rs";
    private static final String OPT_RANGE_END = "re";
    private static final String OPT_BITSHIFT = "bs";
    private static final String OPT_STEP_SIZE = "st";
    private static final String OPT_XOR_MASK = "m";
    private static final String OPT_QUIZ_BINARY = "qb";
    private static final String OPT_QUIZ_HEX = "qh";
    private static final String OPT_SILENT = "s";
    private static final String OPT_FILE = "f";
    private static final String OPT_VERBOSE = "v";
    private static final String OPT_HELP = "h";

    private static Options opts; // The command line options.

    /**
     * Generates the command line options usable.
     *
     * @return The generated Options object.
     */
    private static Options getOpts() {
        if (opts == null) {
            opts = new Options();

            opts.addOption(OPT_XOR_TABLE, false, "Generate a XOR table.");
            opts.addOption(OPT_RANGE_START, true, "Starting range for iterated values.");
            opts.addOption(OPT_RANGE_END, true, "Ending range for iterated values.");
            opts.addOption(OPT_BITSHIFT, true, "Number of places to bit shift the iterated values.");
            opts.addOption(OPT_STEP_SIZE, true, "Step size for range iteration.");
            opts.addOption(OPT_XOR_MASK, true, "Inputted XOR mask to use.");
            opts.addOption(OPT_QUIZ_BINARY, false, "Begin a binary quiz game.");
            opts.addOption(OPT_QUIZ_HEX, false, "Begin a hex quiz game.");
            //opts.addOption(OPT_SILENT, false, "Suppress standard out printing (useful if printing to file instead).");
            // See comment for file option below.
            //opts.addOption(OPT_FILE, true, "Print results to file.");
            // Maybe just verify we're Pipe-friendly (using STDOUT/STDERR nicely) instead of adding file output support.
            //opts.addOption(OPT_VERBOSE, true, "Enable verbose logging.");
            //opts.addOption(OPT_HELP, false, "Display more information about usage.");
        }

        return opts;
    }

    /**
     * Displays the usage of the command line and exits the system.
     */
    private static void displayHelpAndExit() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(PROGRAM_NAME, getOpts());
        System.exit(1);
    }

    /**
     * Signed integer parser helper (TODO: handle multiple input representations).
     *
     * @param str String representation of an unsigned integer.
     * @return Returns the java.lang.Integer representation of the string.
     */
    private static Integer parseUnsignedInteger(String str) {
        return Integer.parseUnsignedInt(str);
    }

    /**
     * Signed integer parser helper (TODO: handle multiple input representations).
     *
     * @param str String representation of a signed integer.
     * @return Returns the java.lang.Integer representation of the string.
     */
    private static Integer parseSignedInteger(String str) {
        return Integer.parseInt(str);
    }

    /**
     * Helper to handle displaying tables.
     *
     * @param cmd The command line passed into the program.
     */
    private static void displayTable(CommandLine cmd) {
        TableGenerator tg = null;

        if (cmd.hasOption(OPT_XOR_TABLE)) {
            XORTableGeneratorBuilder tgb = new XORTableGeneratorBuilder();

            try {
                if (cmd.hasOption(OPT_XOR_MASK)) {
                    tgb.withXORMask(parseUnsignedInteger(cmd.getOptionValue(OPT_XOR_MASK)));
                }
                if (cmd.hasOption(OPT_RANGE_START)) {
                    tgb.withRangeStart(parseSignedInteger(cmd.getOptionValue(OPT_RANGE_START)));
                }
                if (cmd.hasOption(OPT_RANGE_END)) {
                    tgb.withRangeEnd(parseSignedInteger(cmd.getOptionValue(OPT_RANGE_END)));
                }
                if (cmd.hasOption(OPT_STEP_SIZE)) {
                    tgb.withStepSize(parseSignedInteger(cmd.getOptionValue(OPT_STEP_SIZE)));
                }
                if (cmd.hasOption(OPT_BITSHIFT)) {
                    tgb.withBitShift(parseSignedInteger(cmd.getOptionValue(OPT_BITSHIFT)));
                }
            } catch (NumberFormatException nfe) {
                displayHelpAndExit();
            }

            tg = tgb.build();
        } else {
            displayHelpAndExit();
        }


        tg.generate();
    }


    /**
     * Helper to handle displaying quizzes.
     *
     * @param cmd The command line passed into the program.
     */
    private static void displayQuiz(CommandLine cmd) {
        QuizGenerator qg = null;

        if (cmd.hasOption(OPT_QUIZ_BINARY)) {
            qg = new BinaryQuizGenerator();
        } else if (cmd.hasOption(OPT_QUIZ_HEX)) {
            qg = new HexQuizGenerator();
        } else {
            displayHelpAndExit();
        }

        Question generatedQuestion = qg.generate();
        qg.askQuestion(generatedQuestion);
    }

    /**
     * Entrypoint into the bithelper program.
     *
     * @param args Command line arguments to parse.
     */
    public static void main(String[] args) {

        // Parse and interpret CLI arguments.
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(getOpts(), args);
        } catch (ParseException pe) {
            displayHelpAndExit();
        }

        boolean hasHelp = cmd.hasOption(OPT_HELP);
        boolean hasTableOption = cmd.hasOption(OPT_XOR_TABLE);
        boolean hasQuizOption = cmd.hasOption(OPT_QUIZ_BINARY) || cmd.hasOption(OPT_QUIZ_HEX);

        if (hasHelp || !(hasTableOption || hasQuizOption)) {
            displayHelpAndExit();
        }

        if (hasTableOption) {
            displayTable(cmd);
        } else if (hasQuizOption) {
            displayQuiz(cmd);
        } else {
            displayHelpAndExit();
        }

        System.exit(0);
    }
}
