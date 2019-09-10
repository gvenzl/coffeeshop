package com.oracle;

public class Coffeeshop {

    private static Integer threads=1;
    private static Integer waitSec=2;
    private static Integer batchSize=0;
    private static String  restURL="";
    private static String  jdbc="";
    private static String  username="";
    private static String  password="";
    private static String  file="";
    private static String  credFile="";
    private static boolean historicData = false;


    public static void main(String[] args) {

		if (args.length == 0) {
			printHelp();
			System.exit(1);
		}
		
		for (int i=0; i<args.length; i++) {
			if (args[i].equalsIgnoreCase("--threads")) {
				threads = Integer.valueOf(args[++i]);
			}
			else if (args[i].equalsIgnoreCase("--wait")) {
				waitSec = Integer.valueOf(args[++i]);
			}
			else if (args[i].equalsIgnoreCase("--url")) {
				restURL = args[++i];
			}
			else if (args[i].equalsIgnoreCase("--jdbc")) {
				jdbc = args[++i];
			}
			else if (args[i].equalsIgnoreCase("--user")) {
				username = args[++i];
			}
            else if (args[i].equalsIgnoreCase("--pwd")) {
                password = args[++i];
            }
            else if (args[i].equalsIgnoreCase("--batch")) {
                batchSize = Integer.parseInt(args[++i]);
            }
			else if (args[i].equalsIgnoreCase("--file")) {
				file = args[++i];
			}
			else if (args[i].equalsIgnoreCase("--historic")) {
				historicData = true;
			}
			else if (args[i].equalsIgnoreCase("--creds")) {
				credFile = args[++i];
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
		System.out.println("--batch <n>\tThe batch size to use (only applicable for JDBC connection).");
		System.out.println("--file <file name>\tThe file name for the data. This will write the data into a text file.");
		System.out.println("--historic\t\tLoads into historic table rather than active table (optional).");
	}

	public void run() {
		Generator generator = new Generator(restURL, threads, waitSec, jdbc, username, password, file, batchSize,false, historicData, credFile);
		generator.run();
	}

}
