public class Organizer {
  private String mAlbum;
  private String mGenre;

  public Organizer(String album, String genre) {
    mAlbum = album;
    mGenre = genre;
  }

  public String getAlbum(){
    return mAlbum;
  }

  public String getGenre(){
    return mGenre;
  }
}
