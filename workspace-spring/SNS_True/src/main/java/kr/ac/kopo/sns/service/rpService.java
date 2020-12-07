package kr.ac.kopo.sns.service;

import java.util.List;

import kr.ac.kopo.sns.model.Post;
import kr.ac.kopo.sns.model.Rp;

public interface rpService {

	int add(Rp rp);

	Post postData(int postNo);

	List<Rp> selectList(Rp rpPostNo);

	int delete(int rpNo);

	void read(int rpNo);














}
