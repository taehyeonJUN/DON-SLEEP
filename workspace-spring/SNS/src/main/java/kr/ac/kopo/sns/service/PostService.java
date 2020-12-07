package kr.ac.kopo.sns.service;

import java.util.List;

import kr.ac.kopo.sns.model.Follow;
import kr.ac.kopo.sns.model.Member;
import kr.ac.kopo.sns.model.Photo;
import kr.ac.kopo.sns.model.Post;

public interface PostService {

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

	int follow_check(Follow follow);

	void follow_add(Follow follow);

	void follow_delete(Follow follow);

	int RpAmount(int postNo);

	

}
