import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.net.URL;
import java.nio.charset.Charset;

public class Main {
    private static String[] getEnviromentVarible() {
        var id = System.getenv("HATH_ID");
        var key = System.getenv("HATH_KEY");
        if (id == null || id.trim().length() == 0)
            throw new RuntimeException("HATH_ID not set.");
        if (key == null || key.trim().length() == 0)
            throw new RuntimeException("HATH_KEY not set.");
        return new String[] { id, key };
    }


    public static void main(String[] args) throws Exception{
        var array=getEnviromentVarible();
        var id=array[0];
        var key=array[1];

        var dir=new File("data");
        if(!dir.exists()){
            dir.mkdirs();
        }

        var confFile=new File(dir, "client_login");
        var outputStream=new FileOutputStream(confFile);
        outputStream.write((id + "-" + key).getBytes(Charset.defaultCharset()));
        outputStream.close();

        var jarFile=new File("HentaiAtHome.jar");
        var url=jarFile.toURI().toURL();
        var classLoader=new URLClassLoader(
            new URL[]{url},
            Main.class.getClassLoader()
        );
        var clazz=Class.forName("hath.base.HentaiAtHomeClient",true,classLoader);
        var method=clazz.getDeclaredMethod("main",String[].class);
        method.invoke(null,new Object[]{args});
    }
}