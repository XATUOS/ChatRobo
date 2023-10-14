package dev.xatuos.chatrobo.api.util;

public interface IVersion {
    int getMajor();
    int getMinor();
    int getPatch();
    int getPreRelease();
    int getBuild();
}
