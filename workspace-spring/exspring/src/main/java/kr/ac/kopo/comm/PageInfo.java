package kr.ac.kopo.comm;

public class PageInfo {
	private int Page=1;	//현재 페이지 번호	yes
	private int size=5;	//한 페이지당 게시되는 게시물 건 수	yes	
	private int pageSize=3;	//페이지 리스트에 게시되는 페이지 건수	yes	
	private int totalRecordCount;	//전체 게시물 건 수	yes	
	
	private int totalPageCount;	//페이지 개수	no	totalPageCount = ((totalRecordCount-1)/recordCountPerPage) + 1
	private int firstPageNoOnPageList;	//페이지 리스트의 첫 페이지 번호	no	firstPageNoOnPageList = ((currentPageNo-1)/pageSize)*pageSize + 1
	private int lastPageNoOnPageList;	//페이지 리스트의 마지막 페이지 번호	no	lastPageNoOnPageList = firstPageNoOnPageList+pageSize-1
	private int firstRecordIndex;	//페이징 SQL의 조건절에 사용되는 시작  rownum	no	firstRecordIndex = (currentPageNo - 1) * recordCountPerPage
	private int lastRecordIndex;	//페이징 SQL의 조건절에 사용되는 마지막 rownum	no	lastRecordIndex = currentPageNo * recordCountPerPage
	//firstRecordIndex와	 lastRecordIndex는 현재 페이지 기분으로 몇페이지까지 보여야 하는가 표시
	
	private String pageHTML="";
	
	public void renderHTML() {
		totalPageCount = ((totalRecordCount-1)/size) + 1;
		firstPageNoOnPageList = ((Page-1)/pageSize)*pageSize + 1;
		lastPageNoOnPageList = firstPageNoOnPageList+pageSize-1;
		if(lastPageNoOnPageList>totalPageCount){lastPageNoOnPageList=totalPageCount;}
		firstRecordIndex = (Page - 1) * size+1;
		lastRecordIndex = Page * size;
		
		
		//이전페이지와 다음페이지가 없을 경우, [이전]과 [다음] 링크가 걸리지 않도록 설정
		pageHTML += "<div>";
		pageHTML += "<a href='#' onclick='goPage(1); return false;'>[처음]</a> "; 
		
		if((Page-1)==0) {
			pageHTML +="[이전]";
		}else {
		pageHTML += "<a href='#' onclick='goPage(" + (Page-1) + "); return false;'>[이전]</a> ";
		}
		for (int i = firstPageNoOnPageList; i <= lastPageNoOnPageList; i++) {
			if(i==Page) {
				pageHTML += "<strong>{" + i + "}</strong>;";
			}else {
			pageHTML += "<a href='#' onclick='goPage(" + i + "); return false;'>{" + i + "}</a> ";
			
			}
		}
		if((Page+1)>totalPageCount) {
			pageHTML +="[다음]";
		}else {
		pageHTML += "<a href='#' onclick='goPage(" + (Page+1) + "); return false;'>[다음]</a> ";
		}
		
		pageHTML += "<a href='#' onclick='goPage(" + totalPageCount + "); return false;'>[마지막]</a> ";
		pageHTML += "</div>";
		
		pageHTML += "<script>function goPage(p) {location.href=location.pathname +'?page='+p;}</script>";
		}
		
	

	public String getPageHTML() {
		return pageHTML;
	}



	public void setPageHTML(String pageHTML) {
		this.pageHTML = pageHTML;
	}



	public int getPage() {
		return Page;
	}

	public void setPage(int page) {
		Page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getFirstPageNoOnPageList() {
		return firstPageNoOnPageList;
	}

	public void setFirstPageNoOnPageList(int firstPageNoOnPageList) {
		this.firstPageNoOnPageList = firstPageNoOnPageList;
	}

	public int getLastPageNoOnPageList() {
		return lastPageNoOnPageList;
	}

	public void setLastPageNoOnPageList(int lastPageNoOnPageList) {
		this.lastPageNoOnPageList = lastPageNoOnPageList;
	}

	public int getFirstRecordIndex() {
		return firstRecordIndex;
	}

	public void setFirstRecordIndex(int firstRecordIndex) {
		this.firstRecordIndex = firstRecordIndex;
	}

	public int getLastRecordIndex() {
		return lastRecordIndex;
	}

	public void setLastRecordIndex(int lastRecordIndex) {
		this.lastRecordIndex = lastRecordIndex;
	}
	
	
	
	
	
	
}
