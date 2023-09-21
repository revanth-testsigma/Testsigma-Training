import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LogEntry {
    private int id;
    private String message;
    private int errorCode;

    public LogEntry(int id, String message, int errorCode) {
        this.id = id;
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}

public class Logread{
    public static void main(String[] args) {
        String logFilePath = "logfile.log";
        List<LogEntry> logEntries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] logComponents = line.split(";");
                if (logComponents.length == 3) {
                    int id = Integer.parseInt(logComponents[0].trim());
                    String message = logComponents[1].trim();
                    int errorCode = Integer.parseInt(logComponents[2].trim());
                    LogEntry logEntry = new LogEntry(id, message, errorCode);
                    logEntries.add(logEntry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry);
        }
    }
}
