package kr.ac.kopo.sns.dao;

import java.util.List;

import kr.ac.kopo.sns.model.Member;
import kr.ac.kopo.sns.model.Post;
import kr.ac.kopo.sns.model.Rp;

public interface PostDao {

	List<Post> list(Post vo);

	int add(Post vo);

	void delete(int postNo);

	Post postData(int postNo);

	void update(Post post);

	List<Post> list(int postNo);
	
	int like_check(Post post);

	void like_add(Post post);

	void like_delete(Post post);

	int checkLike(int poNo);

	List<Post> newList(Post id);




}
