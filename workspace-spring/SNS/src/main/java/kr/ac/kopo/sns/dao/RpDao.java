package kr.ac.kopo.sns.dao;

import java.util.List;

import kr.ac.kopo.sns.model.Post;
import kr.ac.kopo.sns.model.Rp;

public interface RpDao {

	int add(Rp rp);

	Post item(int postNo);

	List<Rp> selectList(Rp rpPostNo);

	int delete(Rp rpNo);

	void update(int rpNo);

	Rp rpEditForm(Rp rpNo);

	void edit(Rp rp);










	

}
