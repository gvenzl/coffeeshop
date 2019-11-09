package com.oracle;

public class Parameters {

    private static Integer threads=1;
    private static Integer waitSec=2;
    private static Integer batchSize=0;
    private static String  restURL="";
    private static String  jdbc="";
    private static String  username="";
    private static String  password="";
    private static String  database="";
    private static String  file="";
    private static String  credFile="";
    private static boolean historicData = false;
    private static boolean staticData = false;

    public static Integer getThreads() {
        return threads;
    }

    public static void setThreads(Integer threads) {
        Parameters.threads = threads;
    }

    public static Integer getWaitSec() {
        return waitSec;
    }

    public static void setWaitSec(Integer waitSec) {
        Parameters.waitSec = waitSec;
    }

    public static Integer getBatchSize() {
        return batchSize;
    }

    public static void setBatchSize(Integer batchSize) {
        Parameters.batchSize = batchSize;
    }

    public static String getRestURL() {
        return restURL;
    }

    public static void setRestURL(String restURL) {
        Parameters.restURL = restURL;
    }

    public static String getJdbc() {
        return jdbc;
    }

    public static void setJdbc(String jdbc) {
        Parameters.jdbc = jdbc;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Parameters.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Parameters.password = password;
    }

    public static String getDatabase() { return database; }

    public static void setDatabase(String database) { Parameters.database = database; }

    public static String getFile() {
        return file;
    }

    public static void setFile(String file) {
        Parameters.file = file;
    }

    public static String getCredFile() {
        return credFile;
    }

    public static void setCredFile(String credFile) {
        Parameters.credFile = credFile;
    }

    public static boolean isHistoricData() {
        return historicData;
    }

    public static void setHistoricData(boolean historicData) {
        Parameters.historicData = historicData;
    }

    public static boolean isStaticData() {
        return staticData;
    }

    public static void setStaticData(boolean staticData) {
        Parameters.staticData = staticData;
    }

    private static Parameters singleton = new Parameters();

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Parameters() { }

    public static Parameters getInstance( ) {
        return singleton;
    }


}
