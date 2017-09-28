package me.vkandola;

import me.vkandola.generator.TableGenerator;
import me.vkandola.generator.XORTableGeneratorBuilder;
import org.apache.commons.cli.*;

public class Main {
    private static final String PROGRAM_NAME = "bithelper";

    // Option constant defines
    private static final String OPT_XOR_TABLE = "xt";
    private static final String OPT_START_RANGE = "re";
    private static final String OPT_END_RANGE = "rs";
    private static final String OPT_BITSHIFT = "bs";
    private static final String OPT_XOR_MASK = "m";
    private static final String OPT_SILENT = "s";
    private static final String OPT_FILE = "f";
    private static final String OPT_VERBOSE = "v";
    private static final String OPT_HELP = "h";

    /**
     * Generates the command line options usable.
     *
     * @return The generated Options object.
     */
    private static Options setupOptions() {
        Options opts = new Options();

        // TODO - Implement these basic options
        opts.addOption(OPT_XOR_TABLE, false, "Generate a XOR table.");
        //opts.addOption(OPT_START_RANGE, true, "Starting range for iterated values.");
        //opts.addOption(OPT_END_RANGE, true, "Ending range for iterated values.");
        //opts.addOption(OPT_BITSHIFT, true, "Number of places to bit shift the iterated values.");
        opts.addOption(OPT_XOR_MASK, true, "Inputted XOR mask to use.");
        //opts.addOption(OPT_SILENT, false, "Suppress standard out printing (useful if printing to file instead).");
        //opts.addOption(OPT_FILE, true, "Print results to file.");
        //opts.addOption(OPT_VERBOSE, true, "Enable verbose logging.");
        //opts.addOption(OPT_HELP, false, "Display more information about usage.");

        return opts;
    }

    /**
     * Displays the usage of the command line and exits the system.
     *
     * @param opts The Options configured.
     */
    private static void displayHelp(Options opts) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(PROGRAM_NAME, opts);
        System.exit(1);
    }

    /**
     * Entrypoint into the bithelper program.
     *
     * @param args Command line arguments to parse.
     */
    public static void main(String[] args) {

        // Parse and interpret cli arguments.
        Options opts = setupOptions();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(opts, args);
        } catch (ParseException pe) {
            displayHelp(opts);
        }

        boolean hasHelp = cmd.hasOption(OPT_HELP);
        boolean hasXORTable = cmd.hasOption(OPT_XOR_TABLE);

        if (hasHelp || !(hasXORTable)) {
            displayHelp(opts);
        }

        TableGenerator tg = null;
        if (hasXORTable) {
            XORTableGeneratorBuilder tgb = new XORTableGeneratorBuilder();

            try {
                if (cmd.hasOption(OPT_XOR_MASK)) {
                    tgb.withXORMask(Integer.parseInt(cmd.getOptionValue(OPT_XOR_MASK)));
                }
            } catch (NumberFormatException nfe) {
                displayHelp(opts);
            }

            tg = tgb.build();
        } else {
            displayHelp(opts);
        }


        tg.generate();

        System.exit(0);
    }
}
