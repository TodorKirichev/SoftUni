package SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Music extends File {

    private String Artist;
    private String Album;

    public String getArtist() {
        return this.Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getAlbum() {
        return this.Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }
}
