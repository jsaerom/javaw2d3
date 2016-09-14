import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest{

  @Test
  public void artist_instantiatesCorrectly_true(){
    Artist newArtist = new Artist("Bjork");
    assertEquals(true, newArtist instanceof Artist);
  }
}
