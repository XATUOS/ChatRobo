import dev.xatuos.chatrobo.api.util.IVersion;
import dev.xatuos.chatrobo.util.Version;

import java.util.regex.Pattern;

public class VersionTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^(\\d+)(\\.(\\d+)(\\.(\\d+))?)?$");
        System.out.println(pattern.matcher("1.0.0-release.1+build.10").find());
        System.out.println(pattern.matcher("1.0.0-release.1").find());
        System.out.println(pattern.matcher("1.0.0+build.10").find());
        System.out.println(pattern.matcher("1.0.0").find());
        System.out.println(pattern.matcher("1.0").find());
        System.out.println(pattern.matcher("1").find());
        pattern = Pattern.compile("^(\\d+)(\\.(\\d+)(\\.(\\d+))?)?(-release\\.\\d+)?(\\+build\\.\\d+)?$");
        System.out.println(pattern.matcher("1.0.0-release.1+build.10").find());
        System.out.println(pattern.matcher("1.0.0-release.1").find());
        System.out.println(pattern.matcher("1.0.0+build.10").find());
        System.out.println(pattern.matcher("1.0.0").find());
        System.out.println(pattern.matcher("1.0").find());
        System.out.println(pattern.matcher("1").find());
        System.out.println(Version.parse("1.0.0-release.1+build.10"));
        System.out.println(Version.parse("1.0.0-release.1"));
        System.out.println(Version.parse("1.0.0+build.10"));
        System.out.println(Version.parse("1.0.0"));
        System.out.println(Version.parse("1.0"));
        System.out.println(Version.parse("1"));
    }
}
