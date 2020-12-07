package kr.ac.kopo.sns.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.sns.model.Follow;
import kr.ac.kopo.sns.model.Member;
import kr.ac.kopo.sns.model.Post;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Post> list(Post vo) {
		return sql.selectList("post.list",vo);
	}

	@Override
	public int add(Post vo) {
		int num = sql.insert("post.add",vo);
		return num;
	}

	@Override
	public void delete(int postNo) {
		sql.delete("post.delete",postNo);
	}

	@Override
	public Post postData(int postNo) {
		return sql.selectOne("post.postData", postNo);
	}

	@Override
	public void update(Post post) {
		sql.update("post.update",post);
	}
	
	@Override
	public List<Post> list(int postNo) {
		return sql.selectOne("post.list", postNo);
	}

	@Override
	public int like_check(Post post) {
		return sql.selectOne("post.like_check", post);
	}

	@Override
	public void like_add(Post post) {
		sql.selectOne("post.like_add", post);
	}

	@Override
	public void like_delete(Post post) {
		sql.selectOne("post.like_delete", post);
	}

	//포스트별 좋아요 카운트
	@Override
	public int checkLike(int poNo) {
		return sql.selectOne("post.checkLike", poNo);
	}
	
	@Override
	public List<Post> newList(Post id) {
		System.out.println(id.getPostId()+"dao임플 포스트아디!!!!!");
		return sql.selectList("post.newList", id);
	}

	@Override
	public int follow_check(Follow follow) {
		return sql.selectOne("post.follow_check", follow);
	}

	@Override
	public void follow_add(Follow follow) {
		sql.insert("post.follow_add", follow);
	}

	@Override
	public void follow_delete(Follow follow) {
		sql.delete("post.follow_delete", follow);
	}

	@Override
	public int RpAmount(int postNo) {
		return sql.selectOne("post.RpAmount", postNo);
	}

}
