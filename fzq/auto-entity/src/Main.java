import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));

        for (String arg : args) {
            System.out.println("@Column(name = " + arg + ")");

            arg = arg.toLowerCase();
            final StringBuffer sb = new StringBuffer();
            Pattern p = Pattern.compile("_(\\w)");
            Matcher m = p.matcher(arg);
            while (m.find()){
                m.appendReplacement(sb,m.group(1).toUpperCase());
            }
            m.appendTail(sb);

            System.out.println("private String " + sb.toString() + ";");
            System.out.println();
        }

        System.out.println("Hello World!");
    }
}
