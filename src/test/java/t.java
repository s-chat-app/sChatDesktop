import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

public class t {
    public static void main(String[] args) {
        // 转化包路径为文件路径
        // 扫描
        ClassLoader classLoader = t.class.getClassLoader();
        URL resource = classLoader.getResource("");
        Set<String> fileNameSet = new LinkedHashSet<>();
        String path = resource.getFile();
        if (path.contains("!")) {
            System.out.println(path.substring(5, path.indexOf("!")));
        }
        System.out.println(path);

    }
}
