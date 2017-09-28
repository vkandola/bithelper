package me.vkandola;

import me.vkandola.generator.TableGenerator;
import me.vkandola.generator.XORTableGeneratorBuilder;
import org.apache.commons.cli.*;

public class Main {
    private static final String PROGRAM_NAME = "bithelper";

    /**
     * Generates the command line options usable.
     *
     * @return The generated Options object.
     */
    private static Options setupOptions() {
        Options opts = new Options();

        // TODO - Implement these basic options
        opts.addOption("xt", false, "Generate a XOR table.");
        //opts.addOption("s", true, "Starting range for iterated values.");
        //opts.addOption("e", true, "Ending range for iterated values.");
        //opts.addOption("bs", true, "Number of places to bit shift the iterated values.");
        //opts.addOption("m", true, "Inputted XOR mask to use.");
        //opts.addOption("s", false, "Suppress standard out printing (useful if printing to file instead).");
        //opts.addOption("f", true, "Print results to file.");
        //opts.addOption("v", true, "Enable verbose logging.");
        //opts.addOption("h", false, "Display more information about usage.");

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

        boolean hasHelp = cmd.hasOption("h");
        boolean hasXORTable = cmd.hasOption("xt");

        if (hasHelp || !(hasXORTable)) {
            displayHelp(opts);
        }

        if (hasXORTable) {
            TableGenerator tg = new XORTableGeneratorBuilder()
                    .build();

            tg.generate();
            System.exit(0);
        }
    }
}
