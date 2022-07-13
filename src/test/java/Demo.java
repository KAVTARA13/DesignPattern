// თუ იუზერები ესტუმრებიან რამდენიმეჯერ იგივე გვერდს ჩვენ პროქსის პატერნით აწყობილი
// გვაქვს ქეში და მონაცემები უფრო სწრაფად დაბრუნდება ვიდრე სერვისიდან.

// YouTubeDownloader კლასი შევცვალე ისე რომ გამომეყენებინა Prototype პატერნი,
// თუმცა ამ მაგალითში დიდ მნიშვნელობას არ გვაძლევს რადგან კოპი მეთოდი ისევ თავიდან ქმნის ობიექტს ცვლილებების გარეშე.
public class Demo {
    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader();
        naiveDownloader.setApi(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = naiveDownloader.copy();
        smartDownloader.setApi(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}