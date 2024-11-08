package bg.bgjobs;

import app.entities.WebLink;
import bg.dao.BookMarkDao;
import bg.util.HttpConnect;
import bg.util.IOUtil;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WebpageDownloaderTask implements Runnable {

	
	private static BookMarkDao dao = new BookMarkDao ();
	private static  final  long TIME_FRAME = 3000000000L;
	private boolean downloadAll = false;
	
	ExecutorService downloaderExecutor = Executors.newFixedThreadPool (5);
	
	
	
	
	private static class Downloader<T extends WebLink> implements Callable<T> {
		private T weblink;
		public Downloader(T weblink) {
			this.weblink = weblink;
		}
		public T call() {
			try {
				if(!weblink.getUrl ().endsWith(".pdf")){
					weblink.setDownloadStatus ( WebLink.DownloadStatus.FAILED );
					String htmlPage = HttpConnect.download(weblink.getUrl());
					weblink.setHtmlPage(htmlPage);
				}
				else{
					weblink.setDownloadStatus ( WebLink.DownloadStatus.NOT_ELIGIBLE );
					
				
				
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return weblink;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public  WebpageDownloaderTask(boolean downloadAll){
		this.downloadAll = downloadAll;
	}
	
	
	@Override
	public void run () {
	
		while ( !Thread.currentThread ().isInterrupted () ){
			
			List< WebLink > webLinks = getWeblinks();
  	
			if(webLinks.size ()  >0 ){
				download(webLinks);
			}
			else {
				System.out.println ("No web links  to download!");
				break;
			}
			try {
				TimeUnit.SECONDS.sleep ( 15 );
			} catch (InterruptedException e) {
				throw new RuntimeException ( e );
			}
			
			
			
		}
		
		downloaderExecutor.shutdown ();
	
	
	}
	
	private void download(List <WebLink> weblinks ) {
		List<Downloader<WebLink>> tasks = getTasks(weblinks);
		List<Future<WebLink>> futures = new ArrayList<>();
		
		
		try {
			
			futures = downloaderExecutor.invokeAll(tasks, TIME_FRAME, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (Future<WebLink> future : futures) {
			try {
				if (!future.isCancelled()) {
					WebLink webLink = future.get ();
					String webpage = webLink.getHtmlPage ();
					if(webpage!= null){
						IOUtil.write ( webpage, webLink.getId ());
						webLink.setDownloadStatus ( WebLink.DownloadStatus.SUCCESS );
						System.out.println ("Download Success: " + webLink.getUrl ());
					}
					else {
						System.out.println ("Webpage not downloaded" + webLink.getUrl ());
					}
					
					
				} else {
					System.out.println("\n\nTask is cancelled --> " + Thread.currentThread());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
	}
	
	private List<Downloader<WebLink>> getTasks(List<WebLink> weblinks) {
		List<Downloader<WebLink>> tasks = new ArrayList<>();
		for (WebLink webLink : weblinks) {
			tasks.add(new Downloader<>(webLink));
		}
		return tasks;
	}

	
	
	private List<WebLink> getWeblinks () {
		List< WebLink > webLinks = null;
		if(downloadAll){
			webLinks = dao.getAllWeblinks (  );
			downloadAll = false;
			
		}
		else{
			webLinks = dao.getWeblinks ( WebLink.DownloadStatus.NOT_ATTEMPTED );
		}
		return webLinks;
	
	
	
	}
	
	
	
	
}
