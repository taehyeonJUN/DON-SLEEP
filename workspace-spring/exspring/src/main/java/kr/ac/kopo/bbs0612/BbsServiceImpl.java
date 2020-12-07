package kr.ac.kopo.bbs0612;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service("bbsService")
//@Transactional 이 클래스의 모든 메서드들에 트랜젝션을 적용하고 싶은 경우
public class BbsServiceImpl implements BbsService {
	String uploadDir = "C:/web/upload";//업로드한 파일을 저장할 폴더
	
	@Resource
	private BbsDao bbsDao;
	
	@Resource
	private AttachDao attachDao;
	
	@Override
	public List<BbsVo> selectBbsList() {
		return bbsDao.selectBbsList();
	}

	@Override
	public BbsVo selectBbs(int bbsNo) {
		return bbsDao.selectBbs(bbsNo);
	}

	@Transactional//이 메서드를 하나의 트랜젝션으로 처리(중간에 오류발생시 이전상태로 롤백)
	public int insertBbs(BbsVo Vo) {
		
		int num=bbsDao.insertBbs(Vo);
			
		///num=10/0; //이것으로 오류가 나면 트랜젝션으로 인하여 롤백처리(저장안됨)
		
		List<MultipartFile> fileList = Vo.getUpfileList();
	
		for (MultipartFile f : fileList) {
			System.out.println(f.getOriginalFilename() + " : "+f.getSize());
			//첨부파일이 없는 경우에는 첨부파일 테이블 및 하드디스크에 첨부파일을 저장하지 않도록 구현
		
			
			//중복될 확률이 낮은 임의의 문자열을 생성하여 저장할 파일명으로 사용
			String newName=UUID.randomUUID().toString();
			
			try {
				//파일 f를 upload 폴더 아래에 지정한이름의 파일로 저장(복사)
//				(업로드폴더, 지정한 이름)
//				f.transferTo(new File(uploadDir, f.getOriginalFilename()));
				
				//랜덤값으로 지정한 이름을 변수에 담아 저장
				f.transferTo(new File(uploadDir,newName));
//				f.isEmpty()= 첨부파일이 없는 경우 true를 반환한다.
				AttachVo attachVo = new AttachVo();
				attachVo.setAttOrgName(f.getOriginalFilename());//원래 파일명
				attachVo.setAttNewName(newName);//새 파일명
				attachVo.setAttBbsNo(Vo.getBbsNo());// 첨부파일이 속한 게시글의 번호
				if(f.isEmpty()!=true){
				attachDao.insertAttach(attachVo);
				System.out.println(attachVo.getAttOrgName());
				}	
				else {
					System.out.println("첨부파일 없음");
				}
				

				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} 
			
		}
		
		return num;
	}

	@Override
	public int updateBbs(BbsVo vo) {
		return bbsDao.updateBbs(vo);
	}

	@Override
	public int deleteBbs(int bbsNo) {
		return bbsDao.deleteBbs(bbsNo);
	}

	@Override
	public AttachVo selectAttach(int attNo) {
		
		return attachDao.selectAttach(attNo);
	}

	@Override
	public File getAttachFile(AttachVo vo) {
		
		return new File(uploadDir, vo.getAttNewName());
	}

	
}
