package dev.xatuos.chatrobo.util;

import dev.xatuos.chatrobo.api.util.IVersion;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class Version implements IVersion, Comparable<IVersion> {
    private final int major;
    private final int minor;
    private final int patch;
    private final int preRelease;
    private final int build;

    public Version(int major, int minor, int patch, int preRelease, int build) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.preRelease = preRelease;
        this.build = build;
    }

    public Version(int major, int minor, int patch, int preRelease) {
        this(major, minor, patch, preRelease, 0);
    }

    public Version(int major, int minor, int patch) {
        this(major, minor, patch, 0, 0);
    }

    public Version(int major, int minor) {
        this(major, minor, 0, 0, 0);
    }

    public Version(int major) {
        this(major, 0, 0, 0, 0);
    }

    /**
     * 解析版本号
     * 示例： 1.0.0-release.0+build.0
     * 1.0.0+build.0
     * 1.0.0-release.0
     * 1.0.0
     *
     * @param version 版本号
     * @return 版本对象
     */
    public static Version parse(String version) {
        Pattern pattern = Pattern.compile("^(\\d+)(\\.(\\d+)(\\.(\\d+))?)?(-release\\.\\d+)?(\\+build\\.\\d+)?$");
        if (!pattern.matcher(version).find())
            throw new IllegalArgumentException("Invalid version: %s".formatted(version));
        String[] split = version.split("[+\\-]");
        String[] versionSplit = split[0].split("\\.");
        int major = Integer.parseInt(versionSplit[0]);
        int minor = versionSplit.length > 1 ? Integer.parseInt(versionSplit[1]) : 0;
        int patch = versionSplit.length > 2 ? Integer.parseInt(versionSplit[2]) : 0;
        int preRelease = split.length > 1 ? Integer.parseInt(split[1].split("\\.")[1]) : 0;
        int build = split.length > 2 ? Integer.parseInt(split[2].split("\\.")[1]) : 0;
        return new Version(major, minor, patch, preRelease, build);
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getPatch() {
        return patch;
    }

    public int getPreRelease() {
        return preRelease;
    }

    public int getBuild() {
        return build;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("%d.%d.%d".formatted(major, minor, patch));
        if (preRelease != 0)
            builder.append("-release.%d".formatted(preRelease));
        if (build != 0)
            builder.append("+build.%d".formatted(build));
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Version version) {
            return major == version.major && minor == version.minor && patch == version.patch && preRelease == version.preRelease && build == version.build;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return major ^ minor ^ patch ^ preRelease ^ build;
    }

    @Override
    public int compareTo(@NotNull IVersion o) {
        if (major != o.getMajor())
            return major - o.getMajor();
        if (minor != o.getMinor())
            return minor - o.getMinor();
        if (patch != o.getPatch())
            return patch - o.getPatch();
        if (preRelease != o.getPreRelease())
            return preRelease - o.getPreRelease();
        return build - o.getBuild();
    }
}
