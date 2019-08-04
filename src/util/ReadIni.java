package util;

import dao.TypeDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadIni {

    private static Properties config = null;

    public static final String FILENAME = "config.ini";

    /**
     * se crea el constructor privado porque si no se crea ninguno, java automáticamente creará uno por defecto
     * público que puede ser instanciado, haciendolo así evitamos que esta clase se pueda instanciar
     */
    private ReadIni() {
        throw new IllegalStateException("Utility class");
    }

    private static void loadConfig(String filename) {
        if (config == null) {
            config = new Properties();
            try {
                config.load(new FileInputStream(filename));
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    public static TypeDAO getTypeDAO(String filename) {
        ReadIni.loadConfig(filename);

        switch (config.getProperty("dao")) {
            case "mysql": return TypeDAO.MYSQL;
            case "mssql": return TypeDAO.MSSQL;
            case "xml": return TypeDAO.XML;
            default: return TypeDAO.MYSQL;
        }
    }

    public static String getDbUser(String filename) {
        ReadIni.loadConfig(filename);

        return config.getProperty("user");
    }

    public static String getDbPassword(String filename) {
        ReadIni.loadConfig(filename);

        return config.getProperty("password");
    }

    public static String getDbName(String filename) {
        ReadIni.loadConfig(filename);

        return config.getProperty("database");
    }
}
