package kr.ac.kopo.sns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.sns.dao.RpDao;
import kr.ac.kopo.sns.model.Post;
import kr.ac.kopo.sns.model.Rp;

@Service
public class rpServiceImpl implements rpService{

	@Autowired
	RpDao dao;
	

	@Override
	public int add(Rp rp) {
		return dao.add(rp);
		}

	//선택한 게시글 조회
	@Override
	public Post postData(int postNo) {
		return dao.item(postNo);
	}

	// 선택한 게시글의 댓글 조회
	@Override
	public List<Rp> selectList(int rpPostNo) {
		return dao.selectList(rpPostNo);
	}

	@Override
	public int delete(int rpNo) {
		return dao.delete(rpNo);
	}

	@Override
	public void read(int rpNo) {
		dao.update(rpNo);
	}













	
}
