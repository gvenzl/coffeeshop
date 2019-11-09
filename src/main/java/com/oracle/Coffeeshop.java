package com.oracle;

public class Coffeeshop {

    public static void main(String[] args) {

		if (args.length == 0) {
			printHelp();
			System.exit(1);
		}
		
		for (int i=0; i<args.length; i++) {
			if (args[i].equalsIgnoreCase("--threads")) {
				Parameters.setThreads(Integer.valueOf(args[++i]));
			}
			else if (args[i].equalsIgnoreCase("--wait")) {
				Parameters.setWaitSec(Integer.valueOf(args[++i]));
			}
			else if (args[i].equalsIgnoreCase("--url")) {
				Parameters.setRestURL(args[++i]);
			}
			else if (args[i].equalsIgnoreCase("--jdbc")) {
				Parameters.setJdbc(args[++i]);
			}
			else if (args[i].equalsIgnoreCase("--user")) {
				Parameters.setUsername(args[++i]);
			}
            else if (args[i].equalsIgnoreCase("--pwd")) {
				Parameters.setPassword(args[++i]);
            }
			else if (args[i].equalsIgnoreCase("--database")) {
				Parameters.setDatabase(args[++i]);
			}
            else if (args[i].equalsIgnoreCase("--batch")) {
				Parameters.setBatchSize(Integer.parseInt(args[++i]));
            }
			else if (args[i].equalsIgnoreCase("--file")) {
				Parameters.setFile(args[++i]);
			}
			else if (args[i].equalsIgnoreCase("--historic")) {
				Parameters.setHistoricData(true);
			}
			else if (args[i].equalsIgnoreCase("--static")) {
				Parameters.setStaticData(true);
			}
			else if (args[i].equalsIgnoreCase("--creds")) {
				Parameters.setCredFile(args[++i]);
			}
			else if (args[i].equalsIgnoreCase("--help") ||
					args[i].equalsIgnoreCase("-h") ||
					args[i].equalsIgnoreCase("-help")) {
				printHelp();
				System.exit(0);
			}
			else {
				printHelp();
				System.exit(1);
			}
		}

		new Coffeeshop().run();
	}
	
	public static void printHelp() {
		System.out.println("java -jar coffeeshop.jar --threads <n> --wait <n>sec --url <REST url> --jdbc <JDBC url> --historic");
		System.out.println("--threads <n>\t\tThe amount of concurrent sessions that should be used. [Default: 1]");
		System.out.println("--wait <n>\t\tThe amount of seconds that the program should pause between requests. [Default: 2]");
		System.out.println("--url <REST URL>\tThe REST URL to use for the rest call.");
		System.out.println("--jdbc <JDBC url>\tThe JDBC connection string to use for the inserts.");
        System.out.println("--creds <file path>\tPath to Oracle Cloud credential file (optional).");
		System.out.println("--user <username>\tThe JDBC user (only applicable for JDBC connection).");
		System.out.println("--pwd <password>\tThe JDBC password (only applicable for JDBC connection).");
		System.out.println("--database <database>\tThe database service name (only applicable for Cloud DB).");
		System.out.println("--batch <n>\tThe batch size to use (only applicable for JDBC connection).");
		System.out.println("--file <file name>\tThe file name for the data. This will write the data into a text file.");
		System.out.println("--historic\t\tLoads into historic table rather than active table (optional).");
		System.out.println("--static\t\tIncludes static data in the order to increase its size (optional).");
	}

	public void run() {
		new Generator().run();
	}

}
