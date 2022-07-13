import java.util.HashMap;
// ინტერფეისი რომელშიც გვაქვს 2 მეთოდი, პირველი აბრუნებს ჰეშმეპს სტრინგის და ვიდეო კლასის,
// მეორე აბრუნებს ვიდეო კლასის ობიექტს და გადაეცემა ვიდეოს აიდი.
public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();
    Video getVideo(String videoId);
}
