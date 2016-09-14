import java.util.List;
import java.util.ArrayList;

public class Artist{
  private String mName;
  private static List<Artist> instances = new ArrayList<Artist>();
  private List<Organizer> mCDs;
  private int mID;

  public Artist(String name){
    mName = name;
    mCDs = new ArrayList<Organizer>();
    instances.add(this);
    mID = instances.size();
  }

  public String getName(){
    return mName;
  }

  public void addCD(Organizer cd){
    mCDs.add(cd);
  }

  public static Artist find(int id){
    return instances.get(id - 1);
  }

  public static List<Artist> all(){
    return instances;
  }

  public static void clear(){
    instances.clear();
  }

  public int getID(){
    return mID;
  }

  public List<Organizer> getCD(){
    return mCDs;
  }
  
}
