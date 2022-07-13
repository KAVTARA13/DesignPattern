// მაგალითში მოცემული ვიდეო კლასი შევცვალეთ და
// გამოვიყენეთ ბილდერ პატერნი.
public class Video {
    public final String id;
    public final String title;
    public final String data;

    private Video(VideoBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.data = builder.data;
    }

    public static class VideoBuilder {
        private final String id;
        private final String title;
        private String data;

        public VideoBuilder(String id, String title){
            this.id = id;
            this.title = title;
            this.data = "Random video.";
        }

        public VideoBuilder data(String data){
            this.data = data;
            return this;
        }

        public Video build(){
            Video video = new Video(this);
            return video;
        }
    }
}