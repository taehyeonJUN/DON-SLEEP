package kr.ac.kopo.sns.dao;

import java.util.List;

import kr.ac.kopo.sns.model.Post;
import kr.ac.kopo.sns.model.Rp;

public interface RpDao {

	int add(Rp rp);

	Post item(int postNo);

	List<Rp> selectList(Rp rpPostNo);

	int delete(int rpNo);

	void update(int rpNo);










	

}
