package kr.ac.kopo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RootController {
	 
	
	//업로드되는 파일을 지정된 경로로 저장
	ArrayList<Image> list;
	final String path = "d://upload/";
	
	public RootController() {
		list = new ArrayList<Image>();
	}
	
	@GetMapping("/")
	String index(Model model) {
		
		model.addAttribute("list",list);
		return "index";
	}
	
	
	@PostMapping("/upload")
	String upload(Image item) {
	
		// 업로드 된 파일의 정보를 멀티파트 형태로 저장
	MultipartFile file =item.getUploadFile();	
	
	
	if(file.getSize()>0) {
		System.out.println(file.getOriginalFilename());
		
		//예외가 발생되면 저장하지 않기 위해 사용
		try {
			String fileName = file.getOriginalFilename();
			
			item.setImage(fileName);//파일명이 모델에 저장되며 그것을 jsp에서 읽어옴
			
			//저장한 파일을 path로 옮기기 위해 사용
			file.transferTo(new File(path + fileName));
			list.add(item);
			//예외가 발생되면 저장하지 않기 위해 사용
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		
	}
		//db 연결을 안해서 ArrayList<Image> 사용해서 값을 담음
		
		return "redirect:";
	}
	
	@PostMapping("/upload_ajax")
	String upload_ajax(Image item, Model model) {
		upload(item);// 루트컨트롤러 내에 업로드 메소드 실행
		model.addAttribute("list", list);
		return  "list";
	}
}
