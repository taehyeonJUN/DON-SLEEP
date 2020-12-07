package kr.ac.kopo.sns.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.sns.dao.PhotoDao;
import kr.ac.kopo.sns.dao.PostDao;
import kr.ac.kopo.sns.model.Follow;
import kr.ac.kopo.sns.model.Member;
import kr.ac.kopo.sns.model.Photo;
import kr.ac.kopo.sns.model.Post;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostDao dao;
	
	@Autowired
	PhotoDao photoDao;
	
	private String uploadPath="d://SNS_Photo/";
	
	
	@Override
	public List<Post> list(Post vo) {
		List<Post> post=dao.list(vo);
		
		for (int i = 0; i < post.size(); i++) {
		int postNo = post.get(i).getPostNo();
		List<Photo> photos= photoDao.photoList(postNo);
		post.get(i).setAttachList(photos);
	}
		
		return post;
	}

	@Transactional
	@Override
	public int add(Post vo) {
		int num = dao.add(vo);
		
		List<MultipartFile> fileList  = vo.getUpfileList();
		
		for (MultipartFile f : fileList) {
			
			String newName=UUID.randomUUID().toString();
			try {
				f.transferTo(new File(uploadPath,newName));
				Photo phoVo = new Photo();
				phoVo.setPhoPhoto(newName);
				phoVo.setPhoPostno(vo.getPostNo());
				System.out.println(phoVo.getPhoPostno());
				if(f.isEmpty()!=true) {
					photoDao.addPhoto(phoVo);
				}
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return num;
	}

	@Override
	public void delete(int postNo) {
		dao.delete(postNo);
		
	}

	@Override
	public Post postData(int postNo) {
		return dao.postData(postNo);
	}

	@Override
	public void update(Post post) {
		dao.update(post);
	}

	@Override
	public List<Post> list(int postNo) {
		return dao.list(postNo);
	}
	
	@Override
	public int like_check(Post post) {
		
		return dao.like_check(post);
	}

	@Override
	public void like_add(Post post) {
		dao.like_add(post);
		
	}

	@Override
	public void like_delete(Post post) {
		dao.like_delete(post);
		
	}

	@Override
	public int checkLike(int poNo) {
		return dao.checkLike(poNo);
	}

	@Override
	public List<Post> newList(Post id) {
		
		List<Post> post=dao.newList(id);
		
		for (int i = 0; i < post.size(); i++) {
		int postNo = post.get(i).getPostNo();
		List<Photo> photos= photoDao.photoList(postNo);
		post.get(i).setAttachList(photos);
	}
		
		return post;
	}

	@Override
	public int follow_check(Follow follow) {
		return dao.follow_check(follow);
	}

	@Override
	public void follow_add(Follow follow) {
		dao.follow_add(follow);
	}

	@Override
	public void follow_delete(Follow follow) {
		dao.follow_delete(follow);
	}

	@Override
	public int RpAmount(int postNo) {
		return dao.RpAmount(postNo);
	}


}
